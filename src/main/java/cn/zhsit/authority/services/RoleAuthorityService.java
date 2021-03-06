package cn.zhsit.authority.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.authority.models.po.RoleAuthority;
import cn.zhsit.authority.models.po.RoleAuthorityExample;

public interface RoleAuthorityService{
	long countByExample(RoleAuthorityExample example);

    int deleteByExample(RoleAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    List<RoleAuthority> selectByExample(RoleAuthorityExample example);

    RoleAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleAuthority record, @Param("example") RoleAuthorityExample example);

    int updateByExample(@Param("record") RoleAuthority record, @Param("example") RoleAuthorityExample example);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);
}
