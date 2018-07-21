package cn.zhsit.hotel.services.impl;

import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.common.handlers.ZhsContextHandler;
import cn.zhsit.hotel.daos.EnterupMapper;
import cn.zhsit.hotel.models.po.Enterup;
import cn.zhsit.hotel.models.po.EnterupExample;
import cn.zhsit.hotel.services.EnterupService;
import cn.zhsit.models.vo.CheckLoggedReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class EnterupServiceImpl implements EnterupService {
	@Autowired
	private CacheHelper cacheHelper;
	@Autowired
	EnterupMapper enterupMapper;
	@Override
	public long countByExample(EnterupExample example) {
		// TODO Auto-generated method stub
		return enterupMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(EnterupExample example) {
		// TODO Auto-generated method stub
		return enterupMapper.deleteByExample(example);
	}

	@Override
	public int insert(Enterup record) {
		// TODO Auto-generated method stub
		return enterupMapper.insert(record);
	}

	@Override
	public int insertSelective(Enterup record) {
		// TODO Auto-generated method stub
		return enterupMapper.insertSelective(record);
	}

	@Override
	public List<Enterup> selectByExample(EnterupExample example) {
		// TODO Auto-generated method stub
		return enterupMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Enterup record, EnterupExample example) {
		// TODO Auto-generated method stub
		return enterupMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Enterup record, EnterupExample example) {
		// TODO Auto-generated method stub
		return enterupMapper.updateByExample(record, example);
	}

	@Override
	public int deleteByPrimaryKey(String enterid) {
		// TODO Auto-generated method stub
		return enterupMapper.deleteByPrimaryKey(enterid);
	}

	@Override
	public Enterup selectByPrimaryKey(String enterid) {
		// TODO Auto-generated method stub
		return enterupMapper.selectByPrimaryKey(enterid);
	}

	@Override
	public int updateByPrimaryKeySelective(Enterup record) {
		// TODO Auto-generated method stub
		return enterupMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Enterup record) {
		// TODO Auto-generated method stub
		return enterupMapper.updateByPrimaryKey(record);
	}

	@Override
	public LoginStatus checkLogged(CheckLoggedReq check, Errors errors) {
		ZhsSession zhsSession = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
		return zhsSession.getLoginStatus();
	}
	@Override
	public LoginStatus checkLogged() {
		ZhsSession zhsSession = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
		return zhsSession.getLoginStatus();
	}

}
