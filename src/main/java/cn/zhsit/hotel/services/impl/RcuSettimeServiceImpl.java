package cn.zhsit.hotel.services.impl;

import java.util.List;

import cn.zhsit.hotel.models.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.RcuMapper;
import cn.zhsit.hotel.daos.RcuSettimeMapper;
import cn.zhsit.hotel.services.RcuService;
import cn.zhsit.hotel.services.RcuSettimeService;
@Service
public class RcuSettimeServiceImpl implements RcuSettimeService {
	@Autowired
	RcuSettimeMapper rcuSettimeMapper;

	@Override
	public long countByExample(RcuSettimeExample example) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RcuSettimeExample example) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String rcuid) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.deleteByPrimaryKey(rcuid);
	}

	@Override
	public int insert(RcuSettime record) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.insert(record);
	}

	@Override
	public int insertSelective(RcuSettime record) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.insertSelective(record);
	}

	
	@Override
	public List<RcuSettime> selectByExample(RcuSettimeExample example) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.selectByExample(example);
	}

	@Override
	public RcuSettime selectByPrimaryKey(String rcuid) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.selectByPrimaryKey(rcuid);
	}

	@Override
	public int updateByExampleSelective(RcuSettime record, RcuSettimeExample example) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.updateByExampleSelective(record, example);
	}

	

	@Override
	public int updateByExample(RcuSettime record, RcuSettimeExample example) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(RcuSettime record) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.updateByPrimaryKeySelective(record);
	}

	

	@Override
	public int updateByPrimaryKey(RcuSettime record) {
		// TODO Auto-generated method stub
		return rcuSettimeMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertRcuSetimes(List<RcuSettime> rcus) {
		int tag = 0;
		for(int i=0;i<rcus.size();i++){
			RcuSettime rcu = rcus.get(i);
			RcuSettime findrcu = rcuSettimeMapper.selectByPrimaryKey(rcu.getRcuid());
			if(findrcu!=null){
				rcuSettimeMapper.updateByPrimaryKey(rcu);
			}else{
				rcuSettimeMapper.insert(rcu);
			}
			tag++;
		}
		return tag;
	}

}
