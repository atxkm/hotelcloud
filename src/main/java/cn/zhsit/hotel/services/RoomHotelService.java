package cn.zhsit.hotel.services;

import java.util.List;

import cn.zhsit.hotel.models.vo.RoomEquReqVo;
import cn.zhsit.hotel.models.vo.RoomHotelEquRespVo;
import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.models.po.RoomHotelExample;
import cn.zhsit.hotel.models.vo.RoomHotelBeanVo;
import cn.zhsit.hotel.models.vo.RoomHotelVo;

public interface RoomHotelService {
	long countByExample(RoomHotelExample example);

    int deleteByExample(RoomHotelExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoomHotel record);

    int insertSelective(RoomHotel record);

    List<RoomHotel> selectByExample(RoomHotelExample example);

    RoomHotel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoomHotel record, @Param("example") RoomHotelExample example);

    int updateByExample(@Param("record") RoomHotel record, @Param("example") RoomHotelExample example);

    int updateByPrimaryKeySelective(RoomHotel record);

    int updateByPrimaryKey(RoomHotel record);
    
    List<RoomHotelBeanVo> selectByFloorid(RoomHotelVo roomhotel);

    List<RoomHotelEquRespVo> selectByRoomId(RoomEquReqVo roomEquReqVo);
}
