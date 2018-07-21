package cn.zhsit.tasks;

import cn.zhsit.ServerApplication;
import cn.zhsit.hotel.collections.ToFrontDeskCollection;
import cn.zhsit.hotel.models.dto.MsgSoftUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/26.
 */
//@Component
//@EnableScheduling
public class MockDataRCUSoftUpdateTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedDelay = 1000 * 60 * 10, initialDelay = 1000 * 2)
    public void mockDataSendSoftUpdate() {
        try {
            MsgSoftUpdate update = new MsgSoftUpdate();
            update.setFilePathName("rcufile/网络烧写新主机IAR_stm32f407ze_ver02.bin");
            update.addHost("192.168.1.129");
            update.setVersion(111);
            ToFrontDeskCollection.putSoftUpdate(update);
        } catch (Exception e) {
            log.error("", e);
        }
    }

}
