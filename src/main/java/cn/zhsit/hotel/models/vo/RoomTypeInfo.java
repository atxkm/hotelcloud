package cn.zhsit.hotel.models.vo;

import java.util.List;



public class RoomTypeInfo {
	private String rmtypeid;
	private String rmtypename;//房间类型名称
	private List<RoomTypeEquipmentVo> roomtypeEquipmentVo;
	
	
	public String getRmtypeid() {
		return rmtypeid;
	}
	public void setRmtypeid(String rmtypeid) {
		this.rmtypeid = rmtypeid;
	}
	public List<RoomTypeEquipmentVo> getRoomtypeEquipmentVo() {
		return roomtypeEquipmentVo;
	}
	public void setRoomtypeEquipmentVo(List<RoomTypeEquipmentVo> roomtypeEquipmentVo) {
		this.roomtypeEquipmentVo = roomtypeEquipmentVo;
	}
	
	public String getRmtypename() {
		return rmtypename;
	}
	public void setRmtypename(String rmtypename) {
		this.rmtypename = rmtypename;
	}
	
	
}
