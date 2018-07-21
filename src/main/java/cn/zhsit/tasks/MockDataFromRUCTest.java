package cn.zhsit.tasks;

import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.hotel.collections.FromFrontDeskCollection;
import cn.zhsit.hotel.models.dto.CloudFront;
import cn.zhsit.ws.rcu.MessageDispatcher;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */
@Component
@EnableScheduling
public class MockDataFromRUCTest {
    @Autowired
    private MessageDispatcher messageDispatcher;

    @Scheduled(fixedDelay = 1000 * 10, initialDelay = 1000 * 2)
    public void mockDataFromRCU() {
        int roomNum = 2301;
        int ip=129;
        int max=80;

        for (int i = 0; i < max; i++) {
            String host = "192.168.1." + ip++;
            String message="[{\"type\":2,\"host\":\""+host+"\""+",\"data\":\"0000DC0040BAB0DFD6D7D06C212400C0A80181024E5E63BAB22BDEA140FFFFFF00BF908D48C0A80101F7699A6FC4304AAD00E2679119005ED80000000000DC00009598000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000\"}]";
            List<CloudFront> list = ZhsJsonUtil.fromJson(message, new TypeToken<List<CloudFront>>() {
            }.getType());

            messageDispatcher.rcuToCloud(list);
        }

    }

    //            [{"type":2,"host":"192.168.1.129","data":"0000DC0040BAB0DFD6D7D06C212400C0A80181024E5E63BAB22BDEA140FFFFFF00BF908D48C0A80101F7699A6FC4304AAD00E2679119005ED80000000000DC00009598000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"}]

}
