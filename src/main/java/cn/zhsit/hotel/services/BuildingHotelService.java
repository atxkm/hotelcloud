package cn.zhsit.hotel.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.BuildingHotel;
import cn.zhsit.hotel.models.po.BuildingHotelExample;
import cn.zhsit.hotel.models.vo.FloorHotelVo;

public interface BuildingHotelService {
	public long countByExample(BuildingHotelExample example);

	public int deleteByExample(BuildingHotelExample example);

	public int deleteByPrimaryKey(String buildingId);

	public int insert(BuildingHotel record);

	public int insertSelective(BuildingHotel record);

	public List<BuildingHotel> selectByExample(BuildingHotelExample example);

	public BuildingHotel selectByPrimaryKey(String buildingId);

	public int updateByExampleSelective(@Param("record") BuildingHotel record, @Param("example") BuildingHotelExample example);

	public int updateByExample(@Param("record") BuildingHotel record, @Param("example") BuildingHotelExample example);

	public int updateByPrimaryKeySelective(BuildingHotel record);

	public int updateByPrimaryKey(BuildingHotel record);
    
    
    /**新加*/
	public List<BuildingHotel> selectByManagerId(String managerId);
	
	
	public List<FloorHotelVo> selectFloorHotelList(String buildingId);
}
