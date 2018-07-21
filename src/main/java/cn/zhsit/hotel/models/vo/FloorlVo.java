package cn.zhsit.hotel.models.vo;

public class FloorlVo {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
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
		this.floorname = floorname;
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
		this.buildingName = buildingName;
	}

	public String getFloorstatus() {
		return floorstatus;
	}

	public FloorlVo setFloorstatus(String floorstatus) {
		this.floorstatus = floorstatus;
		return this;
	}

	public String getFloorbelong() {
		return floorbelong;
	}

	public FloorlVo setFloorbelong(String floorbelong) {
		this.floorbelong = floorbelong;
		return this;
	}
}
