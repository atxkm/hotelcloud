package cn.zhsit.hotel.daos;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.RoomHotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Darren on 2017/7/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class RoomHotelMapperTest extends BaseTest{
    @Autowired
    private RoomHotelMapper roomHotelMapper;
    @Test
    public void createRoom() {
        RoomHotel roomHotel=new RoomHotel();
        roomHotel.setId(ZhsUnique.unique25());
        roomHotelMapper.insert(roomHotel);
    }
    @Override
    public void addAll() throws Exception {
        createRoom();
    }
}
