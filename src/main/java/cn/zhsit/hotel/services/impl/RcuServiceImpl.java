package cn.zhsit.hotel.services.impl;

import java.util.List;

import cn.zhsit.models.vo.RcuReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.RcuMapper;
import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import cn.zhsit.hotel.services.RcuService;
@Service
public class RcuServiceImpl implements RcuService {
	@Autowired
	RcuMapper rcuMapper;
	@Override
	public long countByExample(RcuExample example) {
		// TODO Auto-generated method stub
		return rcuMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RcuExample example) {
		// TODO Auto-generated method stub
		return rcuMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String rcuid) {
		// TODO Auto-generated method stub
		return rcuMapper.deleteByPrimaryKey(rcuid);
	}


	@Override
	public List<Rcu> selectByExample(RcuExample example) {
		// TODO Auto-generated method stub
		return rcuMapper.selectByExample(example);
	}



	@Override
	public int updateByExample(Rcu record, RcuExample example) {
		// TODO Auto-generated method stub
		return rcuMapper.updateByExample(record, example);
	}


	@Override
	public int updateByPrimaryKey(Rcu record) {
		// TODO Auto-generated method stub
		return rcuMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertRcu(List<Rcu> rcus) {
		int tag = 0;
		for(int i=0;i<rcus.size();i++){
			Rcu rcu = rcus.get(i);
			Rcu findrcu = rcuMapper.selectByPrimaryKey(rcu.getRcuid());
			if(findrcu!=null){
				rcuMapper.updateByPrimaryKey(rcu);
			}else{
				rcuMapper.insert(rcu);
			}
			tag++;
		}
		return tag;
	}

	@Override
	public List<Rcu> selectByFloorId(RcuReq rcuReq) {
		return rcuMapper.selectByFloorId(rcuReq);
	}

	@Override
	public long countByFloorid(RcuReq rcuReq) {
		return rcuMapper.countByFloorid(rcuReq);
	}

	public int insert(Rcu rcu){
		
		return rcuMapper.insert(rcu);
	}

	@Override
	public int insertSelective(Rcu record) {
		// TODO Auto-generated method stub
		return rcuMapper.insertSelective(record);
	}

	@Override
	public Rcu selectByPrimaryKey(String rcuid) {
		// TODO Auto-generated method stub
		return rcuMapper.selectByPrimaryKey(rcuid);
	}

	@Override
	public int updateByExampleSelective(Rcu record, RcuExample example) {
		// TODO Auto-generated method stub
		return rcuMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Rcu record) {
		// TODO Auto-generated method stub
		return rcuMapper.updateByPrimaryKeySelective(record);
	}
}
