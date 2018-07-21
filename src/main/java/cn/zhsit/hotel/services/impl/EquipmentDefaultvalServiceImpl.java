package cn.zhsit.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.EquipmentDefaultvalMapper;
import cn.zhsit.hotel.models.po.EquipmentDefaultval;
import cn.zhsit.hotel.models.po.EquipmentDefaultvalExample;
import cn.zhsit.hotel.services.EquipmentDefaultvalService;
@Service
public class EquipmentDefaultvalServiceImpl implements EquipmentDefaultvalService{
	@Autowired
	EquipmentDefaultvalMapper equipmentDefaultvalMapper;
	@Override
	public long countByExample(EquipmentDefaultvalExample example) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(EquipmentDefaultvalExample example) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String modelid) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.deleteByPrimaryKey(modelid);
	}

	@Override
	public int insert(EquipmentDefaultval record) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.insert(record);
	}

	@Override
	public int insertSelective(EquipmentDefaultval record) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.insertSelective(record);
	}

	@Override
	public List<EquipmentDefaultval> selectByExample(EquipmentDefaultvalExample example) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.selectByExample(example);
	}

	@Override
	public EquipmentDefaultval selectByPrimaryKey(String modelid) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.selectByPrimaryKey(modelid);
	}

	@Override
	public int updateByExampleSelective(EquipmentDefaultval record, EquipmentDefaultvalExample example) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(EquipmentDefaultval record, EquipmentDefaultvalExample example) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(EquipmentDefaultval record) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(EquipmentDefaultval record) {
		// TODO Auto-generated method stub
		return equipmentDefaultvalMapper.updateByPrimaryKey(record);
	}

}
