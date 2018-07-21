package cn.zhsit.hotel.commands;

import cn.zhsit.common.constants.ZhsConstants;
import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.enums.RCUOrderEnum;
import cn.zhsit.hotel.collections.FromFrontDeskCollection;
import cn.zhsit.hotel.collections.ToFrontDeskCollection;
import cn.zhsit.hotel.models.dto.MsgSendToRCU;
import cn.zhsit.hotel.models.dto.MsgSoftUpdate;
import cn.zhsit.hotel.rcu.RCU;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */
public class RoomCommands {

    /**
     * 登记住户（住户新入住）时，清除旧住户的服务请求
     * 指令68-76 退房服务等清除
     *
     * @param hostname 房间对应的RUC的ip地址
     * @return
     */
    public static boolean cleanGuestRequest(String hostname) {
        List<MsgSendToRCU> msgList = new ArrayList<>();
        for (int orderNum = 68; orderNum <= 76; orderNum++) {
            MsgSendToRCU msg = new MsgSendToRCU();
            msgList.add(msg);
            msg.setHostname(hostname);
            // 房间对应的RUC的端口号
            msg.setPort(ZhsConstants.RCUPort);
            msg.setAddress(RCUAddressEnum.of(orderNum));
            msg.setOrder(RCUOrderEnum.PCWriteRCU);
            msg.setDataString("0"); //0为关，1为开，2为已受理
        }
        return ToFrontDeskCollection.putToRCU(msgList);
    }

    /**
     * RCU复位
     *
     * @param hostname
     * @return true, 指令已经发出（不代表成功执行）；
     */
    public static boolean rcuRestoration(String hostname) {
        MsgSendToRCU msg = new MsgSendToRCU();
        msg.setHostname(hostname);
        msg.setPort(ZhsConstants.RCUPort);
        msg.setOrder(RCUOrderEnum.RCUFuWei);
        msg.setAddress(RCUAddressEnum.ChongQiFangshi);
        msg.setDataString("1");
        return ToFrontDeskCollection.putToRCU(msg);
    }

    /**
     * RCU软件升级
     *
     * @param filePathName 升级的bin文件相对路径（从启动目录下的zhsstore开始算起)+文件名称（含后缀)
     * @param hostnameList RUC的hostname地址列表
     * @param version      此次的升级文件版本（从前端录入的小于256的整数）
     * @return true, 指令已经发出(不代表成功执行);
     */
    public static boolean rcuSoftUpdate(String filePathName, List<String> hostnameList, int version) {
        MsgSoftUpdate msg = new MsgSoftUpdate();
        msg.setFilePathName(filePathName);
        msg.setHosts(hostnameList);
        msg.setVersion(version);
        //升级的端口号（不同于普通指令端口号）
        msg.setPort(ZhsConstants.softUpdatePort);
        return ToFrontDeskCollection.putSoftUpdate(msg);
    }

