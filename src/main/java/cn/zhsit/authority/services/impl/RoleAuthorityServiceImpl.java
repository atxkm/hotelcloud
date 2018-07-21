package cn.zhsit.authority.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.authority.daos.RoleAuthorityMapper;
import cn.zhsit.authority.daos.RoleAuthorityRelationAuthorityMapper;
import cn.zhsit.authority.models.po.RoleAuthority;
import cn.zhsit.authority.models.po.RoleAuthorityExample;
import cn.zhsit.authority.models.po.RoleAuthorityRelationAuthority;
import cn.zhsit.authority.services.RoleAuthorityService;
@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService{
	@Autowired
    private RoleAuthorityMapper roleAuthorityMapper;
	
	@Override
	public long countByExample(RoleAuthorityExample example) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RoleAuthorityExample example) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RoleAuthority record) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.insert(record);
	}

	@Override
	public int insertSelective(RoleAuthority record) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.insertSelective(record);
	}

	@Override
	public List<RoleAuthority> selectByExample(RoleAuthorityExample example) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.selectByExample(example);
	}

	@Override
	public RoleAuthority selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(RoleAuthority record, RoleAuthorityExample example) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(RoleAuthority record, RoleAuthorityExample example) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(RoleAuthority record) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RoleAuthority record) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.updateByPrimaryKey(record);
	}

}
