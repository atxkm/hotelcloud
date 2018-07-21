package cn.zhsit.authority.daos;

import cn.zhsit.ServerApplication;
import cn.zhsit.authority.models.po.PersonAuthority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Darren on 2017/7/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
public class UserAuthorityMapperTest {
    @Autowired
    public PersonAuthorityMapper personAuthorityMapper;

    @Test
    public void test() {
        PersonAuthority userAuthority = new PersonAuthority();
        userAuthority.setId("g111112555");
        personAuthorityMapper.insert(userAuthority);
    }
}
