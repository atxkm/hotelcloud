package cn.zhsit.authority.controllers;

import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthorityExample;
import cn.zhsit.authority.models.po.RoleAuthority;
import cn.zhsit.authority.models.po.RoleAuthorityExample;
import cn.zhsit.authority.models.vo.PersonAuthorityVo;
import cn.zhsit.authority.services.PersonAuthorityService;
import cn.zhsit.authority.services.PersonRoleRelationAuthorityService;
import cn.zhsit.authority.services.RoleAuthorityService;
import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.FloorHotel;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.po.Warning;
import cn.zhsit.hotel.models.po.WarningExample;
import cn.zhsit.hotel.models.po.WarningExample.Criteria;
import cn.zhsit.hotel.models.vo.WarningVo;
import cn.zhsit.hotel.services.WarningService;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("personauth")
public class PersonAuthorityBeanController {
	@Autowired
	PersonAuthorityService personAuthorityService;
	@Autowired
	PersonRoleRelationAuthorityService personRoleRelationAuthorityService;
	/**
	 * 增加人员类别
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addRoleAuthority")
    public CommResult addRoleAuthority(HttpServletRequest request, HttpServletResponse response,@RequestBody PersonAuthorityVo record) {
    	PersonAuthority person = new PersonAuthority();
    	person.setLoginName(record.getLoginName());
    	person.setMobile(record.getMobile());
    	person.setModifyTime(person.getModifyTime());
    	person.setName(record.getName());
    	person.setOrderNum(person.getOrderNum());
    	person.setId(ZhsUnique.unique25());
    	person.setPwd(record.getPwd());
    	List<PersonRoleRelationAuthority> lst = record.getPersonRoleRelationAuthoritys();
    	for(int i=0;i<lst.size();i++){
	    	PersonRoleRelationAuthority personRoleRelationAuthority = lst.get(i);
	    	personRoleRelationAuthority.setId(ZhsUnique.unique25());
	    	personRoleRelationAuthority.setPersonId(person.getId());
    	}
    	int i = personAuthorityService.insert(person,lst);
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
    @RequestMapping("/modifyPersonAuthority")
    public CommResult modifyPersonAuthority(HttpServletRequest request, HttpServletResponse response,@RequestBody PersonAuthorityVo record) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	PersonAuthority personAuthority = new PersonAuthority();
    	personAuthority.setId(record.getId());
    	personAuthority.setName(record.getName());
    	personAuthority.setPwd(record.getPwd());
    	if(personAuthority.getId()!=null && !personAuthority.getId().isEmpty()){
    		PersonAuthorityExample role = new PersonAuthorityExample();
    		role.createCriteria().andIdEqualTo(personAuthority.getId());
    		i = personAuthorityService.updateByExampleSelective(personAuthority, role);
    		List<PersonRoleRelationAuthority> personlst =  record.getPersonRoleRelationAuthoritys();
        	for(PersonRoleRelationAuthority relation:personlst){
        		relation.setPersonId(record.getId());
        		personRoleRelationAuthorityService.updateByPrimaryKey(relation);
        	}
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
    @RequestMapping("/findPersonAuthorityList")
    public Object findPersonAuthorityList(HttpServletRequest request, HttpServletResponse response,PersonAuthority  personAuthority){
    	PersonAuthorityExample example = new PersonAuthorityExample();
    	if(StringUtils.isNotEmpty(personAuthority.getLoginName())){
    		example.createCriteria().andLoginNameEqualTo(personAuthority.getLoginName());
    	}
    	List<PersonAuthority> personAuthorityList = personAuthorityService.selectByExample(example);
    	CommResult comm = new CommResult();
    	if(personAuthorityList.size()>0){
	    	comm.setData(personAuthorityList);
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
     * 查询人员信息
     * @param example
     * @return
     */
    @RequestMapping("/findPersonAuthorityByid")
    public PersonAuthorityVo findPersonAuthorityByid(HttpServletRequest request, HttpServletResponse response,PersonAuthority  personAuthority){
    	
    	return personAuthorityService.selectById(personAuthority.getId());
    }
    /**
     * 删除人员类别
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delPersonAuthority")
    public CommResult delPersonAuthority(HttpServletRequest request, HttpServletResponse response,PersonAuthority  personAuthority) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(personAuthority.getId()!=null&&!personAuthority.getId().isEmpty()){
    		i = personAuthorityService.deleteByPrimaryKey(personAuthority.getId());
    		PersonRoleRelationAuthorityExample relation = new PersonRoleRelationAuthorityExample();
    		relation.createCriteria().andPersonIdEqualTo(personAuthority.getId());
    		List<PersonRoleRelationAuthority> lst = personRoleRelationAuthorityService.selectByExample(relation);
    		for(PersonRoleRelationAuthority rl:lst){
    			personRoleRelationAuthorityService.deleteByPrimaryKey(rl.getId());
    		}
    		
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
