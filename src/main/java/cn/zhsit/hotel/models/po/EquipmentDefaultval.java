package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class EquipmentDefaultval implements Serializable {
    /**
     * 
     */
    private String modelid;

    /**
     * 
     */
    private String modelname;

    /**
     * 
     */
    private String modeltype;

    /**
     * 
     */
    private String equipment;

    /**
     * 
     */
    private String modelval;

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

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getModeltype() {
        return modeltype;
    }

    public void setModeltype(String modeltype) {
        this.modeltype = modeltype == null ? null : modeltype.trim();
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public String getModelval() {
        return modelval;
    }

    public void setModelval(String modelval) {
        this.modelval = modelval == null ? null : modelval.trim();
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
        sb.append(", modelname=").append(modelname);
        sb.append(", modeltype=").append(modeltype);
        sb.append(", equipment=").append(equipment);
        sb.append(", modelval=").append(modelval);
        sb.append(", modelsettime=").append(modelsettime);
        sb.append(", optid=").append(optid);
        sb.append(", opttime=").append(opttime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}