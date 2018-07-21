package cn.zhsit.authority.controllers;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.hotel.models.po.RoomTypeHotel;
import cn.zhsit.hotel.models.vo.RoomTypeInfo;
import cn.zhsit.hotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 房间类型信息管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("roomtype")
public class RoomTypeController {
	@Autowired
	RoomTypeService roomTypeService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加房间类型
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addRoomType")
    public CommResult addRoomType(HttpServletRequest request, HttpServletResponse response,@RequestBody RoomTypeInfo roomType) {
    	
    	
    	int i = roomTypeService.insert(roomType);
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
    @RequestMapping("/findRoomtypeHotel")
    public CommResult findRoomtypeHotel(HttpServletRequest request, HttpServletResponse response,RoomTypeInfo roomType) {
    	
    	List<RoomTypeInfo> hotellst = roomTypeService.selectById(roomType.getRmtypeid());
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
    
    @RequestMapping("/findRoomtypeHotels")
    public CommResult findRoomtypeHotels(HttpServletRequest request, HttpServletResponse response,RoomTypeInfo roomType) {
    	
    	List<RoomTypeInfo> hotellst = roomTypeService.selectRoomList(null);
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
     * 修改房间类型
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyRoomTypeHotel")
    public CommResult modifyRoomTypeHotel(HttpServletRequest request, HttpServletResponse response,@RequestBody RoomTypeInfo roomType) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(roomType.getRmtypeid()!=null&&!roomType.getRmtypeid().isEmpty()){
    		i = roomTypeService.updateById(roomType);
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
     * 删除房间类型
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delRoomTypeHotel")
    public CommResult delRoomTypeHotel(HttpServletRequest request, HttpServletResponse response, RoomTypeHotel roombean) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(roombean.getId()!=null&&!roombean.getId().isEmpty()){
    		i = roomTypeService.deleteByPrimaryKey(roombean.getId());
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
