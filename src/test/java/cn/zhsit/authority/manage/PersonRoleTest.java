package cn.zhsit.authority.manage;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import cn.zhsit.TestConstants;
import cn.zhsit.authority.daos.PersonAuthorityMapper;
import cn.zhsit.authority.daos.PersonRoleRelationAuthorityMapper;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;
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
 * Created by Darren on 2017/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class PersonRoleTest extends BaseTest {
    @Autowired
    PersonAuthorityMapper personAuthorityMapper;
    @Autowired
    PersonRoleRelationAuthorityMapper personRoleRelationAuthorityMapper;

    @Test
    public void addFengAdmin(){
        PersonAuthorityExample p=new PersonAuthorityExample();
        p.createCriteria().andLoginNameEqualTo(TestConstants.Person.LoginNameFeng);
        List<PersonAuthority> personList = personAuthorityMapper.selectByExample(p);
        PersonRoleRelationAuthority prr=new PersonRoleRelationAuthority();
        prr.setId(ZhsUnique.unique25());
        prr.setRoleCode(RoleEnum.Super.getCode());
        prr.setPersonId(personList.get(0).getId());
        prr.setCreateTime(current);
        personRoleRelationAuthorityMapper.insert(prr);
    }

    @Override
    @Test
    public void addAll() throws Exception{
        addFengAdmin();
    }
}
