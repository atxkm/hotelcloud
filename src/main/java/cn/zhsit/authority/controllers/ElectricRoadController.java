package cn.zhsit.authority.controllers;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.ElectricRoad;
import cn.zhsit.hotel.services.ElectricRoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * 电路管理
 * @author ChanPin
 *
 */
@RestController
@RequestMapping("electric")
public class ElectricRoadController {
	@Autowired
	ElectricRoadService electricRoadService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加电路
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addElectricRoad")
    public CommResult addElectricRoad(HttpServletRequest request, HttpServletResponse response,ElectricRoad electricRoad) {
    	
    	electricRoad.setId(ZhsUnique.unique25());
    	int i = electricRoadService.insert(electricRoad);
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
     * 查找电路 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findElectricRoad")
    public CommResult findelEctricRoad(HttpServletRequest request, HttpServletResponse response) {
    	
    	List<ElectricRoad> hotellst = electricRoadService.selectByExample(null);
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
}
