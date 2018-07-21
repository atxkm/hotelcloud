package cn.zhsit.hotel.models.vo;

import java.util.List;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.hotel.models.po.RoomHotel;

public class RoomHotelVo {
	private ComplexPage page;
	
	private String floorid;
	private String buildingId;
	private String host;
	private List<RoomHotelBeanVo> resultlst;
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	public ComplexPage getPage() {
		return page;
	}
	
	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public void setPage(ComplexPage page) {
		this.page = page;
	}
	public String getFloorid() {
		return floorid;
	}
	public void setFloorid(String floorid) {
		this.floorid = floorid;
	}
	public List<RoomHotelBeanVo> getResultlst() {
		return resultlst;
	}
	public void setResultlst(List<RoomHotelBeanVo> resultlst) {
		this.resultlst = resultlst;
	}
	
	
}
