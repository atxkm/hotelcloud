package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/11/5.
 */
public enum MessageStatus {
    /**
     * 未受理
     */
    Not((byte)1),
    /**
     * 已受理
     */
    Yet((byte)2);

    private byte code;

    MessageStatus(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }
}
