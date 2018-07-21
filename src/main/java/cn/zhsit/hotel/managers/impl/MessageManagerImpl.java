package cn.zhsit.hotel.managers.impl;

import cn.zhsit.hotel.daos.MessageMapper;
import cn.zhsit.hotel.managers.MessageManager;
import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.MessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 */
@Component
public class MessageManagerImpl implements MessageManager {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> select(MessageExample querySql) {
        return messageMapper.selectByExample(querySql);
    }

    @Override
    public void update(List<Message> messages) {
        for (Message po : messages) {
            messageMapper.updateByPrimaryKeySelective(po);
        }
    }

    @Override
    public int add(Message po) {
        return messageMapper.insert(po);
    }
}
