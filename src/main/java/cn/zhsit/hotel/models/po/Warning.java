package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生
* 61947666@qq.com
* 15652963646
*/
public class Warning implements Serializable {
    /**
     *
     */
    private String warningid;

    /**
     *
     */
    private String roomid;

    /**
     *
     */
    private String warntitle;

    /**
     *
     */
    private String warntype;

    /**
     *
     */
    private Date warntime;

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
    private String warningtype;

    /**
     *
     */
    private String warnDescribe;

    /**
     *
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getWarningid() {
        return warningid;
    }

    public void setWarningid(String warningid) {
        this.warningid = warningid == null ? null : warningid.trim();
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public String getWarntitle() {
        return warntitle;
    }

    public void setWarntitle(String warntitle) {
        this.warntitle = warntitle == null ? null : warntitle.trim();
    }

    public String getWarntype() {
        return warntype;
    }

    public void setWarntype(String warntype) {
        this.warntype = warntype == null ? null : warntype.trim();
    }

    public Date getWarntime() {
        return warntime;
    }

    public void setWarntime(Date warntime) {
        this.warntime = warntime;
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

    public String getWarningtype() {
        return warningtype;
    }

    public void setWarningtype(String warningtype) {
        this.warningtype = warningtype == null ? null : warningtype.trim();
    }

    public String getWarnDescribe() {
        return warnDescribe;
    }

    public void setWarnDescribe(String warnDescribe) {
        this.warnDescribe = warnDescribe == null ? null : warnDescribe.trim();
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
        sb.append(", warningid=").append(warningid);
        sb.append(", roomid=").append(roomid);
        sb.append(", warntitle=").append(warntitle);
        sb.append(", warntype=").append(warntype);
        sb.append(", warntime=").append(warntime);
        sb.append(", optid=").append(optid);
        sb.append(", opttime=").append(opttime);
        sb.append(", warningtype=").append(warningtype);
        sb.append(", warnDescribe=").append(warnDescribe);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}