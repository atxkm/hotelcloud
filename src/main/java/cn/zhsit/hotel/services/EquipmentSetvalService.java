package cn.zhsit.hotel.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.common.enums.RoomEventType;
import cn.zhsit.hotel.models.po.EquipmentSetval;
import cn.zhsit.hotel.models.po.EquipmentSetvalExample;
import cn.zhsit.hotel.models.po.RoomEventValue;

public interface EquipmentSetvalService {
	long countByExample(EquipmentSetvalExample example);

    int deleteByExample(EquipmentSetvalExample example);

    int deleteByPrimaryKey(String modelid);

    int insert(List<EquipmentSetval> equipmentSetvals);

    int insertSelective(EquipmentSetval record);

    List<EquipmentSetval> selectByExample(EquipmentSetvalExample example);

    EquipmentSetval selectByPrimaryKey(String modelid);

    int updateByExampleSelective(List<EquipmentSetval> records, @Param("example") EquipmentSetvalExample example);

    int updateByExample(@Param("record") EquipmentSetval record, @Param("example") EquipmentSetvalExample example);

    int updateByPrimaryKeySelective(EquipmentSetval record);

    int updateByPrimaryKey(EquipmentSetval record);
    
    /**
	 * 消息是否需要提醒或显示
	 */
	public RoomEventValue checkMsgIfShow(RoomEventType eventtype,String val);
}
