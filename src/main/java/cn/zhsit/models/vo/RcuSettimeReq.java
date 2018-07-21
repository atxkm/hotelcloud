package cn.zhsit.models.vo;

import cn.zhsit.common.utils.page.ComplexPage;

public class RcuSettimeReq {
	private ComplexPage page;
	
	private String roomid;

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
	
    
}
