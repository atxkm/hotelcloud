package cn.zhsit.hotel.managers;

import cn.zhsit.hotel.models.po.RoomHotel;

/**
 * Created by Administrator on 2017/11/6.
 */
public interface RoomHotelManager {

    RoomHotel selectByKey(String roomId);

    /**
     * 根据房间host（ip）查询房间信息，目前缓存十秒，
     *
     * @param host
     * @return
     */
    public RoomHotel selectByHost(String host);
}
