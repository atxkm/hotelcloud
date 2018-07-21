package cn.zhsit.hotel.models.vo;

import java.util.List;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.hotel.models.po.SoftReg;

public class SoftRegVoResp {
	private ComplexPage page;
	List<SoftReg> resultlst;
	public ComplexPage getPage() {
		return page;
	}
	public void setPage(ComplexPage page) {
		this.page = page;
	}
	public List<SoftReg> getResultlst() {
		return resultlst;
	}
	public void setResultlst(List<SoftReg> resultlst) {
		this.resultlst = resultlst;
	}
}
