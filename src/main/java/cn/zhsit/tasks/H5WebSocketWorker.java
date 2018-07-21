package cn.zhsit.tasks;

import cn.zhsit.ServerApplication;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.enums.WebSocketWorkerEnum;
import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.hotel.services.MessageService;
import cn.zhsit.hotel.services.RoomStatusService;
import cn.zhsit.models.vo.FangTaiReq;
import cn.zhsit.models.vo.H5WSBody;
import cn.zhsit.models.vo.MessageReq;
import cn.zhsit.models.vo.MessageResp;
import cn.zhsit.ws.cloud.H5TextWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/10/30.
 */
@Component
@EnableScheduling
public class H5WebSocketWorker {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageService messageService;
    @Autowired
    private RoomStatusService roomStatusService;
    @Autowired
    private H5TextWebSocketHandler h5TextWebSocketHandler;

    @Scheduled(fixedDelay = 1000 * 1, initialDelay = 1000 * 2)
    public void sendH5Message() {
        ConcurrentHashMap<ZhsSession, WebSocketSession> sessions = h5TextWebSocketHandler.getSessions();
        sessions.forEach((zhsSession, webSocketSession) -> {
            String personId = zhsSession.getPersonId();
            if (personId == null) {
                return;
            }
            Map<WebSocketWorkerEnum, Object> workers = zhsSession.getWebSocketWorkers();
            workers.forEach((workerEnum, obj) -> {
                switch (workerEnum) {
                    case FangTai:
                        runFangTai(personId, obj);
                        break;
                    case Message:
                        runMessage(personId, obj);
                    default:
                        log.error("定时任务未处理的任务:{}", workerEnum.name());
                }
            });
        });
    }


    private void runFangTai(String personId, Object obj) {
        try {
            FangTaiReq req = (FangTaiReq) obj;
            H5WSBody body = roomStatusService.getAllStatus(req);
            h5TextWebSocketHandler.sendMessage(personId, ZhsJsonUtil.toJson(body));
//            log.info("推送一次房态信息");
        } catch (Exception ex) {
            log.error("给H5推送房态时异常", ex);
        }
    }

    private void runMessage(String personId, Object obj) {
        try {
            MessageReq req = (MessageReq) obj;
            H5WSBody body = messageService.findNotSendMessage(req);
            List<MessageResp> list = (List<MessageResp>) body.getData();
            if(body.success==false){
            } else if (list == null || list.size() < 1) {
                return;
            }
            h5TextWebSocketHandler.sendMessage(personId, ZhsJsonUtil.toJson(body));
            if(list!=null) {
                messageService.modifySendStatus(list);
            }
        } catch (Exception ex) {
            log.error("", ex);
        }
    }
}
