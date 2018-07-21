package cn.zhsit.authority.daos;

import cn.zhsit.authority.models.po.OrgAuthority;
import cn.zhsit.authority.models.po.OrgAuthorityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgAuthorityMapper {
    long countByExample(OrgAuthorityExample example);

    int deleteByExample(OrgAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrgAuthority record);

    int insertSelective(OrgAuthority record);

    List<OrgAuthority> selectByExample(OrgAuthorityExample example);

    OrgAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrgAuthority record, @Param("example") OrgAuthorityExample example);

    int updateByExample(@Param("record") OrgAuthority record, @Param("example") OrgAuthorityExample example);

    int updateByPrimaryKeySelective(OrgAuthority record);

    int updateByPrimaryKey(OrgAuthority record);
}