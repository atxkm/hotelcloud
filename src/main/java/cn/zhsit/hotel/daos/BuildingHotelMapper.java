package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.BuildingHotel;
import cn.zhsit.hotel.models.po.BuildingHotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingHotelMapper {
    long countByExample(BuildingHotelExample example);

    int deleteByExample(BuildingHotelExample example);

    int deleteByPrimaryKey(String buildingId);

    int insert(BuildingHotel record);

    int insertSelective(BuildingHotel record);

    List<BuildingHotel> selectByExample(BuildingHotelExample example);

    BuildingHotel selectByPrimaryKey(String buildingId);

    int updateByExampleSelective(@Param("record") BuildingHotel record, @Param("example") BuildingHotelExample example);

    int updateByExample(@Param("record") BuildingHotel record, @Param("example") BuildingHotelExample example);

    int updateByPrimaryKeySelective(BuildingHotel record);

    int updateByPrimaryKey(BuildingHotel record);
    
    
    /**新加*/
    List<BuildingHotel> selectByManagerId(String managerId);

	
}