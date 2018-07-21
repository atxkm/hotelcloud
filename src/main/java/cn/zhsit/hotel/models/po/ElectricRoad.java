package cn.zhsit.hotel.models.po;

import java.io.Serializable;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class ElectricRoad implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String elename;

    /**
     * 
     */
    private String eleroad;

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

    public String getElename() {
        return elename;
    }

    public void setElename(String elename) {
        this.elename = elename == null ? null : elename.trim();
    }

    public String getEleroad() {
        return eleroad;
    }

    public void setEleroad(String eleroad) {
        this.eleroad = eleroad == null ? null : eleroad.trim();
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
        sb.append(", elename=").append(elename);
        sb.append(", eleroad=").append(eleroad);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}