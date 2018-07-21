package cn.zhsit.authority.interceptors.models;

import cn.zhsit.common.utils.ZhsJsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2017/7/7.
 */
public class Msg {
    private Map map = new HashMap();
    public static final String msg="msg";


    public Msg success() {
        map.put("rstatus", "ok");
        return this;
    }

    public Msg fail() {
        map.put("rstatus", "error");
        return this;
    }

    public Msg ajaxGo() {
        map.put("rstatus", "zhsAjaxGo");
        return this;
    }

    public Msg addVal(String key, String val) {
        map.put(key, val);
        return this;
    }

    public String toJson() {
        return ZhsJsonUtil.toJson(map);

    }
}
