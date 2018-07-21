package cn.zhsit.tasks;

import cn.zhsit.common.constants.ZhsConstants;
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
public class SendToFrontDeskTask {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Value("${rcuws.client.sysNameText:15652963646}")
    private String sysNameText;
    @Autowired
    private RCUTextWebSocketHandler rcuTextWebSocketHandler;
    int repeatErrorCount = 0;

    //发送给RCU
    @Scheduled(fixedDelay = 2000 * 1, initialDelay = 1000 * 2)
    public void sendToRCU() {
        try {
            int num = 100;
            List<MsgSendToRCU> list = ToFrontDeskCollection.findToRCU(num);
            toRCU(list);
            ToFrontDeskCollection.removeToRCU(list);
        } catch (Exception e) {
            if (e.getMessage().startsWith(ZhsConstants.WebSocket_Error)) {
                if (repeatErrorCount++ % 200 == 0) {
                    log.error(ZhsConstants.WebSocket_Error, e);
                }
            } else {
                log.error(ZhsConstants.WebSocket_Error, e);
            }
        }
    }

    private void toRCU(List<MsgSendToRCU> list) throws IOException, UnsupportedEncodingException {
        if (list == null || list.size() < 1) {
            return;
        }
        List<CloudFront> cloudFrontList = new ArrayList<>();
        for (MsgSendToRCU msg : list) {
            CloudFront cf = new CloudFront();
            cloudFrontList.add(cf);
            cf.setType(CloudFrontTypeEnum.CloudToRCU.getType());
            cf.setHost(msg.getHostname());
            cf.setPort(msg.getPort());
            int order = msg.getOrder().getOrder();
            byte[] data = new byte[1];
            data[0] = ZhsByteUtil.intToByte(order);
            int address = msg.getAddress().getAddress();
            data = ArrayUtils.addAll(data, ZhsByteUtil.intToByte2(address));
            String dataString = msg.getDataString();
            if (dataString == null || dataString == "") {
                data = ArrayUtils.add(data, (byte) 0x0);
            } else if (order == RCUOrderEnum.ShangChuanWenZi.getOrder() || order == RCUOrderEnum.XiaChuanWenZi.getOrder()) {
                if (dataString != null && dataString.length() > 0) {
                    byte[] dataArray = msg.getDataString().getBytes(ZhsConstants.GBK);
                    data = ArrayUtils.add(data, ZhsByteUtil.intToByte(dataArray.length));
                    data = ArrayUtils.addAll(data, dataArray);
                }
            } else {
                byte dataByte = Byte.valueOf(dataString);
                data = ArrayUtils.add(data, (byte) 0x1);
                data = ArrayUtils.add(data, dataByte);
            }
            cf.setData(ZhsByteUtil.bytesToHexString(data));
        }
        String message = ZhsJsonUtil.toJson(cloudFrontList);
        rcuTextWebSocketHandler.send(message, sysNameText);
    }


    //发给前台端RCU的host和port
    @Scheduled(fixedDelay = 1000 * 60 * 5, initialDelay = 1000 * 20)
    public void sendHostPortToFrontDesk() {
        rcuTextWebSocketHandler.sendHostPort();
    }

    @Scheduled(fixedDelay = 1000 * 1, initialDelay = 1000 * 2)
    public void sendToFrontDeskPerson() {
        try {
            List<MsgSendToFrontDeskPerson> list = ToFrontDeskCollection.findToFrontDeskPerson(1);
            toFrontDeskPerson(list);
            ToFrontDeskCollection.removeToFrontDeskPerson(list);
        } catch (Exception e) {
            log.error("给前台工作人员发送数据任务异常", e);
        }
    }

    private void toFrontDeskPerson(List<MsgSendToFrontDeskPerson> list) throws IOException {
        if (list == null || list.size() < 1) {
            return;
        }
        List<CloudFront> cloudFrontList = new ArrayList<>();
        for (MsgSendToFrontDeskPerson msg : list) {
            CloudFront cf = new CloudFront();
            cloudFrontList.add(cf);
            cf.setType(CloudFrontTypeEnum.CloudToFrontDeskPerson.getType());
            cf.setData(msg.getDataString());
        }
        String message = ZhsJsonUtil.toJson(cloudFrontList);
        rcuTextWebSocketHandler.send(message, sysNameText);
    }


}
