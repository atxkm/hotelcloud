package cn.zhsit.common.models;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhsit on 2016/8/20.
 */
public class Context {

    private HttpSession session;
    private Map<String, Object> params = null;

    public HttpSession getSession() {
        return session;
    }

    public Context setSession(HttpSession session) {
        this.session = session;
        return this;
    }

    public Object setParam(String key, Object val) {
        if (val != null) {
            if (params == null) {
                params = new HashMap<>();
            }
            return params.put(key, val);
        }
        return val;
    }

    public Object getParam(String key) {
        if(null==params){
            return null;
        }
        return params.get(key);
    }
}
