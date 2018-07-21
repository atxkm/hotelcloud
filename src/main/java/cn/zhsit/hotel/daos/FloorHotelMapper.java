package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.BuildingHotel;
import cn.zhsit.hotel.models.po.FloorHotel;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.vo.FloorHotelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FloorHotelMapper {
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
}