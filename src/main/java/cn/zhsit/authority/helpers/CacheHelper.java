package cn.zhsit.authority.helpers;

import cn.zhsit.authority.api.models.ConstantsAuthority;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by Darren on 2017/7/7.
 */
@Component
public class CacheHelper {
    private static Logger log = LoggerFactory.getLogger(CacheHelper.class);


    @Cacheable(value = ConstantsAuthority.CacheKey.SessionCacheName, key = "#sessionKey", unless = "#result == null")
    public ZhsSession getSession(String sessionKey) {
//        log.info("新生成Session:" + sessionKey);
        return new ZhsSession(sessionKey);
    }



//    @CachePut(value = ConstantsAuthority.SessionCacheName, key = "#sessionKey", unless = "#result == null")
//    public ZhsSession createSession(String sessionKey) {
//        return new ZhsSession(sessionKey);
//    }
//
//    @CachePut(value = ConstantsAuthority.SessionCacheName, key = "#sessionKey", unless = "#result == null")
//    public ZhsSession createSession(String sessionKey, Person person) {
//        Wrapper<Person> wrapper = new Wrapper<Person>();
//        wrapper.setOpera(Wrapper.Opera.Find);
//        wrapper.setT(person);
//        Wrapper<Person> backWrapper = personServiceAuthority.personOpera(wrapper);
//        if (backWrapper.getSuccess() != Boolean.TRUE) {
//            return null;
//        }
//        return new ZhsSession().setSessionKey(sessionKey).put(ZhsSession.person, wrapper.getT());
//    }



//    @CacheEvict(value = ConstantsAuthority.ZhsPersonCacheName,key =  "#personId")
//    public void clearPersonCache(String personId) {}
}
