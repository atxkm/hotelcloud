package cn.zhsit.hotel.models.dto;

/**
 * Created by Administrator on 2017/10/19.
 * 云端发给的数据
 */
public class MsgSendToFrontDeskPerson {

    //数据
    private String dataString;

    public String getDataString() {
        return dataString;
    }

    public MsgSendToFrontDeskPerson setDataString(String dataString) {
        this.dataString = dataString;
        return this;
    }
}

