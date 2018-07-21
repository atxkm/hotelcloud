package cn.zhsit.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.hotel.daos.RcuMapper;
import cn.zhsit.hotel.daos.RcuSetparamMapper;
import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import cn.zhsit.hotel.models.po.RcuSetparam;
import cn.zhsit.hotel.models.po.RcuSetparamExample;
import cn.zhsit.hotel.services.RcuService;
import cn.zhsit.hotel.services.RcuSetparamService;
import cn.zhsit.models.vo.RcuSetparamReq;
@Service
public class RcuSetparamServiceImpl implements RcuSetparamService {
	@Autowired
	RcuSetparamMapper rcuSetparamMapper;

	@Override
	public long countByExample(RcuSetparamExample example) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RcuSetparamExample example) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String rcuid) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.deleteByPrimaryKey(rcuid);
	}

	@Override
	public int insert(RcuSetparam record) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.insert(record);
	}

	@Override
	public int insertSelective(RcuSetparam record) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.insertSelective(record);
	}

	

	@Override
	public List<RcuSetparam> selectByExample(RcuSetparamExample example) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.selectByExample(example);
	}

	@Override
	public RcuSetparam selectByPrimaryKey(String rcuid) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.selectByPrimaryKey(rcuid);
	}

	@Override
	public int updateByExampleSelective(RcuSetparam record, RcuSetparamExample example) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.updateByExampleSelective(record, example);
	}

	

	@Override
	public int updateByExample(RcuSetparam record, RcuSetparamExample example) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(RcuSetparam record) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.updateByPrimaryKeySelective(record);
	}

	

	@Override
	public int updateByPrimaryKey(RcuSetparam record) {
		// TODO Auto-generated method stub
		return rcuSetparamMapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertRcuSetparam(List<RcuSetparam> rcus) {
		int tag = 0;
		for(int i=0;i<rcus.size();i++){
			RcuSetparam rcu = rcus.get(i);
			RcuSetparam findrcu = rcuSetparamMapper.selectByPrimaryKey(rcu.getRcuid());
			if(findrcu!=null){
				rcuSetparamMapper.updateByPrimaryKey(rcu);
			}else{
				rcuSetparamMapper.insert(rcu);
			}
			tag++;
		}
		return tag;
	}

	@Override
	public List<RcuSetparam> selectByFloorid(RcuSetparamReq rcuSetparamReq) {
		
		return rcuSetparamMapper.selectByFloorid(rcuSetparamReq);
	}

	@Override
	public long countByFloorid(RcuSetparamReq rcuSetparamReq) {
		// TODO Auto-generated method stub
		Long temp =rcuSetparamMapper.countByFloorid(rcuSetparamReq);
		if(temp==null){
			return 0;
		}
		return temp;
	}

}
