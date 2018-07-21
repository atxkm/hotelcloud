package cn.zhsit.common.models;

import cn.zhsit.common.utils.ZhsJsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2017/7/16.
 */
public class DTO {

    public static final String Success = "Success";

    public static final String Data = "Data";

    public static final String Message = "Message";

    public static final String Session = "Session";

    private Map map = new HashMap<>();

    public DTO success() {
        map.put(Success, true);
        return this;
    }

    public DTO fail() {
        map.put(Success, false);
        return this;
    }

    public DTO addVal(Object key, Object val) {
        map.put(key, val);
        return this;
    }

    @Override
    public String toString() {
        return ZhsJsonUtil.toJson(map);
    }
}
