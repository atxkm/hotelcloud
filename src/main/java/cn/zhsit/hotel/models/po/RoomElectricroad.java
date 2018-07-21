package cn.zhsit.hotel.models.po;

import java.io.Serializable;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class RoomElectricroad implements Serializable {
    /**
     * 
     */
    private String rmeleid;

    /**
     * 
     */
    private String typeid;

    /**
     * 
     */
    private String electric;

    /**
     * 
     */
    private String elename;

    private static final long serialVersionUID = 1L;

    public String getRmeleid() {
        return rmeleid;
    }

    public void setRmeleid(String rmeleid) {
        this.rmeleid = rmeleid == null ? null : rmeleid.trim();
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public String getElectric() {
        return electric;
    }

    public void setElectric(String electric) {
        this.electric = electric == null ? null : electric.trim();
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
        sb.append(", rmeleid=").append(rmeleid);
        sb.append(", typeid=").append(typeid);
        sb.append(", electric=").append(electric);
        sb.append(", elename=").append(elename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}