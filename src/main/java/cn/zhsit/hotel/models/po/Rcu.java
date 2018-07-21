package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class Rcu implements Serializable {
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
    private String roomconnect;

    /**
     * 
     */
    private String commonVersion;

    /**
     * 
     */
    private String configVersion;

    /**
     * 
     */
    private String engiNum;

    /**
     * 
     */
    private Integer setnumber;

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

    public String getRoomconnect() {
        return roomconnect;
    }

    public void setRoomconnect(String roomconnect) {
        this.roomconnect = roomconnect == null ? null : roomconnect.trim();
    }

    public String getCommonVersion() {
        return commonVersion;
    }

    public void setCommonVersion(String commonVersion) {
        this.commonVersion = commonVersion == null ? null : commonVersion.trim();
    }

    public String getConfigVersion() {
        return configVersion;
    }

    public void setConfigVersion(String configVersion) {
        this.configVersion = configVersion == null ? null : configVersion.trim();
    }

    public String getEngiNum() {
        return engiNum;
    }

    public void setEngiNum(String engiNum) {
        this.engiNum = engiNum == null ? null : engiNum.trim();
    }

    public Integer getSetnumber() {
        return setnumber;
    }

    public void setSetnumber(Integer setnumber) {
        this.setnumber = setnumber;
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
        sb.append(", rcuid=").append(rcuid);
        sb.append(", roomid=").append(roomid);
        sb.append(", roomtype=").append(roomtype);
        sb.append(", roomconnect=").append(roomconnect);
        sb.append(", commonVersion=").append(commonVersion);
        sb.append(", configVersion=").append(configVersion);
        sb.append(", engiNum=").append(engiNum);
        sb.append(", setnumber=").append(setnumber);
        sb.append(", optid=").append(optid);
        sb.append(", opttime=").append(opttime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}