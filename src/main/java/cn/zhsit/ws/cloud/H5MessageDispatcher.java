package cn.zhsit.ws.cloud;

import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.constants.ZhsConstants;
import cn.zhsit.common.enums.*;
import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.collections.ToFrontDeskCollection;
import cn.zhsit.hotel.collections.ToRDBCollection;
import cn.zhsit.hotel.managers.RoomHotelManager;
import cn.zhsit.hotel.models.dto.MsgSendToRCU;
import cn.zhsit.hotel.models.dto.MsgToRDB;
import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.services.RoomStatusService;
import cn.zhsit.models.vo.FangTaiReq;
import cn.zhsit.models.vo.H5WSBody;
import cn.zhsit.models.vo.MessageReq;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
@Component
public class H5MessageDispatcher {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RoomHotelManager roomHotelManager;
    @Autowired
    private RoomStatusService roomStatusService;

    public boolean dispatch(ZhsSession zhsSession, String message) {
        H5WSBody body = ZhsJsonUtil.fromJson(message, H5WSBody.class);
        H5Code code = H5Code.of(body.getCode());
        switch (code) {
            case H5RequestFangTai:
                FangTaiReq req= requestFangTai(message);
                zhsSession.addWorker(WebSocketWorkerEnum.FangTai,req);
                break;
            case H5RequestRoomMessage:
                MessageReq mreq= messageFromH5(message);
                mreq.setPersonId(zhsSession.getPersonId());
                mreq.setMessageid(ZhsUnique.unique25());
                zhsSession.addWorker(WebSocketWorkerEnum.Message,mreq);
                addToRCUCollection(mreq);
                addToRDBCollection(mreq);
                break;
            default:
                log.error("未处理的WebSocket消息类型:{}",body.getCode());
                return false;
        }
        return true;
    }

    private FangTaiReq requestFangTai(String message) {
        H5WSBody<FangTaiReq> body = ZhsJsonUtil.fromJson(message, new TypeToken<H5WSBody<FangTaiReq>>() {
        }.getType());
        return body.getData();

    }

    private MessageReq messageFromH5(String message) {
        H5WSBody<MessageReq> body = ZhsJsonUtil.fromJson(message, new TypeToken<H5WSBody<MessageReq>>() {
        }.getType());
        return body.getData();
    }

    private void addToRDBCollection(MessageReq mreq) {
        MsgToRDB msg=new MsgToRDB();
        msg.setOperate(RDBOperate.Create);
        Message po=new Message();
        msg.setPo(po);
        po.setMessageid(mreq.getMessageid());
        po.setRoomId(mreq.getRoomId());
        po.setMessageType(MessageType.Room.getCode());
        po.setPersonId(mreq.getPersonId());
        po.setCreateTime(new Date());
        po.setReceiver(MessageActors.Customer.getCode());
        po.setSender(MessageActors.Staff.getCode());
        po.setContent(mreq.getContent());
        po.setRcuSendDateTime(new Date());
        ToRDBCollection.putToRDB(msg);
    }

    private void addToRCUCollection(MessageReq mreq) {
        if(mreq.getContent()==null){
            return;
        }
        try {
            MsgSendToRCU msg = new MsgSendToRCU();
            RoomHotel roomHotel = roomHotelManager.selectByKey(mreq.getRoomId());
            msg.setHostname(roomHotel.getRoomip());
            msg.setPort(ZhsConstants.RCUPort);
            msg.setOrder(RCUOrderEnum.XiaChuanWenZi);
            msg.setAddress(RCUAddressEnum.JiQiRenWenZi);
            msg.setDataString(mreq.getContent());
            ToFrontDeskCollection.putToRCU(msg);
        } catch (Exception e) {
            log.error("将前台聊天信息放入ToFrontDeskCollection.putToRCU(msg)时异常",e);
        }
    }
}
