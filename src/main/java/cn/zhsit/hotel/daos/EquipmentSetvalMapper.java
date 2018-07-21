package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.EquipmentSetval;
import cn.zhsit.hotel.models.po.EquipmentSetvalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentSetvalMapper {
    long countByExample(EquipmentSetvalExample example);

    int deleteByExample(EquipmentSetvalExample example);

    int deleteByPrimaryKey(String modelid);

    int insert(EquipmentSetval record);

    int insertSelective(EquipmentSetval record);

    List<EquipmentSetval> selectByExample(EquipmentSetvalExample example);

    EquipmentSetval selectByPrimaryKey(String modelid);

    int updateByExampleSelective(@Param("record") EquipmentSetval record, @Param("example") EquipmentSetvalExample example);

    int updateByExample(@Param("record") EquipmentSetval record, @Param("example") EquipmentSetvalExample example);

    int updateByPrimaryKeySelective(EquipmentSetval record);

    int updateByPrimaryKey(EquipmentSetval record);
}