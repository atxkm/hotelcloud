package cn.zhsit.tasks;

import cn.zhsit.common.constants.ZhsConstants;
import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.enums.RCUOrderEnum;
import cn.zhsit.common.utils.ZhsByteUtil;
import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.hotel.collections.ToFrontDeskCollection;
import cn.zhsit.hotel.models.dto.CloudFront;
import cn.zhsit.hotel.models.dto.CloudFrontTypeEnum;
import cn.zhsit.hotel.models.dto.MsgSendToFrontDeskPerson;
import cn.zhsit.hotel.models.dto.MsgSendToRCU;
import cn.zhsit.ws.rcu.RCUTextWebSocketHandler;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 */
@Component
@EnableScheduling
public class MockDataSendToFrontDeskTest {
    private final Logger log = LoggerFactory.getLogger(getClass());
    int i = 1;

    /**
     * 下发给RCU的指令demo
     */
    @Scheduled(fixedDelay = 1000 * 60 * 2)
    private void mockToRCuData() {
        MsgSendToRCU msg = new MsgSendToRCU();
        msg.setHostname("192.168.1.129")
                .setPort(1278)
                .setOrder(RCUOrderEnum.PCWriteRCU)
                .setAddress(RCUAddressEnum.DengGuang130);

        if (i++ % 2 == 0) {
            msg.setDataString("100");
        } else {
            msg.setDataString("0");
        }
        ToFrontDeskCollection.putToRCU(msg);
    }

    int mockNum = 1101;

    /**
     * 下发给前台工作人员的demo
     */
    @Scheduled(fixedDelay = 1000 * 60 * 3)
    private void mockToFrontDeskPerson() {
        MsgSendToFrontDeskPerson msg = new MsgSendToFrontDeskPerson();
        msg.setDataString(mockNum++ + "房间客户退房");
        ToFrontDeskCollection.putToFrontDeskPerson(msg);
    }

}
