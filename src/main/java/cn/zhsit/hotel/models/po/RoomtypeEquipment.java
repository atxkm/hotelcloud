package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class RoomtypeEquipment implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String equid;

    /**
     * 
     */
    private String typeid;

    /**
     * 
     */
    private String elecroad;

    /**
     * 
     */
    private String equtype;

    /**
     * 
     */
    private String equname;

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

    /**
     * 
     */
    private String elename;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEquid() {
        return equid;
    }

    public void setEquid(String equid) {
        this.equid = equid == null ? null : equid.trim();
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getElecroad() {
        return elecroad;
    }

    public void setElecroad(String elecroad) {
        this.elecroad = elecroad == null ? null : elecroad.trim();
    }

    public String getEqutype() {
        return equtype;
    }

    public void setEqutype(String equtype) {
        this.equtype = equtype == null ? null : equtype.trim();
    }

    public String getEquname() {
        return equname;
    }

    public void setEquname(String equname) {
        this.equname = equname == null ? null : equname.trim();
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

    public String getElename() {
        return elename;
    }

    public void setElename(String elename) {
        this.elename = elename == null ? null : elename.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", equid=").append(equid);
        sb.append(", typeid=").append(typeid);
        sb.append(", elecroad=").append(elecroad);
        sb.append(", equtype=").append(equtype);
        sb.append(", equname=").append(equname);
        sb.append(", optid=").append(optid);
        sb.append(", opttime=").append(opttime);
        sb.append(", remark=").append(remark);
        sb.append(", elename=").append(elename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}