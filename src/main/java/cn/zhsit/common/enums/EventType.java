package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/10/27.
 * 事件类型
 */
public enum EventType {
    /**
     * 房间事件{@link RoomEventType}
     */
    RoomEvent((byte) 1),
    /**
     * 系统事件{@link SysEventType}
     */
    SysEvent((byte) 2);

    private byte type;

    private EventType(byte type) {
        this.type = type;
    }

    public byte getType() {
        return type;
    }
}
