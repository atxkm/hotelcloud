package cn.zhsit.authority.managers.impl;

import cn.zhsit.authority.api.models.ConstantsAuthority;
import cn.zhsit.authority.daos.PersonRoleRelationAuthorityMapper;
import cn.zhsit.authority.daos.RoleAuthorityMapper;
import cn.zhsit.authority.managers.RoleAuthorityManager;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthorityExample;
import cn.zhsit.authority.models.po.RoleAuthority;
import cn.zhsit.authority.models.po.RoleAuthorityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2017/7/11.
 */
@Component
public class RoleAuthorityManagerImpl implements RoleAuthorityManager {
    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;
    @Autowired
    private PersonRoleRelationAuthorityMapper personRoleRelationAuthorityMapper;

    @Override
    @Cacheable(value = ConstantsAuthority.CacheKey.ZhsPersonRoleAuthorityOrgCacheName, key = "#personId+'_" + ConstantsAuthority.CacheKey.RoleAuthorityList + "'", unless = "#result == null")
    public List<RoleAuthority> selectRoleListByPersonId(String personId) {
        PersonRoleRelationAuthorityExample pra = new PersonRoleRelationAuthorityExample();
        pra.createCriteria().andPersonIdEqualTo(personId);
        List<PersonRoleRelationAuthority> relationList = personRoleRelationAuthorityMapper.selectByExample(pra);
        if (relationList.size() < 1) {
            return null;
        }
        List<String> roleIdList = new ArrayList<>();
        relationList.forEach(personRoleRelationAuthority -> {
            roleIdList.add(personRoleRelationAuthority.getRoleCode());
        });
        RoleAuthorityExample roleExample = new RoleAuthorityExample();
        roleExample.createCriteria().andCodeIn(roleIdList);

        List<RoleAuthority> roleAuthorityList = roleAuthorityMapper.selectByExample(roleExample);
        if (roleAuthorityList.size() < 1) {
            return null;
        }
        return roleAuthorityList;
    }
}
