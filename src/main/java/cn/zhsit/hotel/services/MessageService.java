package cn.zhsit.hotel.services;

import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.MessageExample;
import cn.zhsit.models.vo.H5WSBody;
import cn.zhsit.models.vo.MessageReq;
import cn.zhsit.models.vo.MessageResp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/11/5.
 */
public interface MessageService {

    /**
     * 查询未发送给H5的消息
     * @param req
     * @return
     */
    H5WSBody findNotSendMessage(MessageReq req);

    void modifySendStatus(List<MessageResp> list);
    
    
    
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(String messageid);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(String messageid);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}
