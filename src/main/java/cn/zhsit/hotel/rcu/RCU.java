package cn.zhsit.hotel.rcu;

import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.hotel.collections.FromFrontDeskCollection;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/22.
 * RCU信息,不含机器人文字(地址220){@link XiaoQiao#sentence}
 */
public class RCU {
    /**
     * RCU 的ip地址
     */
    private String host;
    /**
     * RCU的端口
     */
    private Integer port;
    /**
     * <RCU的地址address,此地址的状态status>
     * 地址address {@link cn.zhsit.common.enums.RCUAddressEnum#address}
     * 68 退房申请，轮询后，状态不变。住户通过按钮发出退房请求，住户可以取消，重按，上位机进行受理修改为2
     * 另外退房得考虑客户是否更换过。，入住新一轮客户，下发初始化房间初始化指令集合
     */
    private Map<Integer, Integer> addressStatus = new HashMap<>();
//    /**
//     * rcu剩余使用时间(小时)
//     */
//    private int RCUShengYuShiYongShiJian;
    /**
     * 最后更新时间(与 System.currentTimeMillis()一致)
     */
    private long lastTime;

    public String getHost() {
        return host;
    }

    public RCU setHost(String host) {
        this.host = host;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public RCU setPort(Integer port) {
        this.port = port;
        return this;
    }

    public Map<Integer, Integer> getAddressStatus() {
        return addressStatus;
    }

    public RCU setAddressStatus(Map<Integer, Integer> addressStatus) {
        this.addressStatus = addressStatus;
        return this;
    }


    public Map<Integer, Integer> addAddressStatus(Integer address, Integer status){
        //TODO 添加事件判断，将事件放到对应的队列中，有线程扫描队列，完成队列入库等操作
        //例如 68退房服务
//        FromFrontDeskCollection.addEvent(null);
        addressStatus.put(address, status);
        return addressStatus;
    }

    public Integer getAddressStatus(Integer address) {
        return addressStatus.get(address);
    }

    /**
     * 根据地址枚举获取地址对应的数据
     * @param address
     * @return
     */
    public Integer getAddressStatus(RCUAddressEnum address) {
        return addressStatus.get(address.getAddress());
    }

    public long getLastTime() {
        return lastTime;
    }

    public RCU setLastTime(long lastTime) {
        this.lastTime = lastTime;
        return this;
    }

//    /**
//     * rcu剩余使用时间(小时)
//     * @return
//     */
//    public int getRCUShengYuShiYongShiJian() {
//        throw new RuntimeException("尚未从addressStatus中提取剩余使用时间");
//    }

//    public RCU setRCUShengYuShiYongShiJian(int RCUShengYuShiYongShiJian) {
//        this.RCUShengYuShiYongShiJian = RCUShengYuShiYongShiJian;
//        return this;
//    }
}
