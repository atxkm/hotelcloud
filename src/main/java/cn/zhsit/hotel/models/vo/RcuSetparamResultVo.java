package cn.zhsit.hotel.models.vo;

import java.util.Date;
import java.util.List;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.models.po.RcuSetparam;

public class RcuSetparamResultVo {
	private static final long serialVersionUID = 1L;
	
	ComplexPage page;
	
	List<RcuSetparam> resultlst;

	public ComplexPage getPage() {
		return page;
	}

	public void setPage(ComplexPage page) {
		this.page = page;
	}

	public List<RcuSetparam> getResultlst() {
		return resultlst;
	}

	public void setResultlst(List<RcuSetparam> resultlst) {
		this.resultlst = resultlst;
	}

}
