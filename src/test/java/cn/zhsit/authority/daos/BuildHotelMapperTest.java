package cn.zhsit.authority.daos;

import cn.zhsit.ServerApplication;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.hotel.daos.BuildingHotelMapper;
import cn.zhsit.hotel.models.po.BuildingHotel;

import java.util.List;

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
public class BuildHotelMapperTest {
    @Autowired
    public BuildingHotelMapper buildingHotelMapper;

    @Test
    public void testAdd() {
        BuildingHotel userAuthority = new BuildingHotel();
        userAuthority.setBuildingId("1");
        userAuthority.setBuildingName("test");
        buildingHotelMapper.insert(userAuthority);
    }
    
    @Test
    public void testFind() {
        BuildingHotel userAuthority = new BuildingHotel();
        List<BuildingHotel> lst = buildingHotelMapper.selectByManagerId("1");
        System.out.println(lst.get(0).toString());
    }
}
