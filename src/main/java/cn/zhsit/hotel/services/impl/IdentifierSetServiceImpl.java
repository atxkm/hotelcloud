package cn.zhsit.hotel.services.impl;

import java.util.List;

import org.apache.poi.util.IdentifierManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.IdentifierSetMapper;
import cn.zhsit.hotel.models.po.IdentifierSet;
import cn.zhsit.hotel.models.po.IdentifierSetExample;
import cn.zhsit.hotel.services.IdentifierSetService;
@Service
public class IdentifierSetServiceImpl implements IdentifierSetService {
	@Autowired
    private IdentifierSetMapper identifierSetMapper;
	@Override
	public long countByExample(IdentifierSetExample example) {
		// TODO Auto-generated method stub
		return identifierSetMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(IdentifierSetExample example) {
		// TODO Auto-generated method stub
		return identifierSetMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return identifierSetMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(IdentifierSet record) {
		// TODO Auto-generated method stub
		return identifierSetMapper.insert(record);
	}

	@Override
	public int insertSelective(IdentifierSet record) {
		// TODO Auto-generated method stub
		return identifierSetMapper.insertSelective(record);
	}

	@Override
	public List<IdentifierSet> selectByExample(IdentifierSetExample example) {
		// TODO Auto-generated method stub
		return identifierSetMapper.selectByExample(example);
	}

	@Override
	public IdentifierSet selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return identifierSetMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(IdentifierSet record, IdentifierSetExample example) {
		// TODO Auto-generated method stub
		return identifierSetMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(IdentifierSet record, IdentifierSetExample example) {
		// TODO Auto-generated method stub
		return identifierSetMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(IdentifierSet record) {
		// TODO Auto-generated method stub
		return identifierSetMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(IdentifierSet record) {
		// TODO Auto-generated method stub
		return identifierSetMapper.updateByPrimaryKey(record);
	}

}
