package cn.zhsit.hotel.models.dto;

import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.enums.RCUOrderEnum;

/**
 * Created by Administrator on 2017/10/19.
 * 云端发给RCU的数据
 */
public class MsgSendToRCU {
    //ip
    private String hostname;
    //端口
    private int port;
    /**
     * RCU指令 {@link cn.zhsit.common.enums.RCUOrderEnum}
     */
//    private int order;
    private RCUOrderEnum order;
    /**
     * RCU地址{@link cn.zhsit.common.enums.RCUAddressEnum}
     */
//    private int address;
    private RCUAddressEnum address;
    //数据（需要根据网络协议文档（网洛协议0707-2.docx）附表1  地址和数据具体含义的说明部分填写，除了机器人文字，其它全部是一个字节的数字）
    private String dataString;

    public String getHostname() {
        return hostname;
    }

    public MsgSendToRCU setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    public int getPort() {
        return port;
    }

    public MsgSendToRCU setPort(int port) {
        this.port = port;
        return this;
    }

    public RCUOrderEnum getOrder() {
        return order;
    }

    public MsgSendToRCU setOrder(RCUOrderEnum order) {
        this.order = order;
        return this;
    }

    public RCUAddressEnum getAddress() {
        return address;
    }

    public MsgSendToRCU setAddress(RCUAddressEnum address) {
        this.address = address;
        return this;
    }

    public String getDataString() {
        return dataString;
    }

    public MsgSendToRCU setDataString(String dataString) {
        this.dataString = dataString;
        return this;
    }


    @Override
    public String toString() {
        return "MsgSendToRCU{" +
                "hostname='" + hostname + '\'' +
                ", port=" + port +
                ", order=" + order +
                ", address=" + address +
                ", dataString='" + dataString + '\'' +
                '}';
    }
}

