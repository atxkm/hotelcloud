package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class Message implements Serializable {
    /**
     * 
     */
    private String messageid;

    /**
     * 房间ID
     */
    private String roomId;

    /**
     * 消息类型 {@link cn.zhsit.common.enums.MessageType#getCode}
     */
    private Byte messageType;

    /**
     * 接收人：管理员或房间 {@link cn.zhsit.common.enums.MessageActors#getCode}
     */
    private String receiver;

    /**
     * 发信人：管理员或房间 {@link cn.zhsit.common.enums.MessageActors#getCode}
     */
    private String sender;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private String pri;

    /**
     * 管理员ID
     */
    private String personId;

    /**
     * 发送状态 : {@link cn.zhsit.common.enums.MessageStatus#getCode}
     */
    private Byte sendStatus;

    /**
     * 
     */
    private Date sendDateTime;

    /**
     * 播报状态 : {@link cn.zhsit.common.enums.MessageStatus#getCode}
     */
    private Byte speakStatus;

    /**
     * 
     */
    private Date speakDateTime;

    /**
     * 发送给RCU状态 : {@link cn.zhsit.common.enums.MessageStatus#getCode}
     */
    private Byte rcuSendStauts;

    /**
     * 
     */
    private Date rcuSendDateTime;

    /**
     * 
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid == null ? null : messageid.trim();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri == null ? null : pri.trim();
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public Byte getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Date getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(Date sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public Byte getSpeakStatus() {
        return speakStatus;
    }

    public void setSpeakStatus(Byte speakStatus) {
        this.speakStatus = speakStatus;
    }

    public Date getSpeakDateTime() {
        return speakDateTime;
    }

    public void setSpeakDateTime(Date speakDateTime) {
        this.speakDateTime = speakDateTime;
    }

    public Byte getRcuSendStauts() {
        return rcuSendStauts;
    }

    public void setRcuSendStauts(Byte rcuSendStauts) {
        this.rcuSendStauts = rcuSendStauts;
    }

    public Date getRcuSendDateTime() {
        return rcuSendDateTime;
    }

    public void setRcuSendDateTime(Date rcuSendDateTime) {
        this.rcuSendDateTime = rcuSendDateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageid=").append(messageid);
        sb.append(", roomId=").append(roomId);
        sb.append(", messageType=").append(messageType);
        sb.append(", receiver=").append(receiver);
        sb.append(", sender=").append(sender);
        sb.append(", content=").append(content);
        sb.append(", pri=").append(pri);
        sb.append(", personId=").append(personId);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", sendDateTime=").append(sendDateTime);
        sb.append(", speakStatus=").append(speakStatus);
        sb.append(", speakDateTime=").append(speakDateTime);
        sb.append(", rcuSendStauts=").append(rcuSendStauts);
        sb.append(", rcuSendDateTime=").append(rcuSendDateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}