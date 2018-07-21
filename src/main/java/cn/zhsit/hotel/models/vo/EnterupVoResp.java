package cn.zhsit.hotel.models.vo;

import java.util.List;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.hotel.models.po.Enterup;

public class EnterupVoResp {
	private ComplexPage page;
	List<Enterup> resultlst;
	public ComplexPage getPage() {
		return page;
	}

	public void setPage(ComplexPage page) {
		this.page = page;
	}

	public List<Enterup> getResultlst() {
		return resultlst;
	}

	public void setResultlst(List<Enterup> resultlst) {
		this.resultlst = resultlst;
	}

	
	
	
}
