package cn.zhsit.authority.controllers;

import cn.zhsit.authority.models.po.RoleAuthority;
import cn.zhsit.authority.models.po.RoleAuthorityExample;
import cn.zhsit.authority.services.RoleAuthorityService;
import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.po.Warning;
import cn.zhsit.hotel.models.po.WarningExample;
import cn.zhsit.hotel.models.po.WarningExample.Criteria;
import cn.zhsit.hotel.models.vo.WarningVo;
import cn.zhsit.hotel.services.WarningService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("roleauth")
public class RoleAuthorityController {
	@Autowired
	RoleAuthorityService roleAuthorityService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加人员类别
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addRoleAuthority")
    public CommResult addRoleAuthority(HttpServletRequest request, HttpServletResponse response, RoleAuthority record) {
    	
    	record.setId(ZhsUnique.unique25());
    	int i = roleAuthorityService.insert(record);
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
     * 修改人员类别
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyRoleAuthority")
    public CommResult modifyRoleAuthority(HttpServletRequest request, HttpServletResponse response, RoleAuthority roleAuthority) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(roleAuthority.getId()!=null && !roleAuthority.getId().isEmpty()){
    		RoleAuthorityExample role = new RoleAuthorityExample();
    		role.createCriteria().andIdEqualTo(roleAuthority.getId());
    		i = roleAuthorityService.updateByExample(roleAuthority, role);
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
     * 事件人员类别
     * @param example
     * @return
     */
    @RequestMapping("/findRoleAuthorityList")
    public CommResult findRoleAuthorityList(HttpServletRequest request, HttpServletResponse response,RoleAuthority  roleAuthority){
		CommResult comm = new CommResult();
    	try {
			comm.setMessage("查询成功");
			comm.setSuccess("true");
			List<RoleAuthority> authlst = roleAuthorityService.selectByExample(null);
			comm.setData(authlst);
			return comm;
		}catch(Exception e){
			e.printStackTrace();
		}
		comm.setMessage("查询失败");
		comm.setSuccess("false");
		return comm;
    }
    /**
     * 删除人员类别
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delRoleAuthority")
    public CommResult delRoleAuthority(HttpServletRequest request, HttpServletResponse response,RoleAuthority  roleAuthority) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(roleAuthority.getId()!=null&&!roleAuthority.getId().isEmpty()){
    		i = roleAuthorityService.deleteByPrimaryKey(roleAuthority.getId());
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
