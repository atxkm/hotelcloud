package cn.zhsit.hotel.collections;

import cn.zhsit.common.enums.MessageActors;
import cn.zhsit.common.enums.MessageType;
import cn.zhsit.common.enums.RDBOperate;
import cn.zhsit.common.enums.RoomEventType;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.dto.HotelEvent;
import cn.zhsit.hotel.models.dto.MsgToRDB;
import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.models.po.RoomHotelExample;
import cn.zhsit.hotel.services.RoomHotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RoomHotelService roomHotelService;

//    @Scheduled(fixedRate = 10000) // 每10分钟执行一次
    public void getToken() {
        logger.info("getToken定时任务启动");
        HotelEvent ev = new HotelEvent();
        ev.setHost("192.168.1.1");
        ev.setEvent(RoomEventType.FangMenZhuangTai.comment());
        ev.setRoomEventType(RoomEventType.FangMenZhuangTai);
        cn.zhsit.hotel.collections.EventCollection.addEvent(ev);
        List<HotelEvent> eventlst = cn.zhsit.hotel.collections.EventCollection.readEvent();
        if(eventlst!=null && eventlst.size()>0){
            for(int i=0;i<eventlst.size();i++){
                HotelEvent aHotelEvent = eventlst.get(i);
                Message po=new Message();
                //查询房间ID
                RoomHotelExample example = new RoomHotelExample();
                example.createCriteria().andRoomipEqualTo(aHotelEvent.getHost());
                List<RoomHotel> roomlst = roomHotelService.selectByExample(example);
                if(roomlst!=null&&roomlst.size()>0) {
                    po.setMessageid(ZhsUnique.unique25());
                    po.setRoomId(roomlst.get(0).getId());
                    po.setMessageType(MessageType.Room.getCode());
                    po.setPersonId("");
                    po.setCreateTime(new Date());
                    po.setReceiver(MessageActors.Customer.getCode());
                    po.setSender(MessageActors.Staff.getCode());
                    po.setContent("");
                    po.setRcuSendDateTime(new Date());

                    MsgToRDB msg = new MsgToRDB();
                    msg.setPo(po);
                    msg.setOperate(RDBOperate.Create);
                    cn.zhsit.hotel.collections.ToRDBCollection.putToRDB(msg);
                    cn.zhsit.hotel.collections.EventCollection.removeEvent(aHotelEvent);
                }
            }
        }
    }
}
