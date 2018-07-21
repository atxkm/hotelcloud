package cn.zhsit.hotel.services;

import java.util.List;

import cn.zhsit.hotel.models.vo.FloorlVo;
import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.FloorHotel;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import cn.zhsit.hotel.models.po.RoomTypeHotel;
import cn.zhsit.hotel.models.po.RoomTypeHotelExample;
import cn.zhsit.hotel.models.vo.FloorHotelVo;

public interface FloorHotelService {
	long countByExample(FloorHotelExample example);

    int deleteByExample(FloorHotelExample example);

    int deleteByPrimaryKey(String id);

    int insert(FloorHotel record);

    int insertSelective(FloorHotel record);

    List<FloorHotel> selectByExample(FloorHotelExample example);

    FloorHotel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FloorHotel record, @Param("example") FloorHotelExample example);

    int updateByExample(@Param("record") FloorHotel record, @Param("example") FloorHotelExample example);

    int updateByPrimaryKeySelective(FloorHotel record);

    int updateByPrimaryKey(FloorHotel record);
    
    List<FloorHotelVo> selectFloorHotelList(String buildingId);

    List<FloorlVo> findAllFloors();
}
