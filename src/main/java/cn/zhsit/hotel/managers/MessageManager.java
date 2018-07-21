package cn.zhsit.hotel.managers;

import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.MessageExample;


import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 */
public interface MessageManager {
    List<Message> select(MessageExample querySql);

    void update(List<Message> messages);

    int add(Message po);
}
