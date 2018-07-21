package cn.zhsit.authority.managers.impl;

import cn.zhsit.authority.api.models.ConstantsAuthority;
import cn.zhsit.authority.daos.PersonAuthorityMapper;
import cn.zhsit.authority.managers.PersonAuthorityManager;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Darren on 2017/7/11.
 */
@Component
public class PersonAuthorityManagerImpl implements PersonAuthorityManager{
    @Autowired
    private PersonAuthorityMapper personAuthorityMapper;

    @Override
    @Cacheable(value = ConstantsAuthority.CacheKey.ZhsPersonRoleAuthorityOrgCacheName, key = "#personId+'_"+ConstantsAuthority.CacheKey.PersonAuthority+"'", unless = "#result == null")
    public PersonAuthority selectByKey(String personId) {
        return personAuthorityMapper.selectByPrimaryKey(personId);
    }


    @Override
    public PersonAuthority selectByLoginName(String loginName) {
        PersonAuthorityExample q=new PersonAuthorityExample();
        q.createCriteria().andLoginNameEqualTo(loginName);
        List<PersonAuthority> list= personAuthorityMapper.selectByExample(q);
        if (list.size() < 1) {
            return null;
        }
        return list.get(0);
    }

    @Override
    @CacheEvict(value = ConstantsAuthority.CacheKey.ZhsPersonRoleAuthorityOrgCacheName
            ,key = "#personAuthority.id+'_" + ConstantsAuthority.CacheKey.PersonAuthority + "'"
    )
    public int updateByKey(PersonAuthority personAuthority) {
        personAuthority.setModifyTime(new Date());
        return personAuthorityMapper.updateByPrimaryKeySelective(personAuthority);
    }

    @Override
    @CacheEvict(value = ConstantsAuthority.CacheKey.ZhsPersonRoleAuthorityOrgCacheName
            ,key = "#personId+'_" + ConstantsAuthority.CacheKey.PersonAuthority + "'"
            ,beforeInvocation=true
    )
    public boolean removeCache(String personId) {
        return true;
    }
}
