package cn.zhsit.tasks;

import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.hotel.collections.ToFrontDeskCollection;
import cn.zhsit.hotel.models.dto.CloudFront;
import cn.zhsit.hotel.models.dto.CloudFrontTypeEnum;
import cn.zhsit.hotel.models.dto.MsgSoftUpdate;
import cn.zhsit.ws.rcu.RCUTextWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
//@Component
//@EnableScheduling
public class RCUSoftUpdateTaskTest {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Value("${rcuws.client.sysNameText:15652963646}")
    private String sysNameText;
    @Autowired
    private RCUTextWebSocketHandler rcuTextWebSocketHandler;

    @Scheduled(fixedDelay = 1000  * 10, initialDelay = 1000 * 2)
    public void sendSoftUpdate() {
        List<MsgSoftUpdate> msgList = ToFrontDeskCollection.findSoftUpdate(100);
        for (MsgSoftUpdate soft : msgList) {
            try {
                rcuTextWebSocketHandler.sendFile(soft.getFilePathName(), sysNameText);
                sendSoftUpdateMessage(soft);
            } catch (Exception e) {
                log.error("", e);
            }
        }
    }

    private void sendSoftUpdateMessage(MsgSoftUpdate soft)  throws IOException {
        List<CloudFront> cloudFrontList = new ArrayList<>();
        CloudFront cf = new CloudFront();
        cloudFrontList.add(cf);
        cf.setType(CloudFrontTypeEnum.CloudToFrontDeskRCUSoftUpdate.getType());
        cf.setData(ZhsJsonUtil.toJson(soft));
        String message = ZhsJsonUtil.toJson(cloudFrontList);
        rcuTextWebSocketHandler.send(message, sysNameText);
    }
}
