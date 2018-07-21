package cn.zhsit.authority.api.impl;

import cn.zhsit.authority.api.ApiServiceAuthority;
import cn.zhsit.authority.api.models.AuthorityModel;
import cn.zhsit.authority.api.models.Person;
import cn.zhsit.authority.api.models.Wrapper;
import cn.zhsit.authority.managers.PersonAuthorityManager;
import cn.zhsit.authority.managers.RoleAuthorityManager;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.RoleAuthority;
import cn.zhsit.common.enums.RoleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Darren on 2017/6/29.
 */
//@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class ApiServiceAuthorityImpl implements ApiServiceAuthority {
    private static Logger log = LoggerFactory.getLogger(ApiServiceAuthorityImpl.class);
    @Autowired
    private PersonAuthorityManager personAuthorityManager;
    @Autowired
    private RoleAuthorityManager roleAuthorityManager;

    @Override
    public Wrapper<Person> personOpera(Wrapper<Person> wrapper) {
        Person person = wrapper.getT();
        Wrapper.Opera opera = wrapper.getOpera();
        switch (opera) {
            case Find:
                return findPerson(wrapper);
            case Add:
                return addPerson(wrapper);

            default:
                return new Wrapper<Person>(person, opera).setSuccess(false);

        }
//        if (opera == Wrapper.Opera.Add) {
//            log.info("调用增加接口");
//            return new Wrapper<Person>(person, opera).setSuccess(true);
//        }
    }

    private Wrapper<Person> addPerson(Wrapper<Person> wrapper) {
        return null;
    }

    private Wrapper<Person> findPerson(Wrapper<Person> wrapper) {
        Person person = new Person();//模拟从数据库查询到数据
        person.setId("er12345678io");
        person.setLoginName("fengjt");
        person.setName("冯江涛");
        person.setRoleCode(RoleEnum.Super.getCode());
        wrapper.setT(person);
        wrapper.setSuccess(true);

        return wrapper;
    }

    @Override
    public Wrapper checkAuthority(Person person, AuthorityModel authority) {
        PersonAuthority pa = personAuthorityManager.selectByKey(person.getId());
        List<RoleAuthority> roleList = roleAuthorityManager.selectRoleListByPersonId(person.getId());
        log.info("checkAuthority:{}", "默认值");
        return new Wrapper().setSuccess(true).setMsg("默认值");
    }
}
