package cn.zhsit.models.vo;

import com.google.gson.annotations.Expose;

/**
 * Created by Administrator on 2017/11/5.
 * 聊天消息返回对象
 */
public class MessageResp {
    /**
     *
     */
    private transient String messageid;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 收信人
     */
    private String receiver;

    /**
     * 发信人
     */
    private String sender;

    public String getContent() {
        return content;
    }

    public MessageResp setContent(String content) {
        this.content = content;
        return this;
    }

    public String getReceiver() {
        return receiver;
    }

    public MessageResp setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public MessageResp setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getMessageid() {
        return messageid;
    }

    public MessageResp setMessageid(String messageid) {
        this.messageid = messageid;
        return this;
    }

}
