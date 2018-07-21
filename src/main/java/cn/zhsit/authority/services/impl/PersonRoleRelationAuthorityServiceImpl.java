package cn.zhsit.authority.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.authority.daos.PersonRoleRelationAuthorityMapper;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthorityExample;
import cn.zhsit.authority.services.PersonRoleRelationAuthorityService;
@Service
public class PersonRoleRelationAuthorityServiceImpl implements PersonRoleRelationAuthorityService {
	@Autowired
	private PersonRoleRelationAuthorityMapper personRoleRelationAuthorityMapper;
	@Override
	public long countByExample(PersonRoleRelationAuthorityExample example) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PersonRoleRelationAuthorityExample example) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PersonRoleRelationAuthority record) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.insert(record);
	}

	@Override
	public int insertSelective(PersonRoleRelationAuthority record) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.insertSelective(record);
	}

	@Override
	public List<PersonRoleRelationAuthority> selectByExample(PersonRoleRelationAuthorityExample example) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.selectByExample(example);
	}

	@Override
	public PersonRoleRelationAuthority selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(PersonRoleRelationAuthority record,
			PersonRoleRelationAuthorityExample example) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(PersonRoleRelationAuthority record, PersonRoleRelationAuthorityExample example) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(PersonRoleRelationAuthority record) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PersonRoleRelationAuthority record) {
		// TODO Auto-generated method stub
		return personRoleRelationAuthorityMapper.updateByPrimaryKey(record);
	}

}
