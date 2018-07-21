package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.RoomTypeHotel;
import cn.zhsit.hotel.models.po.RoomTypeHotelExample;
import cn.zhsit.hotel.models.vo.RoomTypeInfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomTypeHotelMapper {
    long countByExample(RoomTypeHotelExample example);

    int deleteByExample(RoomTypeHotelExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoomTypeHotel record);

    int insertSelective(RoomTypeHotel record);

    List<RoomTypeHotel> selectByExample(RoomTypeHotelExample example);

    RoomTypeHotel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoomTypeHotel record, @Param("example") RoomTypeHotelExample example);

    int updateByExample(@Param("record") RoomTypeHotel record, @Param("example") RoomTypeHotelExample example);

    int updateByPrimaryKeySelective(RoomTypeHotel record);

    int updateByPrimaryKey(RoomTypeHotel record);
    
    
    List<RoomTypeInfo> selectById(String id);

	List<RoomTypeInfo> selectRoomList(RoomTypeHotelExample example);
}