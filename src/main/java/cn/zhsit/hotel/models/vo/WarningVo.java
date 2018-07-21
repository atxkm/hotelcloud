package cn.zhsit.hotel.models.vo;

import java.util.Date;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;

public class WarningVo {
	private static final long serialVersionUID = 1L;
	
	private String warningid;
	private Integer roomnum;
	private String warntitle;
	private Date warntime;
	
	private String warnDescribe;
	/**
     * 
     */
    private String buildingName;
    
    private String roomid;
    private String floor;
    
    /**
     * 
     */
    private String warntype;

    /**
     * 
     */
    private Date warnStartTime;

    private Date warnEndTime;

    private ComplexPage page;

    public ComplexPage getPage() {
        return page;
    }

    public void setPage(ComplexPage page) {
        this.page = page;
    }

    public Integer getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public Date getWarntime() {
		return warntime;
	}

	public void setWarntime(Date warntime) {
		this.warntime = warntime;
	}

	public String getWarnDescribe() {
		return warnDescribe;
	}

	public void setWarnDescribe(String warnDescribe) {
		this.warnDescribe = warnDescribe;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getWarntitle() {
		return warntitle;
	}

	public void setWarntitle(String warntitle) {
		this.warntitle = warntitle;
	}

	public String getWarningid() {
		return warningid;
	}

	public void setWarningid(String warningid) {
		this.warningid = warningid;
	}

	public String getWarntype() {
		return warntype;
	}

	public void setWarntype(String warntype) {
		this.warntype = warntype;
	}

	public Date getWarnStartTime() {
		return warnStartTime;
	}

	public void setWarnStartTime(Date warnStartTime) {
		this.warnStartTime = warnStartTime;
	}

	public Date getWarnEndTime() {
		return warnEndTime;
	}

	public void setWarnEndTime(Date warnEndTime) {
		this.warnEndTime = warnEndTime;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

}
