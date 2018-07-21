package cn.zhsit.hotel.models.vo;

import java.util.Date;
import java.util.List;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.hotel.models.po.IdentifierSet;

public class IdentifierSetResp {
	 
	private ComplexPage page;
	private List<IdentifierSet> resultlst;
	

	public List<IdentifierSet> getResultlst() {
		return resultlst;
	}

	public void setResultlst(List<IdentifierSet> resultlst) {
		this.resultlst = resultlst;
	}

	public ComplexPage getPage() {
		return page;
	}

	public void setPage(ComplexPage page) {
		this.page = page;
	}
	
    
}
