package cn.zhsit.authority.manage;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import cn.zhsit.authority.daos.RoleAuthorityMapper;
import cn.zhsit.authority.models.po.RoleAuthority;
import cn.zhsit.common.enums.RoleEnum;
import cn.zhsit.common.utils.ZhsUnique;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Darren on 2017/7/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class RoleTest extends BaseTest {
    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;


    //添加管理员角色
    @Test
    public void addAdmin() {
        RoleAuthority ra = new RoleAuthority();
        ra.setId(ZhsUnique.unique25());
        ra.setCode(RoleEnum.Super.getCode());
        ra.setName(RoleEnum.Super.getName());
        ra.setDescr(RoleEnum.Super.getDescr());
        ra.setOrderNum(RoleEnum.Super.getOrderNum());
        ra.setCreateTime(current);
        ra.setModifyTime(current);
        roleAuthorityMapper.insert(ra);
    }

    @Override
    @Test
    public void addAll() throws Exception {
        addAdmin();

    }
}
