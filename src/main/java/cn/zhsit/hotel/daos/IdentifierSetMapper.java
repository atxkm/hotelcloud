package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.IdentifierSet;
import cn.zhsit.hotel.models.po.IdentifierSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdentifierSetMapper {
    long countByExample(IdentifierSetExample example);

    int deleteByExample(IdentifierSetExample example);

    int deleteByPrimaryKey(String id);

    int insert(IdentifierSet record);

    int insertSelective(IdentifierSet record);

    List<IdentifierSet> selectByExample(IdentifierSetExample example);

    IdentifierSet selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IdentifierSet record, @Param("example") IdentifierSetExample example);

    int updateByExample(@Param("record") IdentifierSet record, @Param("example") IdentifierSetExample example);

    int updateByPrimaryKeySelective(IdentifierSet record);

    int updateByPrimaryKey(IdentifierSet record);
}