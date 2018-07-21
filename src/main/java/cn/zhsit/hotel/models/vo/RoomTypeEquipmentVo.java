package cn.zhsit.hotel.models.vo;

import java.io.Serializable;
import java.util.Date;

public class RoomTypeEquipmentVo implements Serializable{
		 /**
	     * 主键
	     */
	    private String id;
	    /**
	     * 房间类型主键
	     */
		private String typeid;
		
	    /**
	     * 设备主键
	     */
	    private String equid;

	    /**
	     * 路数
	     */
	    private String elecroad;

	    /**
	     * 设备类型
	     */
	    private String equtype;
	    /**
	     * 设备名称
	     */
	    private String equname;
	    /**
	     * 操作人id
	     */
	    private String optid;
	    /**
	     * 操作时间
	     */
	    private Date opttime;
	    /**
	     * 备注
	     */
	    private String remark;

	    /**
	     * 路数名称
	     */
	    private String elename;

		public String getEquid() {
			return equid;
		}

		public void setEquid(String equid) {
			this.equid = equid;
		}

		public String getTypeid() {
			return typeid;
		}

		public void setTypeid(String typeid) {
			this.typeid = typeid;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getElecroad() {
			return elecroad;
		}

		public void setElecroad(String elecroad) {
			this.elecroad = elecroad;
		}

		public String getEqutype() {
			return equtype;
		}

		public void setEqutype(String equtype) {
			this.equtype = equtype;
		}

		public String getEquname() {
			return equname;
		}

		public void setEquname(String equname) {
			this.equname = equname;
		}

		public String getOptid() {
			return optid;
		}

		public void setOptid(String optid) {
			this.optid = optid;
		}

		public Date getOpttime() {
			return opttime;
		}

		public void setOpttime(Date opttime) {
			this.opttime = opttime;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getElename() {
			return elename;
		}

		public void setElename(String elename) {
			this.elename = elename;
		}
		
		
}
