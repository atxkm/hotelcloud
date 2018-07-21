package cn.zhsit.hotel.models.po;

import java.io.Serializable;

public class Enterup implements Serializable {
    /**
     *
     */
    private String enterid;

    /**
     *
     */
    private String roomid;

    /**
     *
     */
    private String guestname;

    /**
     *
     */
    private String cardno;

    /**
     *
     */
    private String entertime;

    /**
     *
     */
    private String optid;

    /**
     *
     */
    private String opttime;

    /**
     *
     */
    private String remark;

    /**
     *
     */
    private String guestmobile;

    private static final long serialVersionUID = 1L;

    public String getEnterid() {
        return enterid;
    }

    public void setEnterid(String enterid) {
        this.enterid = enterid == null ? null : enterid.trim();
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname == null ? null : guestname.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getEntertime() {
        return entertime;
    }

    public void setEntertime(String entertime) {
        this.entertime = entertime == null ? null : entertime.trim();
    }

    public String getOptid() {
        return optid;
    }

    public void setOptid(String optid) {
        this.optid = optid == null ? null : optid.trim();
    }

    public String getOpttime() {
        return opttime;
    }

    public void setOpttime(String opttime) {
        this.opttime = opttime == null ? null : opttime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getGuestmobile() {
        return guestmobile;
    }

    public void setGuestmobile(String guestmobile) {
        this.guestmobile = guestmobile == null ? null : guestmobile.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", enterid=").append(enterid);
        sb.append(", roomid=").append(roomid);
        sb.append(", guestname=").append(guestname);
        sb.append(", cardno=").append(cardno);
        sb.append(", entertime=").append(entertime);
        sb.append(", optid=").append(optid);
        sb.append(", opttime=").append(opttime);
        sb.append(", remark=").append(remark);
        sb.append(", guestmobile=").append(guestmobile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
