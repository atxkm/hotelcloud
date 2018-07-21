package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class BuildingHotel implements Serializable {
    /**
     * 
     */
    private String buildingId;

    /**
     * 
     */
    private String buildingName;

    /**
     * 
     */
    private Integer floor;

    /**
     * 
     */
    private Integer subFloor;

    /**
     * 
     */
    private Integer managerid;

    /**
     * 
     */
    private String bldManager;

    /**
     * 
     */
    private Integer num;

    /**
     * 
     */
    private Date buildyear;

    /**
     * 
     */
    private String bldimage;

    /**
     * 
     */
    private String bldarea;

    /**
     * 
     */
    private Integer unitnum;

    /**
     * 
     */
    private Date opttime;

    /**
     * 
     */
    private String iptperson;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String extfloor;

    /**
     * 
     */
    private String extsubfloor;

    private static final long serialVersionUID = 1L;

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getSubFloor() {
        return subFloor;
    }

    public void setSubFloor(Integer subFloor) {
        this.subFloor = subFloor;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public String getBldManager() {
        return bldManager;
    }

    public void setBldManager(String bldManager) {
        this.bldManager = bldManager == null ? null : bldManager.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getBuildyear() {
        return buildyear;
    }

    public void setBuildyear(Date buildyear) {
        this.buildyear = buildyear;
    }

    public String getBldimage() {
        return bldimage;
    }

    public void setBldimage(String bldimage) {
        this.bldimage = bldimage == null ? null : bldimage.trim();
    }

    public String getBldarea() {
        return bldarea;
    }

    public void setBldarea(String bldarea) {
        this.bldarea = bldarea == null ? null : bldarea.trim();
    }

    public Integer getUnitnum() {
        return unitnum;
    }

    public void setUnitnum(Integer unitnum) {
        this.unitnum = unitnum;
    }

    public Date getOpttime() {
        return opttime;
    }

    public void setOpttime(Date opttime) {
        this.opttime = opttime;
    }

    public String getIptperson() {
        return iptperson;
    }

    public void setIptperson(String iptperson) {
        this.iptperson = iptperson == null ? null : iptperson.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExtfloor() {
        return extfloor;
    }

    public void setExtfloor(String extfloor) {
        this.extfloor = extfloor == null ? null : extfloor.trim();
    }

    public String getExtsubfloor() {
        return extsubfloor;
    }

    public void setExtsubfloor(String extsubfloor) {
        this.extsubfloor = extsubfloor == null ? null : extsubfloor.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", buildingId=").append(buildingId);
        sb.append(", buildingName=").append(buildingName);
        sb.append(", floor=").append(floor);
        sb.append(", subFloor=").append(subFloor);
        sb.append(", managerid=").append(managerid);
        sb.append(", bldManager=").append(bldManager);
        sb.append(", num=").append(num);
        sb.append(", buildyear=").append(buildyear);
        sb.append(", bldimage=").append(bldimage);
        sb.append(", bldarea=").append(bldarea);
        sb.append(", unitnum=").append(unitnum);
        sb.append(", opttime=").append(opttime);
        sb.append(", iptperson=").append(iptperson);
        sb.append(", remark=").append(remark);
        sb.append(", extfloor=").append(extfloor);
        sb.append(", extsubfloor=").append(extsubfloor);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}