package cn.zhsit.ws.rcu;

import cn.zhsit.common.constants.ZhsConstants;
import cn.zhsit.common.utils.ZhsFileUtils;
import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.hotel.models.dto.CloudFront;
import cn.zhsit.hotel.models.dto.CloudFrontTypeEnum;
import cn.zhsit.hotel.models.vo.HostPort;
import cn.zhsit.hotel.services.WSRCUService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Created by Administrator on 2017/10/17.
 */
@Service
public class RCUTextWebSocketHandler extends TextWebSocketHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    @Value("${rcuws.client.sysNameText:15652963646}")
    private String sysNameText;
    @Autowired
    private MessageDispatcher dispatcher;

    @Autowired
    private WSRCUService wsrcuService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("已经建立好连接");
        {   //TODO 添加认证限制，
            String sysNameText = session.getHandshakeHeaders().getFirst(ZhsConstants.Sys_Name_Text);
            sessions.put(sysNameText, session);
            //发送host和port
            sendHostPort();
        }
    }

    public void sendHostPort() {
        try {
            List<HostPort> hostPortList = wsrcuService.findAllHostPort();
            if(hostPortList==null||hostPortList.size()<1){
                return;
            }
            StringBuilder hostPorts =new StringBuilder();
            for (HostPort hostPort : hostPortList) {
                hostPorts.append(hostPort.getHost()).append(":").append(hostPort.getPort()).append(";");
            }

            //192.168.1.128:1278;192.168.1.128:1278;
//            private String hostPorts;
            List<CloudFront> list = new ArrayList<>();
            CloudFront cf=new CloudFront();
            cf.setType(CloudFrontTypeEnum.CloudSendHostPortToFrontDesk.getType());
            cf.setHostPorts(hostPorts.toString());
            list.add(cf);
            String message = ZhsJsonUtil.toJson(list);
            send(message, sysNameText);
        } catch (Exception e) {
            log.error("给前台端发送Host和port时异常", e);
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        dispatcher.dispatch(message.getPayload());
    }

    public void send(String message, String userName) throws IOException {
        WebSocketSession session = sessions.get(userName);
        if (session == null || !session.isOpen()) {
//            throw new IOException(ZhsConstants.WebSocket_Error + ",session == null or session is not Open");
//            log.info(ZhsConstants.WebSocket_Error);
            return;
        }
        try {
            TextMessage textMessage = new TextMessage(message);
            session.sendMessage(textMessage);
        } catch (Exception e) {
            log.error("", e);
        }
    }

    public void sendFile(String filePathName,String userName) throws IOException {
        WebSocketSession session = sessions.get(userName);
        BinaryMessage binaryMessage = new BinaryMessage(ZhsFileUtils.getFileIncludePathName(filePathName));
        session.sendMessage(binaryMessage);
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        log.info("链接已经关闭了");
        sessions.remove(session.getHandshakeHeaders().getFirst(ZhsConstants.Sys_Name_Text));
    }
}
