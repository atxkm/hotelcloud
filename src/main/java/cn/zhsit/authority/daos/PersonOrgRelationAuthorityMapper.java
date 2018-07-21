package cn.zhsit.authority.daos;

import cn.zhsit.authority.models.po.PersonOrgRelationAuthority;
import cn.zhsit.authority.models.po.PersonOrgRelationAuthorityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonOrgRelationAuthorityMapper {
    long countByExample(PersonOrgRelationAuthorityExample example);

    int deleteByExample(PersonOrgRelationAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonOrgRelationAuthority record);

    int insertSelective(PersonOrgRelationAuthority record);

    List<PersonOrgRelationAuthority> selectByExample(PersonOrgRelationAuthorityExample example);

    PersonOrgRelationAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonOrgRelationAuthority record, @Param("example") PersonOrgRelationAuthorityExample example);

    int updateByExample(@Param("record") PersonOrgRelationAuthority record, @Param("example") PersonOrgRelationAuthorityExample example);

    int updateByPrimaryKeySelective(PersonOrgRelationAuthority record);

    int updateByPrimaryKey(PersonOrgRelationAuthority record);
}