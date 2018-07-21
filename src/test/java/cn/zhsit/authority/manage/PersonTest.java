package cn.zhsit.authority.manage;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import cn.zhsit.TestConstants;
import cn.zhsit.authority.daos.PersonAuthorityMapper;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.common.enums.RoleEnum;
import cn.zhsit.common.utils.ZhsMD5;
import cn.zhsit.common.utils.ZhsUnique;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Darren on 2017/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class PersonTest extends BaseTest {
    @Autowired
    private PersonAuthorityMapper personAuthorityMapper;


    @Test
    public void addFeng() {
        PersonAuthority p = new PersonAuthority();
        p.setId(ZhsUnique.unique25());
        p.setLoginName(TestConstants.Person.LoginNameFeng);
        p.setName("冯江涛");
        p.setPwd(ZhsMD5.md5Twice("111111"));
        p.setCreateTime(current);
        p.setModifyTime(current);
        personAuthorityMapper.insert(p);
    }

    @Override
    public void addAll() throws Exception {
        addFeng();
    }
}
