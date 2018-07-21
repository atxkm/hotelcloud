package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class RoomHotel implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String roomname;

    /**
     * 
     */
    private String roomnum;

    /**
     * 
     */
    private String roomip;

    /**
     * 
     */
    private String roomtypeid;

    /**
     * 
     */
    private String roomno;

    /**
     * 
     */
    private String optid;

    /**
     * 
     */
    private String floorid;

    /**
     * 
     */
    private Date opttime;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String rmtypename;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum == null ? null : roomnum.trim();
    }

    public String getRoomip() {
        return roomip;
    }

    public void setRoomip(String roomip) {
        this.roomip = roomip == null ? null : roomip.trim();
    }

    public String getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(String roomtypeid) {
        this.roomtypeid = roomtypeid == null ? null : roomtypeid.trim();
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno == null ? null : roomno.trim();
    }

    public String getOptid() {
        return optid;
    }

    public void setOptid(String optid) {
        this.optid = optid == null ? null : optid.trim();
    }

    public String getFloorid() {
        return floorid;
    }

    public void setFloorid(String floorid) {
        this.floorid = floorid == null ? null : floorid.trim();
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

    public String getRmtypename() {
        return rmtypename;
    }

    public void setRmtypename(String rmtypename) {
        this.rmtypename = rmtypename == null ? null : rmtypename.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roomname=").append(roomname);
        sb.append(", roomnum=").append(roomnum);
        sb.append(", roomip=").append(roomip);
        sb.append(", roomtypeid=").append(roomtypeid);
        sb.append(", roomno=").append(roomno);
        sb.append(", optid=").append(optid);
        sb.append(", floorid=").append(floorid);
        sb.append(", opttime=").append(opttime);
        sb.append(", remark=").append(remark);
        sb.append(", rmtypename=").append(rmtypename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}