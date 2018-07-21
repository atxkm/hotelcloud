package cn.zhsit.models.vo;

/**
 * Created by Administrator on 2017/11/5.
 */
public class MessageReq {
    /**
     * id
     */
    private transient String messageid;
    private transient String personId;
    /**
     * 房间id
     */
    private String roomId;

    /**
     * 消息内容
     */
    private String content;

    public String getRoomId() {
        return roomId;
    }

    public MessageReq setRoomId(String roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public MessageReq setContent(String content) {
        this.content = content;
        return this;
    }

    public String getMessageid() {
        return messageid;
    }

    public MessageReq setMessageid(String messageid) {
        this.messageid = messageid;
        return this;
    }

    public String getPersonId() {
        return personId;
    }

    public MessageReq setPersonId(String personId) {
        this.personId = personId;
        return this;
    }
}
