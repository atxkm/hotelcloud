package cn.zhsit.authority.managers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import cn.zhsit.hotel.daos.BuildingHotelMapper;
import cn.zhsit.hotel.models.po.BuildingHotel;

public class BuildingHotelManagerImpl implements cn.zhsit.authority.managers.BuildingHotelManager {
	@Autowired
    private BuildingHotelMapper buildingHotelMapper;
	@Override
	public List<BuildingHotel> selectBuildingHotelByManagerId(String managerId) {
		// TODO Auto-generated method stub
		List<BuildingHotel> hotellst = buildingHotelMapper.selectByManagerId(managerId);
		return hotellst;
	}

	@Override
	public void addBuildingHotel(BuildingHotel buildingHotel) {
		// TODO Auto-generated method stub
		buildingHotelMapper.insert(buildingHotel);
	}

	@Override
	public void delBuildingHotel(String building_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBuildingHotel(BuildingHotel buildingHotel) {
		// TODO Auto-generated method stub

	}

}
