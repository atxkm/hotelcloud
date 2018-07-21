package cn.zhsit.common.enums;

/**
 * Created by Darren on 2017/7/16.
 */
public enum  LoginStatus {
    //未登录
    NoLogin((byte)1),
    //已经登录
    Logined((byte)2),
    //锁定
    Locked((byte)3)
    ;
    private byte code;

    private LoginStatus(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

}
