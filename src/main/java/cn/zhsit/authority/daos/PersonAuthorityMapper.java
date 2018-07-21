package cn.zhsit.authority.daos;

import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import cn.zhsit.authority.models.vo.PersonAuthorityVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonAuthorityMapper {
    long countByExample(PersonAuthorityExample example);

    int deleteByExample(PersonAuthorityExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonAuthority record);

    int insertSelective(PersonAuthority record);

    List<PersonAuthority> selectByExample(PersonAuthorityExample example);

    PersonAuthority selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonAuthority record, @Param("example") PersonAuthorityExample example);

    int updateByExample(@Param("record") PersonAuthority record, @Param("example") PersonAuthorityExample example);

    int updateByPrimaryKeySelective(PersonAuthority record);

    int updateByPrimaryKey(PersonAuthority record);

	PersonAuthorityVo selectById(String id);

	List<PersonAuthority> selectAllLst(PersonAuthority record);
}