package cn.zhsit.hotel.rcu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/22.
 */
@Component
public class RCUCache {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    //TODO 补充查询条件
    //根据host查询RCU
    @Cacheable(value = "RCU")
    public RCU findRCU(String host){
//        log.info("生成新的RCU");
        return new RCU().setHost(host);
    }
}
