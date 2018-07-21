package cn.zhsit.authority.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.models.po.EquipmentDefaultval;
import cn.zhsit.hotel.models.po.EquipmentDefaultvalExample;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.models.po.RoomHotelExample;
import cn.zhsit.hotel.models.vo.EquipmentDefaultvalReq;
import cn.zhsit.hotel.models.vo.EquipmentDefaultvalResp;
import cn.zhsit.hotel.services.EquipmentDefaultvalService;
import cn.zhsit.hotel.services.RoomHotelService;
/**
 * 设备模式预设值
 * @author ChanPin
 *
 */
@RestController
@RequestMapping("defaultval")
public class EquipmentDefaultvalController {
	@Autowired
	EquipmentDefaultvalService equipmentDefaultvalService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加房间
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addDefaultval")
    public CommResult addDefaultval(HttpServletRequest request, HttpServletResponse response,@RequestBody EquipmentDefaultvalReq equipmentDefaultvalreq) {
    	EquipmentDefaultval val = new EquipmentDefaultval();
    	BeanUtils.copyProperties(equipmentDefaultvalreq, val);
    	val.setModelid(ZhsUnique.unique25());
    	int i = equipmentDefaultvalService.insert(val);
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
     * 查找房间
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findDefaultvalList")
    public CommResult findDefaultvalList(HttpServletRequest request, HttpServletResponse response,@RequestBody EquipmentDefaultvalReq equipmentDefaultval) {
    	CommResult comm = new CommResult();
    	try{
	    	EquipmentDefaultvalExample roomhotelexample = new EquipmentDefaultvalExample();
	    	
	    	//roomhotelexample.createCriteria().andModelidEqualTo(equipmentDefaultval.getModelid());
	    	roomhotelexample.setPage(new Page().setPage(equipmentDefaultval.getPage().getPage().intValue()).setRows((int)equipmentDefaultval.getPage().getRows()));
	    	List<EquipmentDefaultval> hotellst = equipmentDefaultvalService.selectByExample(roomhotelexample);
	    	long count = equipmentDefaultvalService.countByExample(roomhotelexample);
	    	EquipmentDefaultvalResp resp = new EquipmentDefaultvalResp();
	    	resp.setResultlst(hotellst);
	    	ComplexPage page = new ComplexPage();
	    	page.setPage(equipmentDefaultval.getPage().getPage().intValue());
	    	page.setRows((int)equipmentDefaultval.getPage().getRows());
	    	page.setTotal(count);
	    	resp.setPage(page);
	    	
	    	if(hotellst.size()>0){
		    	comm.setData(resp);
		    	comm.setMessage("查询成功");
		    	comm.setSuccess("true");
	    	}else{
	    		comm.setData(resp);
		    	comm.setMessage("查询成功，没有数据");
		    	comm.setSuccess("true");
	    		
	    	}
    	}catch(Exception e){
        		comm.setData(null);
    	    	comm.setMessage("查询失败");
    	    	comm.setSuccess("false");
    	}
    	
        return comm;
    }
    /**
     * 修改房间
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyDefaultval")
    public CommResult modifyDefaultval(HttpServletRequest request, HttpServletResponse response,@RequestBody EquipmentDefaultval equipmentDefaultval) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(equipmentDefaultval.getModelid()!=null&&!equipmentDefaultval.getModelid().isEmpty()){
    		EquipmentDefaultvalExample roomhotelexample = new EquipmentDefaultvalExample();
    		roomhotelexample.createCriteria().andModelidEqualTo(equipmentDefaultval.getModelid());
    		i = equipmentDefaultvalService.updateByExampleSelective(equipmentDefaultval, roomhotelexample);
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
     * 删除房间
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delDefaultval")
    public CommResult delDefaultval(HttpServletRequest request, HttpServletResponse response,@RequestBody EquipmentDefaultval equipmentDefaultval) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(equipmentDefaultval.getModelid()!=null&&!equipmentDefaultval.getModelid().isEmpty()){
    		i = equipmentDefaultvalService.deleteByPrimaryKey(equipmentDefaultval.getModelid());
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
