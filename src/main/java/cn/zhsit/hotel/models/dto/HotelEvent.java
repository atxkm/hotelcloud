package cn.zhsit.hotel.models.dto;

import cn.zhsit.common.enums.EventType;
import cn.zhsit.common.enums.RoomEventType;

/**
 * Created by Administrator on 2017/10/27.
 */
public class HotelEvent {

    /**
     * 房间事件类型
     *
     * JiQiRenWenZi 的为聊天消息，存储到t_message表中，其它的事件存储到t_warning表中
      */
    private RoomEventType roomEventType;


    /**
     * 接收人：管理员或房间 {@link cn.zhsit.common.enums.MessageActors#getCode}
     */
    private String receiver;

    /**
     * 发信人：管理员或房间 {@link cn.zhsit.common.enums.MessageActors#getCode}
     */
    private String sender;

    /**
     * RCU 的ip地址
     */
    private String host;

    /**
     * 事件描述:
     * 例如：8010房间呼叫叫车服务。
     */
    private String event;

    public RoomEventType getRoomEventType() {
        return roomEventType;
    }

    public HotelEvent setRoomEventType(RoomEventType roomEventType) {
        this.roomEventType = roomEventType;
        return this;
    }

    public String getHost() {
        return host;
    }

    public HotelEvent setHost(String host) {
        this.host = host;
        return this;
    }

    public String getEvent() {
        return event;
    }

    public HotelEvent setEvent(String event) {
        this.event = event;
        return this;
    }

    public String getReceiver() {
        return receiver;
    }

    public HotelEvent setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public HotelEvent setSender(String sender) {
        this.sender = sender;
        return this;
    }
}
