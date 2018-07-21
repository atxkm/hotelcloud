package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/11/5.
 * 消息类型
 */
public enum  MessageType {
    /**
     * 房间消息
     */
    Room((byte)1)
    ;

    /**
     * 消息编号
     */
    private byte code;

    /**
     * 消息编号名称
     */
    private String codeName;

    MessageType(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }
}
