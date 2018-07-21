package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/10/27.
 * 房间事件类型
 */
public enum RoomEventType {
    RCUShiYongShengYuShiJian(9, "RCU使用剩余时间", "{0}房间RCU使用剩余使用时间{1}小时。"),
    RCULianWangZhongDuan(2, "RCU联网中断", "{0}房间RCU联网中断。"),
    KeFangRuZhu(51, "客房入住", "{0}房间{1}。"),
    ChaKaQuDian(55, "插卡取电", "{0}房间插卡取电。"),
    FangMenZhuangTai(57, "房门异常打开", "{0}房间房门异常打开。"),
    XiaoFangJingGao(60, "消防警告", "{0}房间消防警告。"),
    RuQinJingGao(61, "入侵警告", "{0}房间入侵警告。"),
    WuRaoMoShi(65, "勿扰模式", "{0}房间打开勿扰模式。"),
    JinJiMoShi(66, "紧急模式", "{0}房间紧急呼叫。"),
    ShaoHouMoShi(67, "稍后模式", "{0}房间打开稍后模式。"),
    TuiFangFuWu(68, "退房服务", "{0}房间呼叫退房服务。"),
    QingLiFuWu(69, "清理服务", "{0}房间呼叫清理服务。"),
    WeiXiuFuWu(70, "维修服务", "{0}房间呼叫维修服务。"),
    YuYinFuWu(71, "语音服务", "{0}房间呼叫语音服务。"),
    ShiPinFuWu(72, "视频服务", "{0}房间呼叫视频服务。"),
    HuJiaoFuWu(73, "呼叫服务", "{0}房间要求呼叫服务。"),
    XiYiFuWu(74, "洗衣服务", "{0}房间呼叫洗衣服务。"),
    JiaoCanFuWu(75, "叫餐服务", "{0}房间呼叫叫餐服务。"),
    JiaoCheFuWu(76, "叫车服务", "{0}房间呼叫叫车服务。"),
    JiQiRenTongXin(216, "机器人通信", "{0}房间机器人通信故障。"),
    JiQiRenLianWang(217, "机器人联网", "{0}房间机器人联网故障。"),
    JiQiRenDianLiang(218, "机器人电量", "{0}房间机器人电量为{1}。"),
    JiQiRenGuZhang(219, "机器人故障", "{0}房间机器人故障。"),
    JiQiRenWenZi(220, "机器人文字", "{0}房间发送信息:{1}"),;
    /**
     * 房间事件编号
     */
    private int code;

    /**
     * 房间事件名称定义
     */
    private String codeName;
    /**
     * 说明文字
     */
    private String comment;

    private RoomEventType(int code, String codeName, String comment) {
        this.code = code;
        this.codeName = codeName;
        this.comment = comment;
    }


    public static RoomEventType of(int code) {
        RoomEventType[] types = RoomEventType.values();
        for (RoomEventType type : types) {
            if ((type.code - code) == 0) {
                return type;
            }
        }
        return null;
    }

    public int code() {
        return code;
    }

    public String codeName() {
        return codeName;
    }

    public String comment() {
        return comment;
    }

//    public static void main(String[] args) {
//        String str= MessageFormat.format(RoomEventType.RCUShiYongShengYuShiJian.comment(),"8010","20");
//        System.out.println(str);
//    }

}
