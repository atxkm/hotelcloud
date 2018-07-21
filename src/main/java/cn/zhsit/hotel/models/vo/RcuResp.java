package cn.zhsit.hotel.models.vo;

import java.util.Date;
import java.util.List;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuSettime;

public class RcuResp {
	private static final long serialVersionUID = 1L;
	
	ComplexPage page;
	
	List<Rcu> resultlst;

	public ComplexPage getPage() {
		return page;
	}

	public void setPage(ComplexPage page) {
		this.page = page;
	}

	public List<Rcu> getResultlst() {
		return resultlst;
	}

	public void setResultlst(List<Rcu> resultlst) {
		this.resultlst = resultlst;
	}

	
	
}
