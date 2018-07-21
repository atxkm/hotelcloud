package cn.zhsit.authority.daos;

import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthorityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonRoleRelationAuthorityMapper {
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