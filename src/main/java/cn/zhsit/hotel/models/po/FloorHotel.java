package cn.zhsit.hotel.models.po;

import java.io.Serializable;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class FloorHotel implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String buildingId;

    /**
     * 
     */
    private Integer floor;

    /**
     * 
     */
    private String floorname;

    /**
     * 
     */
    private Integer roomnum;

    /**
     * 
     */
    private String buildingName;

    /**
     * 
     */
    private String floorstatus;

    /**
     * 
     */
    private String floorbelong;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getFloorname() {
        return floorname;
    }

    public void setFloorname(String floorname) {
        this.floorname = floorname == null ? null : floorname.trim();
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getFloorstatus() {
        return floorstatus;
    }

    public void setFloorstatus(String floorstatus) {
        this.floorstatus = floorstatus == null ? null : floorstatus.trim();
    }

    public String getFloorbelong() {
        return floorbelong;
    }

    public void setFloorbelong(String floorbelong) {
        this.floorbelong = floorbelong == null ? null : floorbelong.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", floor=").append(floor);
        sb.append(", floorname=").append(floorname);
        sb.append(", roomnum=").append(roomnum);
        sb.append(", buildingName=").append(buildingName);
        sb.append(", floorstatus=").append(floorstatus);
        sb.append(", floorbelong=").append(floorbelong);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}