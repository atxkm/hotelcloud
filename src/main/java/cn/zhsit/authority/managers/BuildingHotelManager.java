package cn.zhsit.authority.managers;

import cn.zhsit.hotel.models.po.BuildingHotel;

import java.util.List;

/**
 * 楼栋信息管理
 */
public interface BuildingHotelManager {
	/**
	 * 查询楼栋
	 * @param managerId
	 * @return
	 */
    List<BuildingHotel> selectBuildingHotelByManagerId(String managerId);
    /**
	 * 添加楼栋
	 * @param managerId
	 * @return
	 */
    public void addBuildingHotel(BuildingHotel buildingHotel);
    
    /**
	 * 删除楼栋
	 * @param managerId
	 * @return
	 */
    public void delBuildingHotel(String building_id);
    
    /**
   	 * 修改楼栋
   	 * @param managerId
   	 * @return
   	 */
     public void updateBuildingHotel(BuildingHotel buildingHotel);
}
