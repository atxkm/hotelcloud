package cn.zhsit.common.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Darren on 2017/7/8.
 */
public enum ZhsContextHandler {
    instance;

    private static Logger log = LoggerFactory.getLogger(ZhsContextHandler.class);
    private ThreadLocal<String> session = null;


    public void setSessionKey(String sessionKey) {
        if (null == session) {
            session = new ThreadLocal<>();
        }
//        log.info("设置session:{}",sessionKey);
        session.set(sessionKey);
    }

    public String getSessionKey() {
        if (null == session) {
            return null;
        }
        return session.get();
    }

    public void clear() {
        if (null != session) {
//            log.info("清除session:{}",getSessionKey());
            session.remove();
        }
//        if (null!=context) {
//            context.remove();
//        }
    }
//    public void setContext(Context ctx) {
//        if (null == context) {
//            context = new ThreadLocal<Context>();
//        }
//        context.set(ctx);
//    }
//
//    public Context getContext() {
//        if(null==context){
//            return null;
//        }
//        return context.get();
//    }

}
