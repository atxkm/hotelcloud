package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/10/23.
 * RCU地址枚举类
 */
public enum RCUAddressEnum {
    //重启方式
    ChongQiFangshi(0),
    //RCU主程序版本号	更新时根据这个版本号来更新，如果新程序低于这个版本号则停止更新，RCU不管这个参数
    RCUZhuChengXuBanBenHao(1),
    //    2	通信协议版本号	为了让上位机或服务器知道用具体哪种协议来通信
    TongXinXieYiBanBenHao(2),
    //RCU剩余使用时间1
    RCUShengYuShiYongShiJian9(9),
    //RCU剩余使用时间2
    RCUShengYuShiYongShiJian10(10),

    //40	年(后两位）	由配置程序同步,上位机下发
    Nian(40),
    //41	月	同上
    Yue(41),
    //42	日	同上
    Ri(42),
    //43	小时	同上
    XiaoShi(43),
    //44	分钟	同上
    FenZhong(44),
    //45	秒	同上
    Miao(45),
    //客房入住信息
    KeFangRuZhuXinXi(51),
    //插卡取电	蓝色	8010房间插卡取电。	55
    ChaKaQuDian(55),
    //房门状态	红色	8010房间房门异常打开	57(如果为异常期间，我多次轮询，都会返给2)
    FangMenZhuangTai(57),
    //消防警告	红色	8010房间消防警告	60  （若没取消警告，会一直返给警告）
    XiaoFangJingGao(60),
    //入侵警告	红色	8010房间入侵警告	61
    RuQinJingGao(61),
    //勿扰模式	绿色	8010房间打开勿扰模式。	65
    WuRaoMoShi(65),
    //紧急模式	红色	8010房间紧急呼叫。	66
    JinJiMoShi(66),
    //稍后模式	绿色	8010房间打开稍后模式。	67
    ShaoHouMoShi(67),
    //退房服务	蓝色	8010房间呼叫退房服务。	68
    TuiFangMoShi(68),
    //清理服务	蓝色	8010房间呼叫清理服务。	69
    QingLiFuWu(69),
    //维修服务	黄色	8010房间呼叫维修服务。	70
    WeiXiuFuWu(70),
    //语音服务	蓝色	8010房间呼叫语音服务。	71
    YuYinFuWu(71),
    //视频服务	蓝色	8010房间呼叫视频服务。	72
    ShiPinFuWu(72),
    //呼叫服务	蓝色	8010房间要求呼叫服务。	73
    HuJiaoFuWu(73),
    //洗衣服务	蓝色	8010房间呼叫洗衣服务。	74
    XiYiFuWu(74),
    //叫餐服务	蓝色	8010房间呼叫叫餐服务。	75
    JiaoCanFuWu(75),
    //叫车服务	蓝色	8010房间呼叫叫车服务。	76
    JiaoCheFuWu(76),
    //79	实际温度1	数值
    ShiJiWenDu79(79),

    /**
     * 80	设定温度1	数值
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    SheDingWenDu1(80),
    /**
     * 81	开关状态1	0为关，1为开
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    KaiGuanZhuangTai1(81),
    /**
     * 82	风速状态1	0为关，1为低，2为中，3为高
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    FengSuZhuangTai1(82),
    /**
     * 83	模式状态1	0为制热，1为制冷，2为纯风
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    MoShiZhuangTai1(83),
    /**
     * 84	锁定状态1	0为无锁定，1为锁定
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    SuoDingZhuangTai1(84),
    /**
     * 85	上下风向1	0为关，1为开
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    ShangXiaFengXiang1(85),
    /**
     * 86	左右扫风1	0为关，1为开
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    ZuoYouSaoFeng1(86),
    /**
     * 87	修正值1	数值
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    XiuZhengZhi1(87),
    /**
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    //96	实际温度2数值
    ShiJiWenDu2(96),
    /**
     * 97	设定温度2	数值
     * 空调2的：97至111之间只要有下发，就得下112的1
     */
    SheDingWenDu2(97),



    /**
     * 81	开关状态1	0为关，1为开
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    KaiGuanZhuangTai2(98),
    /**
     * 82	风速状态1	0为关，1为低，2为中，3为高
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    FengSuZhuangTai2(99),
    /**
     * 83	模式状态1	0为制热，1为制冷，2为纯风
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    MoShiZhuangTai2(100),
    /**
     * 84	锁定状态1	0为无锁定，1为锁定
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    SuoDingZhuangTai2(101),
    /**
     * 85	上下风向1	0为关，1为开
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    ShangXiaFengXiang2(102),
    /**
     * 86	左右扫风1	0为关，1为开
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    ZuoYouSaoFeng2(103),
    /**
     * 87	修正值1	数值
     * 空调1的：80至94之间只要有下发，就得下95的1
     */
    XiuZhengZhi2(104),



    /**
     * 空调3的：114至128之间只要有下发，就得下129的1
     */

    //灯光1
    DengGuang130(130),
    //灯光2
    DengGuang131(131),
    //灯光3
    DengGuang132(132),
    //灯光4
    DengGuang133(133),
    //灯光5
    DengGuang134(134),
    //灯光6
    DengGuang135(135),
    //灯光7
    DengGuang136(136),
    //灯光8
    DengGuang137(137),
    //灯光9
    DengGuang138(138),
    //灯光10
    DengGuang139(139),
    //灯光11
    DengGuang140(140),
    //灯光12
    DengGuang141(141),
    //灯光13
    DengGuang142(142),
    //灯光14
    DengGuang143(143),
    //灯光15
    DengGuang144(144),
    //灯光16
    DengGuang145(145),
    //灯光17
    DengGuang146(146),
    //灯光18
    DengGuang147(147),



    /**
     * 窗帘1的：177只要有下发，就得下179的1
     */

    /**
     * 窗帘2的：187只要有下发，就得下189的1
     */

    /**
     * 窗帘3：  183只要有下发，就得下185的1
     */

    /**
     * 窗帘4：  186只要有下发，就得下188的1
     */

    //机器人通信	黄色	8010房间机器人通信故障。	216
    JiQiRenTongXin(216),
    //机器人联网	黄色	8010房间机器人联网故障。	217
    JiQiRenLianWang(217),
    //机器人电量	黄色	8010房间机器人电量为5%。	218
    JiQiRenDianLiang(218),
    //机器人故障	黄色	8010房间机器人故障。	219
    JiQiRenGuZhang(219),
    //机器人文字	蓝色	8010房间发送信息：*****	220
    JiQiRenWenZi(220),;

    /**
     * RCU地址
     */
    private int address;

    RCUAddressEnum(int address) {
        this.address = address;
    }

    public static RCUAddressEnum of(int address) {
        RCUAddressEnum[] addressArray = RCUAddressEnum.values();
        for (RCUAddressEnum addressEnum : addressArray) {
            if ((addressEnum.address - address) == 0) {
                return addressEnum;
            }
        }
        return null;
    }

    public int getAddress() {
        return address;
    }
}
