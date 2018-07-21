package cn.zhsit.hotel.models.vo;

import java.util.Date;
import java.util.List;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.hotel.models.po.EquipmentDefaultval;

public class EquipmentDefaultvalResp {
	private ComplexPage page;
	private List<EquipmentDefaultval> resultlst;
	public ComplexPage getPage() {
		return page;
	}
	public void setPage(ComplexPage page) {
		this.page = page;
	}
	public List<EquipmentDefaultval> getResultlst() {
		return resultlst;
	}
	public void setResultlst(List<EquipmentDefaultval> resultlst) {
		this.resultlst = resultlst;
	}
	
    
    
}
