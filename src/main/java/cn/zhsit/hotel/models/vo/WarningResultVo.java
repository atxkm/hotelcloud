package cn.zhsit.hotel.models.vo;

import java.util.Date;
import java.util.List;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;

public class WarningResultVo {
	private static final long serialVersionUID = 1L;
	
	ComplexPage page;
	
	List<WarningVo> resultlst;

	public ComplexPage getPage() {
		return page;
	}

	public void setPage(ComplexPage page) {
		this.page = page;
	}

	public List<WarningVo> getResultlst() {
		return resultlst;
	}

	public void setResultlst(List<WarningVo> resultlst) {
		this.resultlst = resultlst;
	}
	
}
