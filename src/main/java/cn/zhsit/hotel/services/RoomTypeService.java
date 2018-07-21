package cn.zhsit.hotel.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.RoomTypeHotel;
import cn.zhsit.hotel.models.po.RoomTypeHotelExample;
import cn.zhsit.hotel.models.vo.RoomTypeInfo;

public interface RoomTypeService {
	long countByExample(RoomTypeHotelExample example);

    int deleteByExample(RoomTypeHotelExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoomTypeInfo record);

    int insertSelective(RoomTypeHotel record);

    List<RoomTypeHotel> selectByExample(RoomTypeHotelExample example);

    int updateByExampleSelective(@Param("record") RoomTypeHotel record, @Param("example") RoomTypeHotelExample example);

    int updateByExample(@Param("record") RoomTypeHotel record, @Param("example") RoomTypeHotelExample example);
   
    
    List<RoomTypeInfo> selectById(String id);
    
    int updateById(RoomTypeInfo record);
    
    List<RoomTypeInfo> selectRoomList(RoomTypeHotelExample example);
}
