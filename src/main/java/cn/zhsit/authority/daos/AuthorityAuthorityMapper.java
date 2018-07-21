package cn.zhsit.authority.daos;

import cn.zhsit.authority.models.po.AuthorityAuthority;
import cn.zhsit.authority.models.po.AuthorityAuthorityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorityAuthorityMapper {
    long countByExample(AuthorityAuthorityExample example);

    int deleteByExample(AuthorityAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthorityAuthority record);

    int insertSelective(AuthorityAuthority record);

    List<AuthorityAuthority> selectByExample(AuthorityAuthorityExample example);

    AuthorityAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthorityAuthority record, @Param("example") AuthorityAuthorityExample example);

    int updateByExample(@Param("record") AuthorityAuthority record, @Param("example") AuthorityAuthorityExample example);

    int updateByPrimaryKeySelective(AuthorityAuthority record);

    int updateByPrimaryKey(AuthorityAuthority record);
}