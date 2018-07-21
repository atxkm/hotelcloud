package cn.zhsit.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.SoftRegMapper;
import cn.zhsit.hotel.models.po.SoftReg;
import cn.zhsit.hotel.models.po.SoftRegExample;
import cn.zhsit.hotel.services.SoftRegService;
@Service
public class SoftRegServiceImpl implements SoftRegService {
	@Autowired
	SoftRegMapper softRegMapper;
	@Override
	public long countByExample(SoftRegExample example) {
		// TODO Auto-generated method stub
		return softRegMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SoftRegExample example) {
		// TODO Auto-generated method stub
		return softRegMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return softRegMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SoftReg record) {
		// TODO Auto-generated method stub
		return softRegMapper.insert(record);
	}

	@Override
	public int insertSelective(SoftReg record) {
		// TODO Auto-generated method stub
		return softRegMapper.insertSelective(record);
	}

	@Override
	public List<SoftReg> selectByExample(SoftRegExample example) {
		// TODO Auto-generated method stub
		return softRegMapper.selectByExample(example);
	}

	@Override
	public SoftReg selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return softRegMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SoftReg record, SoftRegExample example) {
		// TODO Auto-generated method stub
		return softRegMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SoftReg record, SoftRegExample example) {
		// TODO Auto-generated method stub
		return softRegMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SoftReg record) {
		// TODO Auto-generated method stub
		return softRegMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SoftReg record) {
		// TODO Auto-generated method stub
		return softRegMapper.updateByPrimaryKey(record);
	}

}
