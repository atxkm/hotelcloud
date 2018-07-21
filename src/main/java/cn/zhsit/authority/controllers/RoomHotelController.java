package cn.zhsit.authority.controllers;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.models.po.RoomHotelExample;
import cn.zhsit.hotel.models.vo.RoomHotelBeanVo;
import cn.zhsit.hotel.models.vo.RoomHotelVo;
import cn.zhsit.hotel.services.RoomHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房间信息管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("roomhotel")
public class RoomHotelController {
	public static Map<String,String> roomidmap = new HashMap<String, String>();
	@Autowired
	RoomHotelService roomHotelService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加房间
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addRoomHotel")
    public CommResult addRoomHotel(HttpServletRequest request, HttpServletResponse response,@RequestBody RoomHotel roomHotel) {
    	
    	roomHotel.setId(ZhsUnique.unique25());
    	int i = roomHotelService.insert(roomHotel);
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
    @RequestMapping("/findRoomHotel")
    public CommResult findRoomHotel(HttpServletRequest request, HttpServletResponse response,@RequestBody RoomHotelVo roomhotel) {
    	RoomHotelExample roomhotelexample = new RoomHotelExample();
    	CommResult comm = new CommResult();
    	if(roomhotel.getFloorid()==null || "".equals(roomhotel.getFloorid())){
    		comm.setData(null);
	    	comm.setMessage("楼层ID不有为空");
	    	comm.setSuccess("false");
	    	return comm;
    	}
    	
    	//roomhotelexample.createCriteria().andFlooridEqualTo(roomhotel.getFloorid());
    	//roomhotelexample.setPage(new Page().setPage(roomhotel.getPage().getPage().intValue()).setRows((int)roomhotel.getPage().getRows()));
    	try{
	    	List<RoomHotelBeanVo> hotellst = roomHotelService.selectByFloorid(roomhotel);
	    	roomhotel.setResultlst(hotellst);
	    	ComplexPage page = new ComplexPage();
	    	page.setTotal(roomHotelService.countByExample(roomhotelexample));
	    	page.setPage(roomhotel.getPage().getPage().intValue());
	    	page.setRows((int)roomhotel.getPage().getRows());
	    	roomhotel.setPage(page);
    	
	    	comm.setData(roomhotel);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	
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
    @RequestMapping("/modifyRoomHotel")
    public CommResult modifyRoomHotel(HttpServletRequest request, HttpServletResponse response,RoomHotel roomHotel) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(roomHotel.getId()!=null&&!roomHotel.getId().isEmpty()){
    		RoomHotelExample roomhotelexample = new RoomHotelExample();
    		roomhotelexample.createCriteria().andIdEqualTo(roomHotel.getId());
    		i = roomHotelService.updateByExampleSelective(roomHotel, roomhotelexample);
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
    @RequestMapping("/delRoomHotel")
    public CommResult delRoomHotel(HttpServletRequest request, HttpServletResponse response,RoomHotel roomHotelBean) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(roomHotelBean.getId()!=null&&!roomHotelBean.getId().isEmpty()){
    		i = roomHotelService.deleteByPrimaryKey(roomHotelBean.getId());
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
    
    
    /**
     * 根据ip查询房间号
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findRoomIdByHost")
    public CommResult findRoomIdByHost(HttpServletRequest request, HttpServletResponse response,@RequestBody RoomHotelVo roomhotel) {
    	RoomHotelExample roomhotelexample = new RoomHotelExample();
    	CommResult comm = new CommResult();
    	if(roomhotel.getHost()==null || "".equals(roomhotel.getHost())){
    		comm.setData(null);
	    	comm.setMessage("ip不有为空");
	    	comm.setSuccess("flase");
	    	return comm;
    	}
    	
    	//roomhotelexample.createCriteria().andFlooridEqualTo(roomhotel.getFloorid());
    	//roomhotelexample.setPage(new Page().setPage(roomhotel.getPage().getPage().intValue()).setRows((int)roomhotel.getPage().getRows()));
    	try{
    		if(roomidmap.get(roomhotel.getHost())!=null){
    			comm.setData(roomidmap.get(roomhotel.getHost()));
    	    	comm.setMessage("查询成功");
    	    	comm.setSuccess("true");
    	    	return comm;
    		}
	    	List<RoomHotel> hotellst = roomHotelService.selectByExample(null);
	    	for(int i=0;i<hotellst.size();i++){
	    		RoomHotel aRoomHotel = hotellst.get(i);
	    		roomidmap.put(aRoomHotel.getRoomip(), aRoomHotel.getId());
	    	}
	    	if(roomidmap.get(roomhotel.getHost())!=null){
	    		comm.setData(roomidmap.get(roomhotel.getHost()));
	    	}else{
	    		comm.setData(null);
	    		comm.setMessage("没有此数据对应的房间");
		    	comm.setSuccess("false");
		    	return comm;
	    	}
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	
    	}catch(Exception e){
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    

}
