package cn.zhsit.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.EquipmentHotelMapper;
import cn.zhsit.hotel.models.po.EquipmentHotel;
import cn.zhsit.hotel.models.po.EquipmentHotelExample;
import cn.zhsit.hotel.services.EquipmentHotelService;
@Service
public class EquipmentHotelServiceImpl implements EquipmentHotelService {
	@Autowired
	EquipmentHotelMapper equipmentHotelMapper;
	@Override
	public long countByExample(EquipmentHotelExample example) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(EquipmentHotelExample example) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(EquipmentHotel record) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.insert(record);
	}

	@Override
	public int insertSelective(EquipmentHotel record) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.insertSelective(record);
	}

	@Override
	public List<EquipmentHotel> selectByExample(EquipmentHotelExample example) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.selectByExample(example);
	}

	@Override
	public EquipmentHotel selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(EquipmentHotel record, EquipmentHotelExample example) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(EquipmentHotel record, EquipmentHotelExample example) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(EquipmentHotel record) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(EquipmentHotel record) {
		// TODO Auto-generated method stub
		return equipmentHotelMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<EquipmentHotel> selectEquByHost(String host) {
		return equipmentHotelMapper.selectEquByHost(host);
	}

}
