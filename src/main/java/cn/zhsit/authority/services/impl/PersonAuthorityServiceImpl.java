package cn.zhsit.authority.services.impl;

import cn.zhsit.authority.daos.PersonAuthorityMapper;
import cn.zhsit.authority.daos.PersonRoleRelationAuthorityMapper;
import cn.zhsit.authority.helpers.CacheHelper;
//import cn.zhsit.authority.interceptors.models.Msg;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.authority.managers.PersonAuthorityManager;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;
import cn.zhsit.authority.models.vo.PersonAuthorityVo;
//import cn.zhsit.authority.models.vo.PersonAuthorityVo;
import cn.zhsit.authority.services.PersonAuthorityService;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.common.exceptions.ZhsException;
import cn.zhsit.common.handlers.ZhsContextHandler;
import cn.zhsit.common.utils.ZhsMD5;
import cn.zhsit.models.vo.CheckLoggedReq;
import cn.zhsit.models.vo.LoginReq;
import cn.zhsit.models.vo.PersonAuthorityResp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

/**
 * Created by Darren on 2017/7/11.
 */
@Service
public class PersonAuthorityServiceImpl implements PersonAuthorityService {
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private PersonAuthorityManager personAuthorityManager;
    @Autowired
    private PersonRoleRelationAuthorityMapper personRoleRelationAuthorityMapper;
    @Autowired
    private PersonAuthorityMapper personAuthorityMapper;
//
//    @Override
//    public boolean checkPwd(PersonAuthorityVo person, Msg msg) throws ZhsException {
//        String loginName=person.getLoginName();
//        String loginPwd= person.getPwd();
//        if (loginName==null||loginName.trim().length()<1||loginPwd==null||loginPwd.trim().length()<1) {
//            msg.addVal(Msg.msg, "用户名和密码不可为空！");
//            return false;
//        }
//        PersonAuthority pInDB= personAuthorityManager.selectByLoginName(person.getLoginName());
//        if(null==pInDB){
//            msg.addVal(Msg.msg, "用户名或密码错误！");
//            return false;
//        }
//
//        String loginMD5Pwd=ZhsMD5.md5Twice(loginPwd);
//        if(!loginMD5Pwd.equals(pInDB.getPwd())){
//            msg.addVal(Msg.msg, "用户名或密码错误！");
//            return false;
//        }
//        cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey())
//                .setLoginStatus(LoginStatus.Logged)
//                .setPersonId(pInDB.getId());
//        return true;
//    }

    @Override
    public boolean checkPwd(LoginReq loginReq, Errors errors) {
        PersonAuthority personAuthority = personAuthorityManager.selectByLoginName(loginReq.getLoginName());
        String pwdInMD5 = ZhsMD5.pwd(loginReq.getPwd());
        if (null == personAuthority || !pwdInMD5.equals(personAuthority.getPwd())) {
            errors.rejectValue("pwd", "pwd", "登录名或密码错误");
            return false;
        }
        cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey())
                .setLoginStatus(LoginStatus.Logined)
                .setPersonId(personAuthority.getId())
                .setLastSessionVersion();
        return true;
    }

    @Override
    public PersonAuthorityResp findPersonAuthority(String personAuthorityId) {
        PersonAuthority personAuthority = personAuthorityManager.selectByKey(personAuthorityId);
        PersonAuthorityResp resp = new PersonAuthorityResp();
        BeanUtils.copyProperties(personAuthority, resp);
        return resp;
    }

    @Override
    public long countByExample(PersonAuthorityExample example) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PersonAuthorityExample example) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PersonAuthority record, List<PersonRoleRelationAuthority> personRoleRelationAuthoritys) {
        // TODO Auto-generated method stub
        PersonAuthorityExample example = new PersonAuthorityExample();
        example.createCriteria().andLoginNameEqualTo(record.getLoginName());
        List<PersonAuthority> perlst = personAuthorityMapper.selectByExample(example);//record.getLoginName();
        if(personRoleRelationAuthoritys==null){
            if(perlst.size()>0){
                personAuthorityMapper.updateByExampleSelective(record,example);
            }else {
                personAuthorityMapper.insert(record);
            }
        }else {

            if(perlst.size()>0){
                personAuthorityMapper.updateByExampleSelective(record,example);
            }else {
                personAuthorityMapper.insert(record);
            }
            for (PersonRoleRelationAuthority personRoleRelationAuthority : personRoleRelationAuthoritys) {
                personRoleRelationAuthority.setCreateTime(new Date());
                personRoleRelationAuthority.setPersonId(record.getId());
                personRoleRelationAuthorityMapper.insert(personRoleRelationAuthority);

            }
        }
        return 1;

    }

    @Override
    public int insertSelective(PersonAuthority record) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.insertSelective(record);
    }

    @Override
    public List<PersonAuthority> selectByExample(PersonAuthorityExample example) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.selectByExample(example);
    }

    @Override
    public PersonAuthority selectByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PersonAuthority record, PersonAuthorityExample example) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(PersonAuthority record, PersonAuthorityExample example) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(PersonAuthority record) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PersonAuthority record) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.updateByPrimaryKey(record);
    }


    @Override
    public LoginStatus checkLogged(CheckLoggedReq check, Errors errors) {
        ZhsSession zhsSession = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
        return zhsSession.getLoginStatus();
    }


    @Override
    public LoginStatus checkLogged() {
        ZhsSession zhsSession = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
        return zhsSession.getLoginStatus();
    }


    @Override
    public PersonAuthorityVo selectById(String id) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.selectById(id);
    }

    @Override
    public List<PersonAuthority> selectAllLst(PersonAuthority record) {
        // TODO Auto-generated method stub
        return personAuthorityMapper.selectAllLst(record);
    }



    @Override
    public boolean checkMobile(LoginReq loginReq, Errors errors) {
        PersonAuthority personAuthority = personAuthorityManager.selectByLoginName(loginReq.getLoginName());
        String pwdInMD5 = ZhsMD5.pwd(loginReq.getPwd());
        if (null == personAuthority || !pwdInMD5.equals(personAuthority.getPwd())) {
            errors.rejectValue("pwd", "pwd", "登录名或密码错误");
            return false;
        }
        cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey())
                .setLoginStatus(LoginStatus.Logined)
                .setPersonId(personAuthority.getId())
                .setLastSessionVersion();
        return true;
    }


}
