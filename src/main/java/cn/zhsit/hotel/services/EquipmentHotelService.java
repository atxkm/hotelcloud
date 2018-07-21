package cn.zhsit.hotel.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.EquipmentHotel;
import cn.zhsit.hotel.models.po.EquipmentHotelExample;

public interface EquipmentHotelService {
	long countByExample(EquipmentHotelExample example);

    int deleteByExample(EquipmentHotelExample example);

    int deleteByPrimaryKey(String id);

    int insert(EquipmentHotel record);

    int insertSelective(EquipmentHotel record);

    List<EquipmentHotel> selectByExample(EquipmentHotelExample example);

    EquipmentHotel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EquipmentHotel record, @Param("example") EquipmentHotelExample example);

    int updateByExample(@Param("record") EquipmentHotel record, @Param("example") EquipmentHotelExample example);

    int updateByPrimaryKeySelective(EquipmentHotel record);

    int updateByPrimaryKey(EquipmentHotel record);

    List<EquipmentHotel> selectEquByHost(String host);
}
