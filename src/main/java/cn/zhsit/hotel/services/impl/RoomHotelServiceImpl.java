package cn.zhsit.hotel.services.impl;

import java.util.List;

import cn.zhsit.hotel.daos.EquipmentHotelMapper;
import cn.zhsit.hotel.models.vo.RoomEquReqVo;
import cn.zhsit.hotel.models.vo.RoomHotelEquRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.RoomHotelMapper;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.models.po.RoomHotelExample;
import cn.zhsit.hotel.models.vo.RoomHotelBeanVo;
import cn.zhsit.hotel.models.vo.RoomHotelVo;
import cn.zhsit.hotel.services.RoomHotelService;
/**
 * 房间信息管理
 * @author ChanPin
 *
 */
@Service
public class RoomHotelServiceImpl implements RoomHotelService{
	@Autowired
    private RoomHotelMapper roomHotelMapper;
	@Autowired
	private EquipmentHotelMapper equipmentHotelMapper;
	@Override
	public long countByExample(RoomHotelExample example) {
		// TODO Auto-generated method stub
		return roomHotelMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RoomHotelExample example) {
		// TODO Auto-generated method stub
		return roomHotelMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return roomHotelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RoomHotel record) {
		// TODO Auto-generated method stub
		return roomHotelMapper.insert(record);
	}

	@Override
	public int insertSelective(RoomHotel record) {
		// TODO Auto-generated method stub
		return roomHotelMapper.insertSelective(record);
	}

	@Override
	public List<RoomHotel> selectByExample(RoomHotelExample example) {
		// TODO Auto-generated method stub
		return roomHotelMapper.selectByExample(example);
	}

	@Override
	public RoomHotel selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return roomHotelMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(RoomHotel record, RoomHotelExample example) {
		// TODO Auto-generated method stub
		return roomHotelMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(RoomHotel record, RoomHotelExample example) {
		// TODO Auto-generated method stub
		return roomHotelMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(RoomHotel record) {
		// TODO Auto-generated method stub
		return roomHotelMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RoomHotel record) {
		// TODO Auto-generated method stub
		return roomHotelMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<RoomHotelBeanVo> selectByFloorid(RoomHotelVo roomhotel) {
		// TODO Auto-generated method stub
		return roomHotelMapper.selectByFloorid(roomhotel);
	}

	@Override
	public List<RoomHotelEquRespVo> selectByRoomId(RoomEquReqVo roomEquReqVo) {
		return roomHotelMapper.selectByRoomId(roomEquReqVo);

	}

}
