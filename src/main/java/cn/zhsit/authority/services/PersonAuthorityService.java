package cn.zhsit.authority.services;

import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;
import cn.zhsit.authority.models.vo.PersonAuthorityVo;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.models.vo.CheckLoggedReq;
//import cn.zhsit.authority.models.vo.PersonAuthorityVo;
import cn.zhsit.models.vo.LoginReq;
import cn.zhsit.models.vo.PersonAuthorityResp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.validation.Errors;

/**
 * Created by Darren on 2017/7/11.
 */
public interface PersonAuthorityService {

//    /**
//     * 校验密码是否正确
//     * @param person
//     * @param msg
//     * @return true,登录名密码匹配；
//     * @throws ZhsException
//     */
//    public boolean checkPwd(PersonAuthorityVo person, Msg msg) throws ZhsException;

    public boolean checkPwd(LoginReq loginReq,Errors errors);

    PersonAuthorityResp findPersonAuthority(String personAuthorityId);

    /**
     *
     * @param check
     * @param errors
     * @return true,目前是登录状态；
     */
    LoginStatus checkLogged(CheckLoggedReq check, Errors errors);
    LoginStatus checkLogged();

    
    long countByExample(PersonAuthorityExample example);

    int deleteByExample(PersonAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonAuthority record,List<PersonRoleRelationAuthority> personRoleRelationAuthoritys);

    int insertSelective(PersonAuthority record);

    List<PersonAuthority> selectByExample(PersonAuthorityExample example);

    PersonAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonAuthority record, @Param("example") PersonAuthorityExample example);

    int updateByExample(@Param("record") PersonAuthority record, @Param("example") PersonAuthorityExample example);

    int updateByPrimaryKeySelective(PersonAuthority record);

    int updateByPrimaryKey(PersonAuthority record);
    
    public PersonAuthorityVo selectById(String id);

	public List<PersonAuthority> selectAllLst(PersonAuthority record);

    public boolean checkMobile(LoginReq loginReq, Errors errors);
}
