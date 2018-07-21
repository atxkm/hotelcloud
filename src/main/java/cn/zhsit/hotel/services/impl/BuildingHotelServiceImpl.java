package cn.zhsit.hotel.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.zhsit.hotel.services.BuildingHotelService;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.daos.BuildingHotelMapper;
import cn.zhsit.hotel.daos.FloorHotelMapper;
import cn.zhsit.hotel.models.po.BuildingHotel;
import cn.zhsit.hotel.models.po.BuildingHotelExample;
import cn.zhsit.hotel.models.po.FloorHotel;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.vo.FloorHotelVo;
@Service
public class BuildingHotelServiceImpl implements BuildingHotelService {
	@Autowired
    private BuildingHotelMapper buildingHotelMapper;
	@Autowired
	FloorHotelMapper floorHotelMapper;
	@Override
	public long countByExample(BuildingHotelExample example) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BuildingHotelExample example) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String buildingId) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.deleteByPrimaryKey(buildingId);
	}

	@Override
	public int insert(BuildingHotel record) {
		// TODO Auto-generated method stub
		Map<String,String> roomid = new HashMap<String,String>();
		Map<String,String> subroomid = new HashMap<String,String>();
		if(record.getExtfloor()!=null){
			String extfloor = record.getExtfloor();
			String[] str = extfloor.split(",");
			for(int i=0;i<str.length;i++){
				roomid.put(str[i], str[i]);
			}
		}
		
		if(record.getExtsubfloor()!=null){
			String extfloor = record.getExtsubfloor();
			String[] extstr = extfloor.split(",");
			for(int i=0;i<extstr.length;i++){
				subroomid.put(extstr[i], extstr[i]);
			}
		}
		for(int i=0;i<record.getFloor();i++){
				if(roomid.get(i+"")==null){
					FloorHotel hotel = new FloorHotel();
			    	hotel.setBuildingId(record.getBuildingId());
			    	hotel.setBuildingName(record.getBuildingName());
			    	hotel.setId(ZhsUnique.unique25());
			    	hotel.setRoomnum(i);
			    	hotel.setFloorname(i+"");
			    	hotel.setFloor(i);
			    	hotel.setFloorstatus("0");
			    	hotel.setFloorbelong("0");
			    	floorHotelMapper.insert(hotel);
				}else{
					FloorHotel hotel = new FloorHotel();
			    	hotel.setBuildingId(record.getBuildingId());
			    	hotel.setBuildingName(record.getBuildingName());
			    	hotel.setId(ZhsUnique.unique25());
			    	hotel.setRoomnum(i);
			    	hotel.setFloorname(i+"");
			    	hotel.setFloor(i);
			    	hotel.setFloorstatus("1");
			    	hotel.setFloorbelong("0");
			    	floorHotelMapper.insert(hotel);
				}
		}
		for(int i=0;i<record.getSubFloor();i++){
				if(subroomid.get(i+"")==null){
					FloorHotel hotel = new FloorHotel();
			    	hotel.setBuildingId(record.getBuildingId());
			    	hotel.setBuildingName(record.getBuildingName());
			    	hotel.setId(ZhsUnique.unique25());
			    	hotel.setRoomnum(i);
			    	hotel.setFloorname(i+"");
			    	hotel.setFloor(i);
			    	hotel.setFloorstatus("0");
			    	hotel.setFloorbelong("1");
			    	floorHotelMapper.insert(hotel);
				}else{
					FloorHotel hotel = new FloorHotel();
			    	hotel.setBuildingId(record.getBuildingId());
			    	hotel.setBuildingName(record.getBuildingName());
			    	hotel.setId(ZhsUnique.unique25());
			    	hotel.setRoomnum(i);
			    	hotel.setFloorname(i+"");
			    	hotel.setFloor(i);
			    	hotel.setFloorstatus("1");
			    	hotel.setFloorbelong("1");
			    	floorHotelMapper.insert(hotel);
				}
		}
		return buildingHotelMapper.insert(record);
	}

	@Override
	public int insertSelective(BuildingHotel record) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.insertSelective(record);
	}

	@Override
	public List<BuildingHotel> selectByExample(BuildingHotelExample example) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.selectByExample(example);
	}

	@Override
	public BuildingHotel selectByPrimaryKey(String buildingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(BuildingHotel record, BuildingHotelExample example) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.updateByExampleSelective(record,example);
	}

	@Override
	public int updateByExample(BuildingHotel record, BuildingHotelExample example) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.updateByExample(record,example);
	}

	@Override
	public int updateByPrimaryKeySelective(BuildingHotel record) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BuildingHotel record) {
		// TODO Auto-generated method stub
		
		Map<String,String> roomid = new HashMap<String,String>();
		Map<String,String> subroomid = new HashMap<String,String>();
		if(record.getExtfloor()!=null){
			String extfloor = record.getExtfloor();
			String[] str = extfloor.split(",");
			for(int i=0;i<str.length;i++){
				roomid.put(str[i], str[i]);
			}
		}
		
		if(record.getExtsubfloor()!=null){
			String extfloor = record.getExtsubfloor();
			String[] extstr = extfloor.split(",");
			for(int i=0;i<extstr.length;i++){
				subroomid.put(extstr[i], extstr[i]);
			}
		}
		FloorHotelExample floorexample = new FloorHotelExample();
		floorexample.createCriteria().andBuildingIdEqualTo(record.getBuildingId()).andFloorbelongEqualTo("0");
		List<FloorHotel> flooruplst = floorHotelMapper.selectByExample(floorexample);
		if(flooruplst.size()>record.getFloor()){
			int x = flooruplst.size()-record.getFloor();
			for(int i=flooruplst.size();i>record.getFloor();i--){
				FloorHotelExample floorexampledel = new FloorHotelExample();
				floorexampledel.createCriteria().andFloorEqualTo(i-1).andBuildingIdEqualTo(record.getBuildingId()).andFloorstatusEqualTo("0");
				floorHotelMapper.deleteByExample(floorexampledel);
			}
		}
		FloorHotelExample floorsubexample = new FloorHotelExample();
		floorsubexample.createCriteria().andBuildingIdEqualTo(record.getBuildingId()).andFloorbelongEqualTo("1");
		List<FloorHotel> floorsublst = floorHotelMapper.selectByExample(floorexample);
		if(floorsublst.size()>record.getSubFloor()){
			int x = floorsublst.size()-record.getSubFloor();
			for(int i=floorsublst.size();i>record.getSubFloor();i--){
				FloorHotelExample floorexampledel = new FloorHotelExample();
				floorexampledel.createCriteria().andFloorEqualTo(i-1).andBuildingIdEqualTo(record.getBuildingId()).andFloorstatusEqualTo("1");
				floorHotelMapper.deleteByExample(floorexampledel);
			}
		}
		for(int i=0;i<record.getFloor();i++){
				if(roomid.get(i+"")==null){
					FloorHotelExample example = new FloorHotelExample();
					example.createCriteria().andFloorEqualTo(i).andBuildingIdEqualTo(record.getBuildingId()).andFloorbelongEqualTo("0");
					List<FloorHotel> lst = floorHotelMapper.selectByExample(example);
					if(lst.size()==0){
						FloorHotel hotel = new FloorHotel();
				    	hotel.setBuildingId(record.getBuildingId());
				    	hotel.setBuildingName(record.getBuildingName());
				    	hotel.setId(ZhsUnique.unique25());
				    	hotel.setRoomnum(i);
				    	hotel.setFloorname(i+"");
				    	hotel.setFloor(i);
				    	hotel.setFloorstatus("0");
				    	hotel.setFloorbelong("0");
				    	floorHotelMapper.insert(hotel);
					}else{
						
						FloorHotel aFloorHotel = lst.get(0);
						FloorHotelExample example1 = new FloorHotelExample();
						FloorHotel hotel = new FloorHotel();
				    	hotel.setBuildingId(record.getBuildingId());
				    	hotel.setBuildingName(record.getBuildingName());
				    	hotel.setId(aFloorHotel.getId());
				    	hotel.setRoomnum(i);
				    	hotel.setFloorname(i+"");
				    	hotel.setFloor(i);
				    	hotel.setFloorstatus("0");
				    	hotel.setFloorbelong("0");
						floorHotelMapper.updateByPrimaryKey(hotel);
					}
					
			    	
				}else{
					FloorHotelExample example = new FloorHotelExample();
					example.createCriteria().andFloorEqualTo(i).andBuildingIdEqualTo(record.getBuildingId()).andFloorbelongEqualTo("0").andFloorstatusEqualTo("1");
					List<FloorHotel> lst = floorHotelMapper.selectByExample(example);
					if(lst.size()==0){
						FloorHotel hotel = new FloorHotel();
				    	hotel.setBuildingId(record.getBuildingId());
				    	hotel.setBuildingName(record.getBuildingName());
				    	hotel.setId(ZhsUnique.unique25());
				    	hotel.setRoomnum(i);
				    	hotel.setFloorname(i+"");
				    	hotel.setFloor(i);
				    	hotel.setFloorstatus("1");
				    	hotel.setFloorbelong("0");
				    	floorHotelMapper.insert(hotel);
					}else{
						FloorHotel aFloorHotel = lst.get(0);
						floorHotelMapper.updateByPrimaryKey(aFloorHotel);
					}
					
				}
		}
		for(int i=0;i<record.getSubFloor();i++){
				if(subroomid.get(i+"")==null){
					FloorHotelExample example = new FloorHotelExample();
					example.createCriteria().andFloorEqualTo(i).andBuildingIdEqualTo(record.getBuildingId()).andFloorbelongEqualTo("1");
					List<FloorHotel> lst = floorHotelMapper.selectByExample(example);
					if(lst.size()==0){
						FloorHotel hotel = new FloorHotel();
				    	hotel.setBuildingId(record.getBuildingId());
				    	hotel.setBuildingName(record.getBuildingName());
				    	hotel.setId(ZhsUnique.unique25());
				    	hotel.setRoomnum(i);
				    	hotel.setFloorname(i+"");
				    	hotel.setFloor(i);
				    	hotel.setFloorstatus("0");
				    	hotel.setFloorbelong("1");
				    	floorHotelMapper.insert(hotel);
					}else{
						FloorHotel aFloorHotel = lst.get(0);
						FloorHotelExample example1 = new FloorHotelExample();
						FloorHotel hotel = new FloorHotel();
				    	hotel.setBuildingId(record.getBuildingId());
				    	hotel.setBuildingName(record.getBuildingName());
				    	hotel.setId(aFloorHotel.getId());
				    	hotel.setRoomnum(i);
				    	hotel.setFloorname(i+"");
				    	hotel.setFloor(i);
				    	hotel.setFloorstatus("0");
				    	hotel.setFloorbelong("1");
						floorHotelMapper.updateByPrimaryKey(hotel);
					}
					
				}else{
					FloorHotelExample example = new FloorHotelExample();
					example.createCriteria().andFloorEqualTo(i).andBuildingIdEqualTo(record.getBuildingId()).andFloorbelongEqualTo("1").andFloorstatusEqualTo("1");
					List<FloorHotel> lst = floorHotelMapper.selectByExample(example);
					if(lst.size()==0){
						FloorHotel hotel = new FloorHotel();
				    	hotel.setBuildingId(record.getBuildingId());
				    	hotel.setBuildingName(record.getBuildingName());
				    	hotel.setId(ZhsUnique.unique25());
				    	hotel.setRoomnum(i);
				    	hotel.setFloorname(i+"");
				    	hotel.setFloor(i);
				    	hotel.setFloorstatus("1");
				    	hotel.setFloorbelong("1");
				    	floorHotelMapper.insert(hotel);
					}else{
						FloorHotel aFloorHotel = lst.get(0);
						floorHotelMapper.updateByPrimaryKey(aFloorHotel);
					}
					
				}
		}
		return buildingHotelMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<BuildingHotel> selectByManagerId(String managerId) {
		// TODO Auto-generated method stub
		return buildingHotelMapper.selectByManagerId(managerId);
	}

	@Override
	public List<FloorHotelVo> selectFloorHotelList(String buildingId) {
		// TODO Auto-generated method stub
		return floorHotelMapper.selectFloorHotelList(buildingId);
	}

	

}
