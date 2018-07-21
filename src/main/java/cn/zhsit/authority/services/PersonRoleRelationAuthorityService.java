package cn.zhsit.authority.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthorityExample;

public interface PersonRoleRelationAuthorityService {
	long countByExample(PersonRoleRelationAuthorityExample example);

    int deleteByExample(PersonRoleRelationAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonRoleRelationAuthority record);

    int insertSelective(PersonRoleRelationAuthority record);

    List<PersonRoleRelationAuthority> selectByExample(PersonRoleRelationAuthorityExample example);

    PersonRoleRelationAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonRoleRelationAuthority record, @Param("example") PersonRoleRelationAuthorityExample example);

    int updateByExample(@Param("record") PersonRoleRelationAuthority record, @Param("example") PersonRoleRelationAuthorityExample example);

    int updateByPrimaryKeySelective(PersonRoleRelationAuthority record);

    int updateByPrimaryKey(PersonRoleRelationAuthority record);
}