    /**
     * 设置RCU的时间 ,当不设置dateTime时，获取计算机的当前时间
     *
     * @param hostnameList RCU 的hostname列表
     * @param dateTime     yyyy-MM-dd HH:mm:ss,当为空时，获取系统的当前时间
     * @return
     * @throws ParseException
     */
    public static boolean setRCUDateTime(List<String> hostnameList, String dateTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        ;
        if (StringUtils.isBlank(dateTime)) {
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dateTime);
            calendar.setTime(date);
        }
        int year = calendar.get(Calendar.YEAR);
        int yearLast2 = year - 2000;
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        List<MsgSendToRCU> msgList = new ArrayList<>();
        for (String hostname : hostnameList) {
            {
                MsgSendToRCU nian = new MsgSendToRCU();
                msgList.add(nian);
                nian.setHostname(hostname);
                nian.setPort(ZhsConstants.RCUPort);
                nian.setAddress(RCUAddressEnum.Nian);
                nian.setOrder(RCUOrderEnum.PCWriteRCU);
                nian.setDataString(yearLast2 + "");
            }
            {
                MsgSendToRCU yue = new MsgSendToRCU();
                msgList.add(yue);
                yue.setHostname(hostname);
                yue.setPort(ZhsConstants.RCUPort);
                yue.setAddress(RCUAddressEnum.Yue);
                yue.setOrder(RCUOrderEnum.PCWriteRCU);
                yue.setDataString(month + "");
            }
            {
                MsgSendToRCU ri = new MsgSendToRCU();
                msgList.add(ri);
                ri.setHostname(hostname);
                ri.setPort(ZhsConstants.RCUPort);
                ri.setAddress(RCUAddressEnum.Ri);
                ri.setOrder(RCUOrderEnum.PCWriteRCU);
                ri.setDataString(day + "");
            }
            {
                MsgSendToRCU shi = new MsgSendToRCU();
                msgList.add(shi);
                shi.setHostname(hostname);
                shi.setPort(ZhsConstants.RCUPort);
                shi.setAddress(RCUAddressEnum.XiaoShi);
                shi.setOrder(RCUOrderEnum.PCWriteRCU);
                shi.setDataString(hour + "");
            }
            {
                MsgSendToRCU fen = new MsgSendToRCU();
                msgList.add(fen);
                fen.setHostname(hostname);
                fen.setPort(ZhsConstants.RCUPort);
                fen.setAddress(RCUAddressEnum.FenZhong);
                fen.setOrder(RCUOrderEnum.PCWriteRCU);
                fen.setDataString(minute + "");
            }
            {
                MsgSendToRCU miao = new MsgSendToRCU();
                msgList.add(miao);
                miao.setHostname(hostname);
                miao.setPort(ZhsConstants.RCUPort);
                miao.setAddress(RCUAddressEnum.Miao);
                miao.setOrder(RCUOrderEnum.PCWriteRCU);
                miao.setDataString(second + "");
            }
        }
        return ToFrontDeskCollection.putToRCU(msgList);
    }

    /**
     * 获取rcu剩余使用时间(小时)
     *
     * @param hostname
     * @return 剩余小时数
     */
    public static Integer getShengYuShiJian(String hostname) {
        RCU rcu = FromFrontDeskCollection.getByHost(hostname);
        if (rcu == null) {
            return Integer.MAX_VALUE;
        }
        Integer shengYuShiJian9 = rcu.getAddressStatus(RCUAddressEnum.RCUShengYuShiYongShiJian9);
        Integer shengYuShiJian10 = rcu.getAddressStatus(RCUAddressEnum.RCUShengYuShiYongShiJian10);
        if (shengYuShiJian9 == null) {
            shengYuShiJian9=0;
        }
        if(shengYuShiJian10==null){
            shengYuShiJian10=0;
        }
        int shengYu9 = shengYuShiJian9 << 8;
        int zongShiJian = shengYuShiJian10 + shengYu9;
        if ((zongShiJian & 0xFFFF) == 0xFFFF) {
            return Integer.MAX_VALUE;
        }
        return shengYuShiJian10 + shengYu9;
    }

    /**
     * 设置RCU剩余使用时间
     *
     * @param hostname
     * @param hours (小时)   剩余时间，当hours大于65535时，设置为永久可用
     * @return
     */
    public static boolean setShengYuShiJian(String hostname, int hours) {
        List<MsgSendToRCU> msgList = new ArrayList<>();
        if (hours > 65535) {
            {
                MsgSendToRCU shi9 = new MsgSendToRCU();
                msgList.add(shi9);
                shi9.setHostname(hostname);
                shi9.setPort(ZhsConstants.RCUPort);
                shi9.setAddress(RCUAddressEnum.RCUShengYuShiYongShiJian9);
                shi9.setDataString(0xFF + "");
            }
            {
                MsgSendToRCU shi10 = new MsgSendToRCU();
                msgList.add(shi10);
                shi10.setHostname(hostname);
                shi10.setPort(ZhsConstants.RCUPort);
                shi10.setAddress(RCUAddressEnum.RCUShengYuShiYongShiJian10);
                shi10.setDataString(0xFF + "");
            }
        } else {
            int shiJian9 = hours & 0xFF00;
            int shiJian10 = hours & 0xFF;
            {
                MsgSendToRCU shi9 = new MsgSendToRCU();
                msgList.add(shi9);
                shi9.setHostname(hostname);
                shi9.setPort(ZhsConstants.RCUPort);
                shi9.setAddress(RCUAddressEnum.RCUShengYuShiYongShiJian9);
                shi9.setDataString(shiJian9 + "");
            }
            {
                MsgSendToRCU shi10 = new MsgSendToRCU();
                msgList.add(shi10);
                shi10.setHostname(hostname);
                shi10.setPort(ZhsConstants.RCUPort);
                shi10.setAddress(RCUAddressEnum.RCUShengYuShiYongShiJian10);
                shi10.setDataString(shiJian10 + "");
            }
        }
        return ToFrontDeskCollection.putToRCU(msgList);
    }

}
