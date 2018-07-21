package cn.zhsit.authority.controllers;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.BuildingHotel;
import cn.zhsit.hotel.models.po.BuildingHotelExample;
import cn.zhsit.hotel.models.po.FloorHotel;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.vo.FloorHotelVo;
import cn.zhsit.hotel.services.BuildingHotelService;
import cn.zhsit.hotel.services.FloorHotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 楼栋信息管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("buildinghotel")
public class BuildingHotelController {
	@Autowired
	BuildingHotelService buildingHotelService;
	@Autowired
	FloorHotelService floorHotelService;

    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加楼栋
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addBuildingHotel")
    public CommResult addBuildingHotel(HttpServletRequest request, HttpServletResponse response,BuildingHotel hotelbean) {
    	String buildingid = ZhsUnique.unique25();
    	hotelbean.setBuildingId(buildingid);
    	BuildingHotelExample example = new BuildingHotelExample();
    	example.createCriteria().andBuildingNameEqualTo(hotelbean.getBuildingName());
    	List<BuildingHotel> ls= buildingHotelService.selectByExample(example);
    	CommResult comm = new CommResult();
    	if(ls.size()>0){
    		comm.setData(null);
	    	comm.setMessage("楼栋名："+hotelbean.getBuildingName()+"已存在，请修改后重试");
	    	comm.setSuccess("true");
	    	return comm;
    	}
    	int i = buildingHotelService.insert(hotelbean);
    	
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
     * 查找楼栋
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findBuildingHotel")
    public CommResult findBuildingHotel(HttpServletRequest request, HttpServletResponse response) {
    	
    	List<BuildingHotel> hotellst = buildingHotelService.selectByExample(null);
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
     * 修改楼栋
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyBuildingHotel")
    public CommResult modifyBuildingHotel(HttpServletRequest request, HttpServletResponse response,BuildingHotel hotelbean) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(hotelbean.getBuildingId()!=null&&!hotelbean.getBuildingId().isEmpty()){
    		i = buildingHotelService.updateByPrimaryKey(hotelbean);
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
     * 删除楼栋
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delBuildingHotel")
    public CommResult delBuildingHotel(HttpServletRequest request, HttpServletResponse response,BuildingHotel hotelbean) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	FloorHotelExample example = new FloorHotelExample();
    	example.createCriteria().andBuildingIdEqualTo(hotelbean.getBuildingId());
    	List<FloorHotel> lst = floorHotelService.selectByExample(example);
    	if(lst.size()>0){
    		comm.setData(null);
	    	comm.setMessage("该楼栋已被使用，不能删除");
	    	comm.setSuccess("false");
	    	return comm;
    	}
    	if(hotelbean.getBuildingId()!=null&&!hotelbean.getBuildingId().isEmpty()){
    		i = buildingHotelService.deleteByPrimaryKey(hotelbean.getBuildingId());
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
     * 查找楼栋看人楼层
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/selectFloorHotelList")
    public CommResult selectFloorHotelList(HttpServletRequest request, HttpServletResponse response,@RequestBody FloorHotelVo floorHotelVo) {
    	FloorHotelExample example = new FloorHotelExample();
    	example.createCriteria().andBuildingIdEqualTo(floorHotelVo.getBuildingId());
    	List<FloorHotel> lst = floorHotelService.selectByExample(example);
    	CommResult comm = new CommResult();
    	
    	//List<BuildingHotel> hotellst = buildingHotelService.selectByExample(null);
    	
    	if(lst.size()>0){
	    	comm.setData(lst);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }

}
