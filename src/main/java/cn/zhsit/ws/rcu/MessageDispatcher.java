package cn.zhsit.ws.rcu;

import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.hotel.collections.FromFrontDeskCollection;
import cn.zhsit.hotel.models.dto.CloudFront;
import cn.zhsit.hotel.models.dto.CloudFrontTypeEnum;
import cn.zhsit.hotel.rcu.RCU;
import cn.zhsit.hotel.rcu.RCUCache;
import cn.zhsit.hotel.rcu.XiaoQiao;
import cn.zhsit.ws.rcu.parsers.RCUStatusParser;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */
@Component
public class MessageDispatcher {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RCUStatusParser rcuStatusParser;
    @Autowired
    private RCUCache rcuCache;

    /**
     * 分发消息
     *
     * @param message
     * @return true, 分发出去；false,未分发；
     */
    public boolean dispatch(String message) {
//      log.info("收到前台端发过来的数据{}", message);
        if (message == null || message == "") {
            return false;
        }
        try {
            List<CloudFront> list = ZhsJsonUtil.fromJson(message, new TypeToken<List<CloudFront>>() {
            }.getType());
            CloudFront cf = list.get(0);
            CloudFrontTypeEnum ty = CloudFrontTypeEnum.of(cf.getType());
            switch (ty) {
                case RCUToCloud:
                    return rcuToCloud(list);
                default:
                    log.error("未有匹配前台端发过来的数据类型");
                    return false;
            }
        } catch (Exception ex) {
            log.error("分发接收的前台端数据时异常", ex);
            return false;
        }
//        return false;
    }

    //解析轮询RCU的结果
    public boolean rcuToCloud(List<CloudFront> cloudFrontList) {
        long current = System.currentTimeMillis();
        cloudFrontList.forEach(cf -> {
            String host = cf.getHost();

            RCU rcu = rcuCache.findRCU(host);
            rcu.setLastTime(current);
            String data = cf.getData();
//            [{"type":2,"host":"192.168.1.129","data":"0000DC0040BAB0DFD6D7D06C212400C0A80181024E5E63BAB22BDEA140FFFFFF00BF908D48C0A80101F7699A6FC4304AAD00E2679119005ED80000000000DC00009598000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"}]
            rcuStatusParser.parse(rcu, data);
//            rcuStatusParser.parse(rcu, data);
//            RCUInfoCollection.update(rcu);
            FromFrontDeskCollection.update(rcu);
//            if (xiaoQiao.getLastTime() > 0) {
//                RCUInfoCollection.addXiaoQiaoInfo(xiaoQiao);
//                FromFrontDeskCollection.addXiaoQiaoInfo(xiaoQiao);
//            }

        });
        return true;
    }
}
