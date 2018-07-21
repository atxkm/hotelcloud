package cn.zhsit;

import cn.zhsit.authority.manage.*;
import cn.zhsit.daos.PersonAuthorityTest;
import cn.zhsit.hotel.daos.MessageMapperTest;
import cn.zhsit.hotel.daos.RoomHotelMapperTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Darren on 2017/7/11.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {ManageApplication.class
//        , RoleTest.class
//        , PersonTest.class
//        , PersonRoleTest.class
//        ,AuthorityCollect.class
//        , AuthorityTest.class
//        , RoomHotelMapperTest.class
//})
//
//@Component
//@Rollback(false)

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class
        , PersonAuthorityTest.class
        , MessageMapperTest.class
})

@Component
@Rollback(false)
public class CreateAll extends BaseTest {
//
//    @Autowired
//    RoleTest roleTest;
//    @Autowired
//    PersonTest personTest;
//    @Autowired
//    PersonRoleTest personRoleTest;
//    @Autowired
//    AuthorityCollect authorityCollect;
//    @Autowired
//    AuthorityTest authorityTest;
//    @Autowired
//    RoomHotelMapperTest roomHotelMapperTest;
//
//
//    @Override
//    @Test
//    public void addAll() throws Exception{
//        authorityCollect.addAll();
//        roleTest.addAll();
//        personTest.addAll();
//        personRoleTest.addAll();
//        authorityTest.addAll();
//        roomHotelMapperTest.addAll();
//    }


    @Autowired PersonAuthorityTest personAuthorityTest;
    @Autowired MessageMapperTest messageMapperTest;

    @Override
    @Test
    public void addAll() throws Exception {
        personAuthorityTest.addAll();
        messageMapperTest.addAll();
    }

    @Override
    @Test
    public void addDevAll() throws Exception {
        personAuthorityTest.addDevAll();
        messageMapperTest.addDevAll();
    }
}
