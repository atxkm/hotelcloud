package cn.zhsit.hotel.daos;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import cn.zhsit.common.enums.MessageActors;
import cn.zhsit.common.enums.MessageStatus;
import cn.zhsit.common.enums.MessageType;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/11/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class MessageMapperTest extends BaseTest {

    @Test
    public void testAddCustomerMessage(){
        Message msg=new Message();
        msg.setMessageid(ZhsUnique.unique25());
        msg.setMessageType(MessageType.Room.getCode());
        msg.setRoomId("fnu5ufk3xq0j0wcisc0l8rdt");

        msg.setContent("退房");
        msg.setReceiver(MessageActors.Staff.getCode());
        msg.setSender(MessageActors.Customer.getCode());
        msg.setSendStatus(MessageStatus.Not.getCode());
        msg.setSpeakStatus(MessageStatus.Not.getCode());
        msg.setCreateTime(current);
        messageMapper.insert(msg);
    }

    @Test
    public void testAddStaffMessage(){
        Message msg=new Message();
        msg.setMessageid(ZhsUnique.unique25());
        msg.setMessageType(MessageType.Room.getCode());
        msg.setRoomId("fnu5ufk3xq0j0wcisc0l8rdt");
        msg.setPersonId("2hiq8nvbpcd34c6ann90q56bw");
        msg.setContent("请来前台");
        msg.setReceiver(MessageActors.Customer.getCode());
        msg.setSender(MessageActors.Staff.getCode());
        msg.setSendStatus(MessageStatus.Not.getCode());
        msg.setSpeakStatus(MessageStatus.Not.getCode());
        msg.setCreateTime(current);
        messageMapper.insert(msg);
    }
    @Override
    @Test
    public void addAll() throws Exception {

    }

    @Override
    @Test
    public void addDevAll() throws Exception {
        testAddCustomerMessage();
        testAddStaffMessage();
    }
}
