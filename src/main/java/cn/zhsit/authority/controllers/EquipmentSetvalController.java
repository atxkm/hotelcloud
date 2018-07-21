package cn.zhsit.authority.controllers;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.EquipmentHotel;
import cn.zhsit.hotel.models.po.EquipmentSetval;
import cn.zhsit.hotel.services.EquipmentHotelService;
import cn.zhsit.hotel.services.EquipmentSetvalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@RestController
@RequestMapping("setval")
public class EquipmentSetvalController {
	@Autowired
	EquipmentSetvalService equipmentSetvalService;
	/**
	 * 增加设备参数设置
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addEquipmentSetval")
    public CommResult addEquipmentSetval(HttpServletRequest request, HttpServletResponse response,@RequestBody List<EquipmentSetval> equipmentSetvals) {
    	int rescount = 0;
        int res = equipmentSetvalService.insert(equipmentSetvals);
    	CommResult comm = new CommResult();
    	if(res>0){
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
     * 查找设备参数设置
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findEquipmentSetval")
    public CommResult findEquipmentSetval(HttpServletRequest request, HttpServletResponse response) {
    	CommResult comm = new CommResult();
    	try{
	    	List<EquipmentSetval> hotellst = equipmentSetvalService.selectByExample(null);
	    	
	    	if(hotellst.size()>0){
		    	comm.setData(hotellst);
		    	comm.setMessage("查询成功");
		    	comm.setSuccess("true");
	    	}else{
	    		comm.setData(null);
		    	comm.setMessage("查询成功，但没有数据");
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
     * 修改设备参数设置
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyEquipmentSetval")
    public CommResult modifyEquipmentSetval(HttpServletRequest request, HttpServletResponse response,@RequestBody List<EquipmentSetval> equipmentSetvals) {
    	int i = 0;
    	CommResult comm = new CommResult();
		i = equipmentSetvalService.updateByExampleSelective(equipmentSetvals, null);
    	
    	if(i>0){
	    	comm.setData(null);
	    	comm.setMessage("修改成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("修改失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    /**
     * 删除设备参数设置
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delequipmentSetval")
    public CommResult delequipmentSetval(HttpServletRequest request, HttpServletResponse response,@RequestBody EquipmentSetval equipmentSetval) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(equipmentSetval.getModelid()!=null&&!equipmentSetval.getModelid().isEmpty()){
    		i = equipmentSetvalService.deleteByPrimaryKey(equipmentSetval.getModelid());
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
