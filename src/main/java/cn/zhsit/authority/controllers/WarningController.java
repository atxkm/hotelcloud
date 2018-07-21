package cn.zhsit.authority.controllers;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.po.Warning;
import cn.zhsit.hotel.models.po.WarningExample;
import cn.zhsit.hotel.models.po.WarningExample.Criteria;
import cn.zhsit.hotel.models.vo.WarningResultVo;
import cn.zhsit.hotel.models.vo.WarningVo;
import cn.zhsit.hotel.services.WarningService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 房间类型信息管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("warning")
public class WarningController {
	@Autowired
	WarningService warningService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加房间类型
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addWarning")
    public CommResult addWarning(HttpServletRequest request, HttpServletResponse response, Warning warning) {
    	
    	warning.setWarningid(ZhsUnique.unique25());
    	int i = warningService.insertSelective(warning);
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
     * 查找房间类型
     * @param request
     * @param response
     * @return
     */
   /* @RequestMapping("/findWarningById")
    public CommResult findWarningById(HttpServletRequest request, HttpServletResponse response,Warning roomType) {
    	
    	Warning warning = warningService.selectById(roomType.getWarningid());
    	CommResult comm = new CommResult();
    	if(warning!=null){
	    	comm.setData(warning);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }*/
    
    /**
     * 查找房间类型
     * @param request
     * @param response
     * @return
     */
   /* @RequestMapping("/findWarningList")
    public CommResult findWarningList(HttpServletRequest request, HttpServletResponse response,WarningExample roomType) {
    	
    	List<Warning> warning = warningService.selectByExample(roomType);
    	CommResult comm = new CommResult();
    	if(warning!=null){
	    	comm.setData(warning);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }*/
    /**
     * 修改事件状态
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyWarning")
    public CommResult modifyWarning(HttpServletRequest request, HttpServletResponse response,Warning roomType) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(roomType.getWarningid()!=null&&!roomType.getWarningid().isEmpty()){
    		i = warningService.updateById(roomType);
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
     * 事件查询接口
     * @param example
     * @return
     */
    @RequestMapping("/findWarningList")
    public Object findWarningList(HttpServletRequest request, HttpServletResponse response,@RequestBody WarningVo warningVo){
    	
    	WarningExample example = new WarningExample();
    	example.setDistinct(true);
    	long pagestart = 0;
    	if(warningVo.getPage().getPage()*warningVo.getPage().getRows()==0){
    		pagestart = 0;
    	}else{
    		pagestart = warningVo.getPage().getPage()*warningVo.getPage().getRows()+1;
    	}
    	
    	warningVo.getPage().setPageStart(pagestart);
    	WarningResultVo vo = warningService.selectByBuilding(warningVo);
    	CommResult comm = new CommResult();
    	if(vo.getResultlst().size()>0){
	    	comm.setData(vo);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("查询成功，但没有数据");
	    	comm.setSuccess("true");
    	}
    	return comm;
    }
    /**
     * 删除房间类型
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
   /* @RequestMapping("/delWarning")
    public CommResult delWarning(HttpServletRequest request, HttpServletResponse response,Warning warning) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(warning.getWarningid()!=null&&!warning.getWarningid().isEmpty()){
    		i = warningService.deleteById(warning.getWarningid());
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
    }*/
    

}
