package cn.zhsit.hotel.services.impl;

import cn.zhsit.common.enums.H5Code;
import cn.zhsit.common.enums.MessageActors;
import cn.zhsit.common.enums.MessageStatus;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.daos.MessageMapper;
import cn.zhsit.hotel.managers.MessageManager;
import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.MessageExample;
import cn.zhsit.hotel.services.MessageService;
import cn.zhsit.models.vo.H5WSBody;
import cn.zhsit.models.vo.MessageReq;
import cn.zhsit.models.vo.MessageResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 */
@Service
public class MessageServiceImpl implements MessageService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageManager messageManager;
    @Autowired
    private MessageMapper messageMapper;
    int i = 0;

    @Override
    public H5WSBody findNotSendMessage(MessageReq req) {
        i++;
        H5WSBody body = new H5WSBody().fail();
        body.setCode(H5Code.ServerResponseRoomMessage.getCode());
//        if (i % 10 == 2) {
//            body.message = "此用户无权限（测试环境随机生成失败场景）";
//            return body;
//        }
        MessageExample querySql = new MessageExample();
        querySql.createCriteria().andRoomIdEqualTo(req.getRoomId())
                .andSendStatusEqualTo(MessageStatus.Not.getCode())
                .andReceiverEqualTo(MessageActors.Staff.getCode());
        querySql.setOrderByClause("create_time");
        querySql.setPage(new Page().setPage(0).setRows(100));
        List<Message> messages = messageManager.select(querySql);
        List<MessageResp> list = new ArrayList<>();
        body.success();
        body.setData(list);
        for (Message msg : messages) {
            MessageResp resp = new MessageResp();
            list.add(resp);
            resp.setMessageid(msg.getMessageid());
            resp.setContent(msg.getContent());
            resp.setReceiver(msg.getReceiver());
            resp.setSender(msg.getSender());
        }
        return body;
    }

    @Override
    public void modifySendStatus(List<MessageResp> list) {
        Date current = new Date();
        List<Message> messages = new ArrayList<>();
        for (MessageResp resp : list) {
            Message po = new Message();
            po.setMessageid(resp.getMessageid());
            messages.add(po);
            po.setSendDateTime(current);
            po.setSendStatus(MessageStatus.Yet.getCode());
        }
        messageManager.update(messages);
    }

	@Override
	public long countByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return messageMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return messageMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String messageid) {
		// TODO Auto-generated method stub
		return messageMapper.deleteByPrimaryKey(messageid);
	}

	@Override
	public int insert(Message record) {
		// TODO Auto-generated method stub
		return messageMapper.insert(record);
	}

	@Override
	public int insertSelective(Message record) {
		// TODO Auto-generated method stub
		return messageMapper.insertSelective(record);
	}

	@Override
	public List<Message> selectByExample(MessageExample example) {
		// TODO Auto-generated method stub
		return messageMapper.selectByExample(example);
	}

	@Override
	public Message selectByPrimaryKey(String messageid) {
		// TODO Auto-generated method stub
		return messageMapper.selectByPrimaryKey(messageid);
	}

	@Override
	public int updateByExampleSelective(Message record, MessageExample example) {
		// TODO Auto-generated method stub
		return messageMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Message record, MessageExample example) {
		// TODO Auto-generated method stub
		return messageMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Message record) {
		// TODO Auto-generated method stub
		return messageMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Message record) {
		// TODO Auto-generated method stub
		return messageMapper.updateByPrimaryKey(record);
	}
}
