package cn.zhsit.authority.daos;

import cn.zhsit.authority.models.po.RoleAuthorityRelationAuthority;
import cn.zhsit.authority.models.po.RoleAuthorityRelationAuthorityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAuthorityRelationAuthorityMapper {
    long countByExample(RoleAuthorityRelationAuthorityExample example);

    int deleteByExample(RoleAuthorityRelationAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleAuthorityRelationAuthority record);

    int insertSelective(RoleAuthorityRelationAuthority record);

    List<RoleAuthorityRelationAuthority> selectByExample(RoleAuthorityRelationAuthorityExample example);

    RoleAuthorityRelationAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleAuthorityRelationAuthority record, @Param("example") RoleAuthorityRelationAuthorityExample example);

    int updateByExample(@Param("record") RoleAuthorityRelationAuthority record, @Param("example") RoleAuthorityRelationAuthorityExample example);

    int updateByPrimaryKeySelective(RoleAuthorityRelationAuthority record);

    int updateByPrimaryKey(RoleAuthorityRelationAuthority record);
}