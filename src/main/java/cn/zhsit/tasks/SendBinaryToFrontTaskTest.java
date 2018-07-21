package cn.zhsit.tasks;

import cn.zhsit.ws.rcu.RCUTextWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/24.
 */
//@Component
//@EnableScheduling
public class SendBinaryToFrontTaskTest {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Value("${rcuws.client.sysNameText:15652963646}")
    private String sysNameText;
    @Autowired
    private RCUTextWebSocketHandler rcuTextWebSocketHandler;


    //发送给RCU
    @Scheduled(fixedDelay = 1000 * 10, initialDelay = 1000 * 2)
    public void sendToRCU() {
        try {
            rcuTextWebSocketHandler.sendFile("rcufile/主机程序.bin", sysNameText);
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
