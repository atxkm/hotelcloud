package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.RoomtypeEquipment;
import cn.zhsit.hotel.models.po.RoomtypeEquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomtypeEquipmentMapper {
    long countByExample(RoomtypeEquipmentExample example);

    int deleteByExample(RoomtypeEquipmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoomtypeEquipment record);

    int insertSelective(RoomtypeEquipment record);

    List<RoomtypeEquipment> selectByExample(RoomtypeEquipmentExample example);

    RoomtypeEquipment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoomtypeEquipment record, @Param("example") RoomtypeEquipmentExample example);

    int updateByExample(@Param("record") RoomtypeEquipment record, @Param("example") RoomtypeEquipmentExample example);

    int updateByPrimaryKeySelective(RoomtypeEquipment record);

    int updateByPrimaryKey(RoomtypeEquipment record);
}