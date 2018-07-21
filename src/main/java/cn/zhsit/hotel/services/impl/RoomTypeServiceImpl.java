package cn.zhsit.hotel.services.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

import cn.zhsit.hotel.services.RoomTypeService;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.daos.RoomElectricroadMapper;
import cn.zhsit.hotel.daos.RoomTypeHotelMapper;
import cn.zhsit.hotel.daos.RoomtypeEquipmentMapper;
import cn.zhsit.hotel.models.po.RoomElectricroad;
import cn.zhsit.hotel.models.po.RoomElectricroadExample;
import cn.zhsit.hotel.models.po.RoomTypeHotel;
import cn.zhsit.hotel.models.po.RoomTypeHotelExample;
import cn.zhsit.hotel.models.po.RoomtypeEquipment;
import cn.zhsit.hotel.models.po.RoomtypeEquipmentExample;
import cn.zhsit.hotel.models.vo.RoomElectricroadKeyVo;
import cn.zhsit.hotel.models.vo.RoomTypeEquipmentVo;
import cn.zhsit.hotel.models.vo.RoomTypeInfo;
@Service
public class RoomTypeServiceImpl implements RoomTypeService {
	@Autowired
    private RoomTypeHotelMapper roomTypeHotelMapper;
	@Autowired
	private RoomElectricroadMapper roomElectricroadMapper;
	@Autowired
	private RoomtypeEquipmentMapper roomtypeEquipmentMapper;
	@Override
	public long countByExample(RoomTypeHotelExample example) {
		// TODO Auto-generated method stub
		return roomTypeHotelMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RoomTypeHotelExample example) {
		// TODO Auto-generated method stub
		return roomTypeHotelMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		RoomtypeEquipmentExample example = new RoomtypeEquipmentExample();
		example.createCriteria().andTypeidEqualTo(id);
		roomtypeEquipmentMapper.deleteByExample(example);
		return roomTypeHotelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RoomTypeInfo record) {
		// TODO Auto-generated method stub
		//roomElectricroadMapper.insert(record);
		RoomTypeHotel roomtype = new RoomTypeHotel();
		String typeid = ZhsUnique.unique25();
		//String elecid = ZhsUnique.unique25();
		//String equid = ZhsUnique.unique25();
		roomtype.setId(typeid);
		roomtype.setRmtypename(record.getRmtypename());
		
		List<RoomTypeEquipmentVo> equlst = record.getRoomtypeEquipmentVo();
		for(RoomTypeEquipmentVo aRoomtypeEquipment:equlst){
			RoomtypeEquipment romtype = new RoomtypeEquipment();
			romtype.setEquid(aRoomtypeEquipment.getEquid());
			romtype.setTypeid(typeid);
			romtype.setElecroad(aRoomtypeEquipment.getElecroad());
			romtype.setElename(aRoomtypeEquipment.getElename());
			romtype.setEquname(aRoomtypeEquipment.getEquname());
			romtype.setId(ZhsUnique.unique25());
			roomtypeEquipmentMapper.insert(romtype);
		}
		
		return roomTypeHotelMapper.insert(roomtype);
	}

	@Override
	public int insertSelective(RoomTypeHotel record) {
		// TODO Auto-generated method stub
		return roomTypeHotelMapper.insertSelective(record);
	}

	@Override
	public List<RoomTypeHotel> selectByExample(RoomTypeHotelExample example) {
		// TODO Auto-generated method stub
		return roomTypeHotelMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(RoomTypeHotel record, RoomTypeHotelExample example) {
		// TODO Auto-generated method stub
		return roomTypeHotelMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(RoomTypeHotel record, RoomTypeHotelExample example) {
		// TODO Auto-generated method stub
		return roomTypeHotelMapper.updateByExample(record, example);
	}
	
	@Override
	public List<RoomTypeInfo> selectById(String id) {
		// TODO Auto-generated method stub
		return roomTypeHotelMapper.selectById(id);
	}
	/**
	 * 修改房间类型
	 */
	@Override
	public int updateById(RoomTypeInfo record) {
		RoomTypeHotel roomtype = new RoomTypeHotel();
		roomtype.setId(record.getRmtypeid());
		roomtype.setRmtypename(record.getRmtypename());
		List<RoomTypeEquipmentVo> equlst = record.getRoomtypeEquipmentVo();
		RoomtypeEquipmentExample example = new RoomtypeEquipmentExample();
		example.createCriteria().andTypeidEqualTo(record.getRmtypeid());
		List<RoomtypeEquipment> roomEquLst = roomtypeEquipmentMapper.selectByExample(example);
		java.util.Map<String,RoomtypeEquipment> mapequ = new HashMap<String,RoomtypeEquipment>();
		for(RoomtypeEquipment equ:roomEquLst){
			boolean tag = false;
			for(RoomTypeEquipmentVo aRoomtypeEquipment:equlst){
				if(equ.getId().equals(aRoomtypeEquipment.getId())){
					tag = true;
				}
			}
			if(!tag){
				mapequ.put(equ.getTypeid(), equ);
			}
		}
		for(RoomTypeEquipmentVo aRoomtypeEquipment:equlst){
			RoomtypeEquipment romtype = new RoomtypeEquipment();
			if(aRoomtypeEquipment.getId()!=null && !"".equals(aRoomtypeEquipment.getId())){
				
					romtype.setId(aRoomtypeEquipment.getId());
					romtype.setEquid(aRoomtypeEquipment.getEquid());
					romtype.setTypeid(record.getRmtypeid());
					romtype.setEquname(aRoomtypeEquipment.getEquname());
					romtype.setEquid(aRoomtypeEquipment.getEquid());
					romtype.setElename(aRoomtypeEquipment.getElename());
					romtype.setElecroad(aRoomtypeEquipment.getElecroad());
					roomtypeEquipmentMapper.updateByPrimaryKeySelective(romtype);
				
			}else{
				romtype.setId(ZhsUnique.unique25());
				romtype.setEquid(aRoomtypeEquipment.getEquid());
				romtype.setTypeid(record.getRmtypeid());
				romtype.setEquname(aRoomtypeEquipment.getEquname());
				romtype.setEquid(aRoomtypeEquipment.getEquid());
				romtype.setElename(aRoomtypeEquipment.getElename());
				romtype.setElecroad(aRoomtypeEquipment.getElecroad());
				roomtypeEquipmentMapper.insert(romtype);
			}
		}
		
		Iterator itequ = mapequ.keySet().iterator();
		while(itequ.hasNext()){
			String typeid = itequ.next().toString();
			RoomtypeEquipment aEqu = mapequ.get(typeid);
			roomtypeEquipmentMapper.deleteByPrimaryKey(aEqu.getId());
		}
	
		return roomTypeHotelMapper.updateByPrimaryKeySelective(roomtype);
	}

	@Override
	public List<RoomTypeInfo> selectRoomList(RoomTypeHotelExample example) {
		// TODO Auto-generated method stub
		return roomTypeHotelMapper.selectRoomList(example);
	}
	
}
