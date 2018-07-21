package cn.zhsit.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.ElectricRoadMapper;
import cn.zhsit.hotel.models.po.ElectricRoad;
import cn.zhsit.hotel.models.po.ElectricRoadExample;
import cn.zhsit.hotel.services.ElectricRoadService;
@Service
public class ElectricRoadServiceImp implements ElectricRoadService {
	@Autowired
	private ElectricRoadMapper electricRoadMapper;
	@Override
	public long countByExample(ElectricRoadExample example) {
		// TODO Auto-generated method stub
		return electricRoadMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ElectricRoadExample example) {
		// TODO Auto-generated method stub
		return electricRoadMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return electricRoadMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ElectricRoad record) {
		// TODO Auto-generated method stub
		return electricRoadMapper.insert(record);
	}

	@Override
	public int insertSelective(ElectricRoad record) {
		// TODO Auto-generated method stub
		return electricRoadMapper.insertSelective(record);
	}

	@Override
	public List<ElectricRoad> selectByExample(ElectricRoadExample example) {
		// TODO Auto-generated method stub
		return electricRoadMapper.selectByExample(example);
	}

	@Override
	public ElectricRoad selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return electricRoadMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(ElectricRoad record, ElectricRoadExample example) {
		// TODO Auto-generated method stub
		return electricRoadMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ElectricRoad record, ElectricRoadExample example) {
		// TODO Auto-generated method stub
		return electricRoadMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ElectricRoad record) {
		// TODO Auto-generated method stub
		return electricRoadMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ElectricRoad record) {
		// TODO Auto-generated method stub
		return electricRoadMapper.updateByPrimaryKey(record);
	}

}
