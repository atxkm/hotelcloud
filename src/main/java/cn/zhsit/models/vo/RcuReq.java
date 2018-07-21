package cn.zhsit.models.vo;

import cn.zhsit.common.utils.page.ComplexPage;

public class RcuReq {
	private ComplexPage page;
	
	private String roomid;

	private String floorid;

	public ComplexPage getPage() {
		return page;
	}

	public void setPage(ComplexPage page) {
		this.page = page;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getFloorid() {
		return floorid;
	}

	public void setFloorid(String floorid) {
		this.floorid = floorid;
	}
}
