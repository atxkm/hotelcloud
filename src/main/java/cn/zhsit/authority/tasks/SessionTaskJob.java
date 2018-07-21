package cn.zhsit.authority.tasks;

import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.utils.ZhsUnique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Darren on 2017/7/7.
 */
@Component
public class SessionTaskJob {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CacheHelper cacheHelper;
    private String mockSessionKey = ZhsUnique.unique25();

//    @Scheduled(fixedDelay = 1000 * 2)
    public void testGetSession() {
        log.info("testGetSession.....");
        ZhsSession session = cacheHelper.getSession(mockSessionKey);
        if (null == session) {
            log.info("session不存在");
            return;
        }
        log.info("session:{}", session.toString());
    }

//    @Scheduled(initialDelay = 1000 * 10, fixedDelay = 1000 * 60 * 30)
//    public void createSession() {
//        Person person = new Person();
//        ZhsSession session = cacheHelper.createSession(mockSessionKey, person);
//        if (null == session) {
//            log.info("未成功创建session");
//        } else {
//            log.info("新创建的session为{}", session.toString());
//        }
//    }


    private final String personId = "er12345678io";
//    @Scheduled(  fixedDelay = 1000 *1)
//    public void findPerson(){
//        Person person = cacheHelper.getPerson(personId);
//        if (null == person) {
//            log.info("查询到的用户信息为空");
//        }else{
//            log.info("查询到的用户信息:{}",person.toString());
//        }
//    }

//    @Scheduled(initialDelay = 1000 * 20, fixedDelay = 1000 * 60 * 30)
//    public void clearPerson() {
//        Person person = new Person();
//        cacheHelper.clearPersonCache(personId);
//        log.info("已经清除person数据...");
//    }
}
