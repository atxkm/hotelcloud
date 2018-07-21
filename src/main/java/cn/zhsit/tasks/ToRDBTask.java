package cn.zhsit.tasks;

import cn.zhsit.common.enums.RDBOperate;
import cn.zhsit.hotel.collections.ToRDBCollection;
import cn.zhsit.hotel.managers.MessageManager;
import cn.zhsit.hotel.managers.WarningManager;
import cn.zhsit.hotel.models.dto.MsgToRDB;
import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.Warning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
@Component
@EnableScheduling
public class ToRDBTask {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WarningManager warningManager;
    @Autowired
    private MessageManager messageManager;

    @Scheduled(fixedDelay = 100, initialDelay = 1000 * 1)
    public void toRDB() {
        List<MsgToRDB> list = ToRDBCollection.findToRDB(10);
        list.forEach(msg -> {
            try {
                Object po = msg.getPo();
                if (po instanceof Message) {
                    message((Message) po, msg.getOperate());
                } else if (po instanceof Warning) {
                    warning((Warning) po, msg.getOperate());
                }
            } catch (Exception e) {
                log.error("",e);
            }
            ToRDBCollection.remove(msg);
        });
    }

    private void warning(Warning po, RDBOperate operate) {
        switch (operate) {
            case Create:
                warningManager.add(po);
                break;
            default:
                log.error("ToRDBTask未解析Warning 对应的operate:{}", operate.name());
        }
    }
    private void message(Message po, RDBOperate operate) {
        switch (operate) {
            case Create:
                messageManager.add(po);
                break;
            default:
                log.error("ToRDBTask未解析Message 对应的operate:{}", operate.name());
        }
    }
}
