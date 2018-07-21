package cn.zhsit.common.enums;

import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/10/27.
 * 房间事件类型
 */
public enum RoomSetValType {
    DONGHUAXIANSHI(1, "动画显示"),
    XIAOXITANCHU(2, "消息弹出"),
    YUYINGTISHI(3, "语音提示"),
    BOFANGCISHU(4, "播放次数"),
    YOUXIAOSHIDUANG(5, "有效时段"),
    YANSHISHIJIAN(6, "延时时间"),
    XIAJIGAOWEN(7, "夏季高温"),
    DONGJIGAOWEN(8, "冬季高温"),
    XIAOFANGGAOWEN(9, "消防温度"),;

    /**
     * 设置值类别
     */
    private int code;

    /**
     * 设置值类别名称定义
     */
    private String codeName;


    private RoomSetValType(int code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }


    public static RoomSetValType of(int code) {
        RoomSetValType[] types = RoomSetValType.values();
        for (RoomSetValType type : types) {
            if ((type.code - code) == 0) {
                return type;
            }
        }
        return null;
    }

    public int code() {
        return code;
    }

    public String codeName() {
        return codeName;
    }



    public static void main8(String[] args) {
        System.out.println(RoomSetValType.XIAOFANGGAOWEN.code());
    }

}
