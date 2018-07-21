package cn.zhsit.hotel.managers.impl;

import cn.zhsit.authority.api.models.ConstantsAuthority;
import cn.zhsit.hotel.daos.RoomHotelMapper;
import cn.zhsit.hotel.managers.RoomHotelManager;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.models.po.RoomHotelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Component
public class RoomHotelManagerImpl implements RoomHotelManager {
    @Autowired
    private RoomHotelMapper roomHotelMapper;
//    ConstantsAuthority.CacheKey.RoomCacheName

    @Cacheable(value = ConstantsAuthority.CacheKey.RoomCacheName, key = "#roomId", unless = "#result == null")
    @Override
    public RoomHotel selectByKey(String roomId) {
        return roomHotelMapper.selectByPrimaryKey(roomId);
    }

    @Override
    @Cacheable(value = ConstantsAuthority.CacheKey.RoomCacheName, key = "#host", unless = "#result == null")
    public RoomHotel selectByHost(String host) {
        RoomHotelExample hotelExample = new RoomHotelExample();
        hotelExample.createCriteria().andRoomipEqualTo(host);
        List<RoomHotel> roomHotelList = roomHotelMapper.selectByExample(hotelExample);
        if (roomHotelList.size() > 0) {
            return roomHotelList.get(0);
        }
        return null;
    }
}
