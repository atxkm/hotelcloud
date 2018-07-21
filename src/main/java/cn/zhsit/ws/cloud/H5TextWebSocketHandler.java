package cn.zhsit.ws.cloud;

import cn.zhsit.authority.api.models.ConstantsAuthority;
import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.common.enums.WebSocketWorkerEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/10/28.
 */
@Service
public class H5TextWebSocketHandler extends TextWebSocketHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private H5MessageDispatcher dispatcher;

    private final ConcurrentHashMap<ZhsSession, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        log.info("连接建立WebSocketSession：{}",session.getId());
        ZhsSession zhsSession = cacheHelper.getSession((String) session.getAttributes().get(ConstantsAuthority.ZhsLoginCookieName));
        sessions.put(zhsSession, session);
        LoginStatus loginStatus=zhsSession.getLoginStatus();
        if(loginStatus!=LoginStatus.Logined){
            session.close();;
        }
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        log.info("收到的消息:{}",message.getPayload());
        try {
            ZhsSession zhsSession = getSession(session);
            dispatcher.dispatch(zhsSession, message.getPayload());
//            sendMessage(zhsSession.getPersonId(),message.getPayload());
        } catch (Exception e) {
            log.error("接收分发H5消息时异常",e);
        }
    }

    public void sendMessage(String personId, String msg) {
        sessions.forEach((zhsSession, webSocketSession) -> {
            if (personId.equals(zhsSession.getPersonId())) {
                try {
                    webSocketSession.sendMessage(new TextMessage(msg));
                } catch (IOException ioe) {
                    log.error("向H5推送消息时异常，用户:{},消息:{}", personId, msg, ioe);
                }
            }
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        ZhsSession zhsSession = getSession(session);
        zhsSession.emptyWorker();
        sessions.remove(zhsSession);
        log.info("关闭,WebSocketSession.id:{},obj:{}", session.getId(),zhsSession.getSessionKey());
//        log.info("关闭obj.getPersonId:{}", zhsSession.getPersonId());
        super.afterConnectionClosed(session, status);
    }

    private ZhsSession getSession(WebSocketSession session) {
        return cacheHelper.getSession((String) session.getAttributes().get(ConstantsAuthority.ZhsLoginCookieName));
    }

    public ConcurrentHashMap<ZhsSession, WebSocketSession> getSessions() {
        return sessions;
    }
}
