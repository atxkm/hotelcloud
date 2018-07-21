package cn.zhsit.authority.daos;

import cn.zhsit.authority.models.po.PersonAttachAuthority;
import cn.zhsit.authority.models.po.PersonAttachAuthorityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonAttachAuthorityMapper {
    long countByExample(PersonAttachAuthorityExample example);

    int deleteByExample(PersonAttachAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonAttachAuthority record);

    int insertSelective(PersonAttachAuthority record);

    List<PersonAttachAuthority> selectByExample(PersonAttachAuthorityExample example);

    PersonAttachAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonAttachAuthority record, @Param("example") PersonAttachAuthorityExample example);

    int updateByExample(@Param("record") PersonAttachAuthority record, @Param("example") PersonAttachAuthorityExample example);

    int updateByPrimaryKeySelective(PersonAttachAuthority record);

    int updateByPrimaryKey(PersonAttachAuthority record);
}