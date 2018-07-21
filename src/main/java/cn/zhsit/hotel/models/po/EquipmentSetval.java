package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class EquipmentSetval implements Serializable {
    /**
     * 
     */
    private String modelid;

    /**
     * 
     */
    private String paramname;

    /**
     * 0£º·¿Ì¬ÏÔÊ¾£¬1£ººô½ÐÉèÖÃ
     */
    private String topparamtype;

    /**
     * 0£º·¿ÃÅ£¬1£º±£ÏÕÏä£¬3£º·þÎñÇëÇó£¬4£º¸æ¾¯ÉèÖÃ£¬5£ºÆäËü
     */
    private String parambelongtype;

    /**
     * 0:·¿ÃÅ×´Ì¬£¬1£º±£ÏÕÏä×´Ì¬£¬2£ºÇëÎð´òÈÅ£¬
            3£ºÇëÇó´òÉ¨£¬4£º½ô¼±ºô½Ð£¬5£º·¿ÃÅÒì³££¬
            6£ºÍË·¿Ô¤Ô¼£¬7£ººô½ÐÇëÇó£¬8£ºÎÂ¶ÈÒì³££¬
            9£ºÏû·À¾¯¸æ£¬10£ºÏÔÊ¾·¿¼ä×´Ì¬£¬11£ºÏÔÊ¾Éí·ÝÊ¶±ð£¬
            12£ºÏÔÊ¾·¿¼äÎÂ¶È£¬13£ºÏÔÊ¾·¿¼ä·çÕû£¬14£ºÏÔÊ¾Í¨Ñ¶ÖÐ¶Ï
            15£ºÇëÇóÇåÀí£¬16£ººô½Ð·þÎñ£¬17£ºÍË·¿Ô¤¸æ£¬18£º½ô¼±ºô½Ð£¬19£º·¿ÃÅÒì³££¬
            20£ºÎÂ¶ÈÒì³££¬21£ºÏû·À¸æ¾¯
     */
    private String paramtype;

    /**
     * 0:Ä¬ÈÏÖµ£¨ÓÃÓÚ·¿Ì¬ÏÔÊ¾£©£¬1£º¶¯»­ÏÔÊ¾£¬2£ºÏûÏ¢µ¯³ö£¬3£ºÓïÒôÌáÊ¾£¬4:²¥·Å´ÎÊý£¬5£ºÓÐÐ§Ê±¶Î£¬6£ºÑÓÊ±Ê±¼ä£¬7£ºÏÄ¼¾¸ßÎÂ£¬8£º¶¬¼¾¸ßÎÂ£¬9£ºÏû·ÀÎÂ¶È
     */
    private String setvaltype;

    /**
     * 
     */
    private String setval;

    /**
     * 
     */
    private String rcuid;

    /**
     * 
     */
    private String roomid;

    /**
     * 
     */
    private String modelsettime;

    /**
     * 
     */
    private String optid;

    /**
     * 
     */
    private Date opttime;

    /**
     * 
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid == null ? null : modelid.trim();
    }

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname == null ? null : paramname.trim();
    }

    public String getTopparamtype() {
        return topparamtype;
    }

    public void setTopparamtype(String topparamtype) {
        this.topparamtype = topparamtype == null ? null : topparamtype.trim();
    }

    public String getParambelongtype() {
        return parambelongtype;
    }

    public void setParambelongtype(String parambelongtype) {
        this.parambelongtype = parambelongtype == null ? null : parambelongtype.trim();
    }

    public String getParamtype() {
        return paramtype;
    }

    public void setParamtype(String paramtype) {
        this.paramtype = paramtype == null ? null : paramtype.trim();
    }

    public String getSetvaltype() {
        return setvaltype;
    }

    public void setSetvaltype(String setvaltype) {
        this.setvaltype = setvaltype == null ? null : setvaltype.trim();
    }

    public String getSetval() {
        return setval;
    }

    public void setSetval(String setval) {
        this.setval = setval == null ? null : setval.trim();
    }

    public String getRcuid() {
        return rcuid;
    }

    public void setRcuid(String rcuid) {
        this.rcuid = rcuid == null ? null : rcuid.trim();
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public String getModelsettime() {
        return modelsettime;
    }

    public void setModelsettime(String modelsettime) {
        this.modelsettime = modelsettime == null ? null : modelsettime.trim();
    }

    public String getOptid() {
        return optid;
    }

    public void setOptid(String optid) {
        this.optid = optid == null ? null : optid.trim();
    }

    public Date getOpttime() {
        return opttime;
    }

    public void setOpttime(Date opttime) {
        this.opttime = opttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", modelid=").append(modelid);
        sb.append(", paramname=").append(paramname);
        sb.append(", topparamtype=").append(topparamtype);
        sb.append(", parambelongtype=").append(parambelongtype);
        sb.append(", paramtype=").append(paramtype);
        sb.append(", setvaltype=").append(setvaltype);
        sb.append(", setval=").append(setval);
        sb.append(", rcuid=").append(rcuid);
        sb.append(", roomid=").append(roomid);
        sb.append(", modelsettime=").append(modelsettime);
        sb.append(", optid=").append(optid);
        sb.append(", opttime=").append(opttime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}