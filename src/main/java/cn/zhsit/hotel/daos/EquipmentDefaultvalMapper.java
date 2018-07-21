package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.EquipmentDefaultval;
import cn.zhsit.hotel.models.po.EquipmentDefaultvalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentDefaultvalMapper {
    long countByExample(EquipmentDefaultvalExample example);

    int deleteByExample(EquipmentDefaultvalExample example);

    int deleteByPrimaryKey(String modelid);

    int insert(EquipmentDefaultval record);

    int insertSelective(EquipmentDefaultval record);

    List<EquipmentDefaultval> selectByExample(EquipmentDefaultvalExample example);

    EquipmentDefaultval selectByPrimaryKey(String modelid);

    int updateByExampleSelective(@Param("record") EquipmentDefaultval record, @Param("example") EquipmentDefaultvalExample example);

    int updateByExample(@Param("record") EquipmentDefaultval record, @Param("example") EquipmentDefaultvalExample example);

    int updateByPrimaryKeySelective(EquipmentDefaultval record);

    int updateByPrimaryKey(EquipmentDefaultval record);
}