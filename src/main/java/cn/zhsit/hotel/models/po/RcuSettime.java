package cn.zhsit.hotel.models.po;

import java.io.Serializable;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class RcuSettime implements Serializable {
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
    private String roomtype;

    /**
     * 
     */
    private String link;

    /**
     * 
     */
    private String millisecondth;

    /**
     * 
     */
    private String millisecondtw;

    /**
     * 
     */
    private String second;

    /**
     * 
     */
    private String minutes;

    /**
     * 
     */
    private String hour;

    /**
     * 
     */
    private String torevise;

    /**
     * 
     */
    private String remark;

    private static final long serialVersionUID = 1L;

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

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getMillisecondth() {
        return millisecondth;
    }

    public void setMillisecondth(String millisecondth) {
        this.millisecondth = millisecondth == null ? null : millisecondth.trim();
    }

    public String getMillisecondtw() {
        return millisecondtw;
    }

    public void setMillisecondtw(String millisecondtw) {
        this.millisecondtw = millisecondtw == null ? null : millisecondtw.trim();
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second == null ? null : second.trim();
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes == null ? null : minutes.trim();
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour == null ? null : hour.trim();
    }

    public String getTorevise() {
        return torevise;
    }

    public void setTorevise(String torevise) {
        this.torevise = torevise == null ? null : torevise.trim();
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
        sb.append(", rcuid=").append(rcuid);
        sb.append(", roomid=").append(roomid);
        sb.append(", roomtype=").append(roomtype);
        sb.append(", link=").append(link);
        sb.append(", millisecondth=").append(millisecondth);
        sb.append(", millisecondtw=").append(millisecondtw);
        sb.append(", second=").append(second);
        sb.append(", minutes=").append(minutes);
        sb.append(", hour=").append(hour);
        sb.append(", torevise=").append(torevise);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}