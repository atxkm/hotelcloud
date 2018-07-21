package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/11/22.
 * 楼层存在或不存在的枚举类
 */
public enum FloorStatus {
    //存在的
    CunZai("0"),
    //不存在的
    BuCunZai("1")
    ;

    //    楼层状态(0,1)
    private String code;

    FloorStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
