package cn.zhsit.models.vo;

import cn.zhsit.common.models.DTO;
import cn.zhsit.common.utils.ZhsJsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/29.
 */
public class BaseVO {

//    public static final String Success = "Success";
    public static final String Success = "success";

//    public static final String Data = "Data";
    public static final String Data = "data";

//    public static final String Message = "Message";
    public static final String Message = "message";

//    public static final String Session = "Session";
    public static final String Session = "session";

    private Map map = new HashMap<>();

    public BaseVO success() {
        map.put(Success, true);
        return this;
    }

    public BaseVO fail() {
        map.put(Success, false);
        return this;
    }

    public BaseVO addVal(Object key, Object val) {
        map.put(key, val);
        return this;
    }

    @Override
    public String toString() {
        return ZhsJsonUtil.toJson(map);
    }
}
