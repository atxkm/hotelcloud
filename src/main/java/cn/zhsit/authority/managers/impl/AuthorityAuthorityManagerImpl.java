package cn.zhsit.authority.managers.impl;

import cn.zhsit.authority.daos.AuthorityAuthorityMapper;
import cn.zhsit.authority.managers.AuthorityAuthorityManager;
import cn.zhsit.authority.models.po.AuthorityAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Darren on 2017/7/3.
 */
@Component
//@Transactional(rollbackFor = Exception.class)
public class AuthorityAuthorityManagerImpl implements AuthorityAuthorityManager {
    @Autowired
    private AuthorityAuthorityMapper authorityAuthorityMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addAuthorityAuthority(List<AuthorityAuthority> list)  {
        for (AuthorityAuthority aa : list) {
            authorityAuthorityMapper.insert(aa);
        }
        return true;
    }
}
