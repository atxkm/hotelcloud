package cn.zhsit.authority.controllers;

import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import cn.zhsit.authority.models.po.RoleAuthority;
import cn.zhsit.authority.models.po.RoleAuthorityExample;
import cn.zhsit.authority.services.PersonAuthorityService;
import cn.zhsit.authority.services.RoleAuthorityService;
import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
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
@RequestMapping("regperson")
public class RegisterAuthorityController {
	@Autowired
	PersonAuthorityService personAuthorityService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加人员类别
	 * @param request
	 * @param response
	 * @param record
	 * @return
	 */
    @RequestMapping("/addPersonAuthority")
    public CommResult addPersonAuthority(HttpServletRequest request, HttpServletResponse response, @RequestBody PersonAuthority record) {
    	
    	record.setId(ZhsUnique.unique25());
    	int i = personAuthorityService.insert(record,null);
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
     * @param personAuthority
     * @return
     */
    @RequestMapping("/modifyPersonAuthority")
    public CommResult modifyPersonAuthority(HttpServletRequest request, HttpServletResponse response, PersonAuthority personAuthority) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(personAuthority.getId()!=null && !personAuthority.getId().isEmpty()){
    		PersonAuthorityExample role = new PersonAuthorityExample();
    		role.createCriteria().andIdEqualTo(personAuthority.getId());
    		i = personAuthorityService.updateByExample(personAuthority, role);
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
     * @param personAuthority
     * @return
     */
    @RequestMapping("/findPersonAuthorityList")
    public List<PersonAuthority> findPersonAuthorityList(HttpServletRequest request, HttpServletResponse response,PersonAuthority  personAuthority){
    	
    	return personAuthorityService.selectByExample(null);
    }
    /**
     * 删除人员类别
     * @param request
     * @param response
     * @param personAuthority
     * @return
     */
    @RequestMapping("/delPersonAuthority")
    public CommResult delPersonAuthority(HttpServletRequest request, HttpServletResponse response,PersonAuthority  personAuthority) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(personAuthority.getId()!=null&&!personAuthority.getId().isEmpty()){
    		i = personAuthorityService.deleteByPrimaryKey(personAuthority.getId());
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
