package cn.zhsit.ws.rcu.parsers;

import cn.zhsit.common.constants.ZhsConstants;
import cn.zhsit.common.enums.MessageActors;
import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.enums.RoomEventType;
import cn.zhsit.common.utils.ZhsByteUtil;
import cn.zhsit.hotel.collections.EventCollection;
import cn.zhsit.hotel.collections.ToFrontDeskCollection;
import cn.zhsit.hotel.managers.RoomHotelManager;
import cn.zhsit.hotel.models.dto.HotelEvent;
import cn.zhsit.hotel.models.dto.MsgSendToFrontDeskPerson;
import cn.zhsit.hotel.models.po.RoomEventValue;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.rcu.RCU;
import cn.zhsit.hotel.rcu.XiaoQiao;
import cn.zhsit.hotel.services.EquipmentSetvalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

/**
 * Created by Administrator on 2017/10/23.
 */
@Component
public class RCUStatusParser {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RoomHotelManager roomHotelManager;
    @Autowired
    private EquipmentSetvalService equipmentSetvalService;

    //0000DC0040BAB0DFD6D7D06C212400C0A80181024E5E63BAB22BDEA140FFFFFF00BF908D48C0A80101F7699A6FC4304AAD00E2679119005ED80000000000DC00009598000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
    public boolean parse(RCU rcu, String data) {

        //此报文表示的RCU的起始地址
        String firstAddressHex = data.substring(0, 4);
        Integer firstAddress = Integer.valueOf(firstAddressHex, 16);
        //如果有机器人信息时，只有一个寄存器数据
        if (0 == (firstAddress - RCUAddressEnum.JiQiRenWenZi.getAddress())) {
            try {
                log.info("data:{}", data);
//                xiaoQiao.setLastTime(rcu.getLastTime());
                String sentenceGBKBytesHex = data.substring(6, data.length());
                byte[] sentenceGBKBytesArray = ZhsByteUtil.hexStringToBytes(sentenceGBKBytesHex);
                String sentence = new String(sentenceGBKBytesArray, ZhsConstants.GBK);

                log.info("机器人文字为:{}", sentence);
//                sendToFrontDesk(sentence);
                showSpeakJiQiRenWenZi(rcu.getHost(),sentence);
                return true;
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                log.error("将字节转换成机器人文字时异常", unsupportedEncodingException);
            }
            return false;
        }
        String lengthHex = data.substring(4, 6);
        int length = Integer.valueOf(lengthHex, 16);
        int arrayIndex = 6;
        //0000DC0040BAB0DFD6D7D06C212400C0A80181024E5E63BAB22BDEA140FFFFFF00BF908D48C0A80101F7699A6FC4304AAD00E2679119005ED80000000000DC00009598000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
        for (int i = 0; i < length; i = i + 1, arrayIndex = arrayIndex + 2) {
            String valHex = data.substring(arrayIndex, arrayIndex + 2);
            Integer key = (firstAddress + i);
            Integer val = Integer.valueOf(valHex, 16);
            //TODO 添加事件判断，将事件放到对应的队列中，有线程扫描队列，完成队列入库等操作
            rcu.addAddressStatus(key, val);
//            log.info("(firstAddress + i):{},valInteger:{}", key, val);
        }
        return true;
    }

    /**
     * 需要发往前端
     *
     * @param sentence
     */
    private void sendToFrontDesk(String sentence) {
        MsgSendToFrontDeskPerson msg = new MsgSendToFrontDeskPerson();
        msg.setDataString(sentence);
        ToFrontDeskCollection.putToFrontDeskPerson(msg);
    }


    /**
     * 机器人文字是否显示或播报
     *
     * @param host
     * @param sentence
     */
    public void showSpeakJiQiRenWenZi(String host, String sentence) {
        RoomEventValue roomEventValue = equipmentSetvalService.checkMsgIfShow(RoomEventType.JiQiRenWenZi, null);
        if (roomEventValue.isSetval()) {
            Integer times = roomEventValue.getNumbertime();
            if (times != null) {
                RoomHotel room = roomHotelManager.selectByHost(host);
                if (room == null) {
                    log.error("未找到{}对应的房间信息", host);
                }else {
                    for (int i = 0; i < times; i++) {
                        HotelEvent event = new HotelEvent();
                        event.setHost(host);
                        event.setRoomEventType(RoomEventType.JiQiRenWenZi);
                        event.setReceiver(MessageActors.Staff.getCode());
                        event.setSender(MessageActors.Customer.getCode());
                        event.setEvent(MessageFormat.format(RoomEventType.JiQiRenWenZi.comment(), room.getRoomnum(), sentence));
                        EventCollection.addEvent(event);
                    }
                }
            }
        }
        if (roomEventValue.isVoiceval()) {
            Integer times = roomEventValue.getNumbertime();
            if (times != null) {
                RoomHotel room = roomHotelManager.selectByHost(host);
                if (room == null) {
                    log.error("未找到{}对应的房间信息", host);
                }else {
                    for (int i = 0; i < times; i++) {
                        HotelEvent event = new HotelEvent();
                        event.setHost(host);
                        event.setRoomEventType(RoomEventType.JiQiRenWenZi);
                        event.setReceiver(MessageActors.Staff.getCode());
                        event.setSender(MessageActors.Customer.getCode());
                        event.setEvent(MessageFormat.format(RoomEventType.JiQiRenWenZi.comment(), room.getRoomnum(), sentence));
                        EventCollection.addEvent(event);
                    }
                }
            }
        }

    }
}
