package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/10/27.
 * 系统事件枚举
 */
public enum SysEventType {

    ;
    /**
     * 系统事件编号
     */
    private short code;

    /**
     * 系统事件编号名称
     */
    private String codeName;

    private SysEventType(short code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    public short getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
    }

}
