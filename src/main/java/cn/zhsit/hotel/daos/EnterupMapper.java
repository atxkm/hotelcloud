package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.Enterup;
import cn.zhsit.hotel.models.po.EnterupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnterupMapper {
    long countByExample(EnterupExample example);

    int deleteByExample(EnterupExample example);

    int deleteByPrimaryKey(String enterid);

    int insert(Enterup record);

    int insertSelective(Enterup record);

    List<Enterup> selectByExample(EnterupExample example);

    Enterup selectByPrimaryKey(String enterid);

    int updateByExampleSelective(@Param("record") Enterup record, @Param("example") EnterupExample example);

    int updateByExample(@Param("record") Enterup record, @Param("example") EnterupExample example);

    int updateByPrimaryKeySelective(Enterup record);

    int updateByPrimaryKey(Enterup record);
}