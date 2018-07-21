package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class RoomTypeHotel implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 
     */
    private String rmtypename;

    /**
     * 
     */
    private Integer typenum;

    /**
     * 
     */
    private Date opttime;

    /**
     * 
     */
    private String optid;

    /**
     * 
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRmtypename() {
        return rmtypename;
    }

    public void setRmtypename(String rmtypename) {
        this.rmtypename = rmtypename == null ? null : rmtypename.trim();
    }

    public Integer getTypenum() {
        return typenum;
    }

    public void setTypenum(Integer typenum) {
        this.typenum = typenum;
    }

    public Date getOpttime() {
        return opttime;
    }

    public void setOpttime(Date opttime) {
        this.opttime = opttime;
    }

    public String getOptid() {
        return optid;
    }

    public void setOptid(String optid) {
        this.optid = optid == null ? null : optid.trim();
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
        sb.append(", id=").append(id);
        sb.append(", rmtypename=").append(rmtypename);
        sb.append(", typenum=").append(typenum);
        sb.append(", opttime=").append(opttime);
        sb.append(", optid=").append(optid);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}