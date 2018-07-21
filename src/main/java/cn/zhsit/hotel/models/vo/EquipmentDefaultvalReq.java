package cn.zhsit.hotel.models.vo;

import java.util.Date;

import cn.zhsit.common.utils.page.ComplexPage;

public class EquipmentDefaultvalReq {
	 
	private ComplexPage page;
	/**
     * 
     */
    private String modelid;

    /**
     * 
     */
    private String modelname;

    /**
     * 
     */
    private String modeltype;

    /**
     * 
     */
    private String equipment;

    /**
     * 
     */
    private String modelval;

    /**
     * 
     */
    private String modelsettime;

    /**
     * 
     */
    private String optid;

    /**
     * 
     */
    private Date opttime;

    /**
     * 
     */
    private String remark;
    
    
	public ComplexPage getPage() {
		return page;
	}

	public void setPage(ComplexPage page) {
		this.page = page;
	}

	public String getModelid() {
		return modelid;
	}

	public void setModelid(String modelid) {
		this.modelid = modelid;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getModeltype() {
		return modeltype;
	}

	public void setModeltype(String modeltype) {
		this.modeltype = modeltype;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getModelval() {
		return modelval;
	}

	public void setModelval(String modelval) {
		this.modelval = modelval;
	}

	public String getModelsettime() {
		return modelsettime;
	}

	public void setModelsettime(String modelsettime) {
		this.modelsettime = modelsettime;
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
    
    
}
