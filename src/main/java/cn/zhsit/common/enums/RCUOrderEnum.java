package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/10/21.
 * RCU指令枚举类
 */
public enum RCUOrderEnum {
    //PC读RCU寄存器
    PCReadRCU(0x01),
    //PC写RCU寄存器
    PCWriteRCU(0x02),
    //写特殊寄存器	数据前四位是密钥（暂定不要）特殊寄存器（地址40以前）
    WriteTeShuJiCunQi(0x3),
    //RCU复位	RCU立即复位
    RCUFuWei(0x4),
    //下载配置	下载配置表
    XiaZaiPeiZhi(0x5),
    //更新bin	下载bin文件
    GengXinBin(0x6),
    //hash校验		下载32位hash (暂时不用)
    HashJiaoYan(0x7),
    //上传文字
    ShangChuanWenZi(0x08),
    //下传文字
    XiaChuanWenZi(0x09),
    //控制机器人指令	向机器人发送的设备控制命令
    KongZhiJiQiRenZhiLing(0x0A),
    //询问机器人指令	向机器人发送的询问命令
    XunWenJiQiRenZhiLing(0x0B),
    //机器人读寄存器	读寄存器数据
    JiQiRenDuJiCunQi(0xC),
    //机器人写寄存器	写寄存器数据
    JiQiRenXieJiCunQi(0xD),
    //RCU上传PC 	RCU有操作后将数据上传PC
    RCUShangChuanPC(0x0E),
    //返回成功	当前操作成功
    FanHuiChengGong(0xFF);

    private int order;

    RCUOrderEnum(int order) {
        this.order = order;
    }

    public static RCUOrderEnum of(int order) {
        RCUOrderEnum[] enums=RCUOrderEnum.values();
        for (RCUOrderEnum en : enums) {
            if(0==(en.order-order)){
                return en;
            }
        }
        return null;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "RCUOrderEnum{" +
                "order=" + order +
                '}';
    }

}
