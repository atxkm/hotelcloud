package cn.zhsit.authority.manage;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import cn.zhsit.TestConstants;
import cn.zhsit.authority.daos.AuthorityAuthorityMapper;
import cn.zhsit.authority.daos.RoleAuthorityRelationAuthorityMapper;
import cn.zhsit.authority.models.po.AuthorityAuthority;
import cn.zhsit.authority.models.po.AuthorityAuthorityExample;
import cn.zhsit.authority.models.po.RoleAuthorityRelationAuthority;
import cn.zhsit.common.enums.RoleEnum;
import cn.zhsit.common.utils.ZhsUnique;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Darren on 2017/7/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class AuthorityTest extends BaseTest {
    @Autowired
    private AuthorityAuthorityMapper authorityAuthorityMapper;
    @Autowired
    private RoleAuthorityRelationAuthorityMapper roleAuthorityRelationAuthorityMapper;

    //添加管理员角色
    @Test
    public void setAdminAuthority() {
        List<AuthorityAuthority> list = selectByGroup(TestConstants.Authority.GroupCRUSet);
        list.forEach(a->{
            RoleAuthorityRelationAuthority rar=new RoleAuthorityRelationAuthority();
            rar.setId(ZhsUnique.unique25());
            rar.setRoleCode(RoleEnum.Super.getCode());
            rar.setAuthorityCode(a.getCode());
            rar.setCreateTime(current);
            roleAuthorityRelationAuthorityMapper.insert(rar);
        });
    }


    @Override
    @Test
    public void addAll() throws Exception {
        setAdminAuthority();

    }

    private List<AuthorityAuthority> selectByGroup(String group) {
        AuthorityAuthorityExample authorityExample = new AuthorityAuthorityExample();
        authorityExample.createCriteria().andAuthorityGroupEqualTo(group);
        return authorityAuthorityMapper.selectByExample(authorityExample);
    }
}
