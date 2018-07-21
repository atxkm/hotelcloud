package cn.zhsit.authority.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.models.po.EquipmentHotel;
import cn.zhsit.hotel.models.po.IdentifierSet;
import cn.zhsit.hotel.models.po.IdentifierSetExample;
import cn.zhsit.hotel.models.vo.IdentifierSetReq;
import cn.zhsit.hotel.models.vo.IdentifierSetResp;
import cn.zhsit.hotel.services.EquipmentSetvalService;
import cn.zhsit.hotel.services.IdentifierSetService;
/**
 * 身份识别设置
 * @author ChanPin
 *
 */
@RestController
@RequestMapping("identifier")
public class IdentifierSetController {
	@Autowired
	IdentifierSetService identifierSetService;
	/**
	 * 增加身份识别设置
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addIdentifierSet")
    public CommResult addIdentifierSet(HttpServletRequest request, HttpServletResponse response,@RequestBody IdentifierSet identifierSet) {
    	
    	identifierSet.setId(ZhsUnique.unique25());
    	int i = identifierSetService.insert(identifierSet);
    	CommResult comm = new CommResult();
    	if(i>0){
	    	comm.setData(null);
	    	comm.setMessage("保存成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("保存失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    
    /**
     * 查找身份识别设置
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findIdentifierSet")
    public CommResult findIdentifierSet(HttpServletRequest request, HttpServletResponse response,@RequestBody IdentifierSetReq identifierSetReq) {
    	IdentifierSetExample example = new IdentifierSetExample();
    	Page page = new Page();
    	page.setPage(identifierSetReq.getPage().getPage().intValue());
    	page.setRows((int)identifierSetReq.getPage().getRows());
    	example.setPage(page);
    	List<IdentifierSet> hotellst = identifierSetService.selectByExample(example);
    	Long total = identifierSetService.countByExample(example);
    	CommResult comm = new CommResult();
    	IdentifierSetResp ids = new IdentifierSetResp();
    	ComplexPage comppage = new ComplexPage();
    	comppage.setPage(page.getPage().intValue());
    	comppage.setRows((int)page.getRows());
    	comppage.setTotal(total);
    	ids.setPage(comppage);
    	ids.setResultlst(hotellst);
    	if(hotellst.size()>0){
	    	comm.setData(ids);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    /**
     * 修改身份识别设置
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyIdentifierSet")
    public CommResult modifyIdentifierSet(HttpServletRequest request, HttpServletResponse response,@RequestBody IdentifierSet identifierSet) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(identifierSet.getId()!=null&&!identifierSet.getId().isEmpty()){
    		i = identifierSetService.updateByPrimaryKey(identifierSet);
    	}else{
    		comm.setMessage("id不能为空");
    		i=-1;
    	}
    	
    	if(i>0){
	    	comm.setData(null);
	    	comm.setMessage("修改成功");
	    	comm.setSuccess("true");
    	}else if(i==-1){
    		comm.setData(null);
	    	comm.setSuccess("false");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("修改失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    /**
     * 删除身份识别设置
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delIdentifierSet")
    public CommResult delIdentifierSet(HttpServletRequest request, HttpServletResponse response,@RequestBody IdentifierSet identifierSet) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(identifierSet.getId()!=null&&!identifierSet.getId().isEmpty()){
    		i = identifierSetService.deleteByPrimaryKey(identifierSet.getId());
    	}else{
    		comm.setMessage("id不能为空");
    		i=-1;
    	}
    	if(i>0){
	    	comm.setData(null);
	    	comm.setMessage("删除成功");
	    	comm.setSuccess("true");
    	}else if(i==-1){
    		comm.setData(null);
	    	comm.setSuccess("false");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("删除失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
}
