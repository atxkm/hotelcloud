package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class SoftReg implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String machineno;

    /**
     * 
     */
    private String regnumber;

    /**
     * 
     */
    private Date startdate;

    /**
     * 
     */
    private Date enddate;

    /**
     * 0£ºÆôÓÃ£¬1£ºÍ£ÓÃ
     */
    private String regstatus;

    /**
     * ·ÖÅä¸øÓÃ»§Ê¹ÓÃ
     */
    private String userno;

    /**
     * 
     */
    private Date assigtime;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMachineno() {
        return machineno;
    }

    public void setMachineno(String machineno) {
        this.machineno = machineno == null ? null : machineno.trim();
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber == null ? null : regnumber.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getRegstatus() {
        return regstatus;
    }

    public void setRegstatus(String regstatus) {
        this.regstatus = regstatus == null ? null : regstatus.trim();
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno == null ? null : userno.trim();
    }

    public Date getAssigtime() {
        return assigtime;
    }

    public void setAssigtime(Date assigtime) {
        this.assigtime = assigtime;
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
        sb.append(", username=").append(username);
        sb.append(", machineno=").append(machineno);
        sb.append(", regnumber=").append(regnumber);
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", regstatus=").append(regstatus);
        sb.append(", userno=").append(userno);
        sb.append(", assigtime=").append(assigtime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}