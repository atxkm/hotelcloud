package cn.zhsit.authority.controllers;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.EquipmentHotel;
import cn.zhsit.hotel.services.EquipmentHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@RestController
@RequestMapping("equipment")
public class EquipmentHotelController {
	@Autowired
	EquipmentHotelService equipmentHotelService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加设备
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addEquipmentHotel")
    public CommResult addEquipmentHotel(HttpServletRequest request, HttpServletResponse response,EquipmentHotel equipmentHotel) {
    	
    	equipmentHotel.setId(ZhsUnique.unique25());
    	int i = equipmentHotelService.insert(equipmentHotel);
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
     * 查找设备
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findEquipmentHotel")
    public CommResult findEquipmentHotel(HttpServletRequest request, HttpServletResponse response) {
    	
    	List<EquipmentHotel> hotellst = equipmentHotelService.selectByExample(null);
    	CommResult comm = new CommResult();
    	if(hotellst.size()>0){
	    	comm.setData(hotellst);
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
     * 修改设备
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyEquipmentHotel")
    public CommResult modifyEquipmentHotel(HttpServletRequest request, HttpServletResponse response,EquipmentHotel equipmentHotel) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(equipmentHotel.getId()!=null&&!equipmentHotel.getId().isEmpty()){
    		i = equipmentHotelService.updateByExampleSelective(equipmentHotel, null);
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
     * 删除设备
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delequipmentHotel")
    public CommResult delEquipmentHotel(HttpServletRequest request, HttpServletResponse response,EquipmentHotel equipmentHotel) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(equipmentHotel.getId()!=null&&!equipmentHotel.getId().isEmpty()){
    		i = equipmentHotelService.deleteByPrimaryKey(equipmentHotel.getId());
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
