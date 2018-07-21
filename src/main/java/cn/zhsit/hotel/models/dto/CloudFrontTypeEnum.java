package cn.zhsit.hotel.models.dto;

/**
 * Created by Administrator on 2017/10/20.
 */
public enum CloudFrontTypeEnum {
    //云直接发给RCU
    CloudToRCU((byte) 1),
    //RCU直接发给云
    RCUToCloud((byte) 2),
    //云发给前台工作人员的语音，比如2302房间客户退房，(文字转语音，转换工作由前台系统完成)
    CloudToFrontDeskPerson((byte) 3),
    //云给前台推送RCU的Host和port
    CloudSendHostPortToFrontDesk((byte) 4),
    //前台端向云端请求获取RCU的Host和port
    FrontDeskRequestHostPort((byte) 5),
    //向前台端发送RCU软件更新信息
    CloudToFrontDeskRCUSoftUpdate((byte)6);


    private byte type;

    CloudFrontTypeEnum(byte type) {
        this.type = type;
    }

    public static CloudFrontTypeEnum of(byte type) {
        CloudFrontTypeEnum[] types = CloudFrontTypeEnum.values();
        for (CloudFrontTypeEnum typeEnum : types) {
            if (0 == (typeEnum.type - type)) {
                return typeEnum;
            }
        }
        return null;
    }

    public byte getType() {
        return type;
    }
}
