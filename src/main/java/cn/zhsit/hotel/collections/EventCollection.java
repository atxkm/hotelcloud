package cn.zhsit.hotel.collections;

import cn.zhsit.hotel.models.dto.HotelEvent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/16.
 * 事件容器
 */
public class EventCollection {

    /**
     * 事件
     */
    private static final List<HotelEvent> eventStore = Collections.synchronizedList(new LinkedList<>());


    //事件容器最大值
    private static final int eventMaxSize = 100 * 100 * 10;

    /**
     * 读取事件列表
     */
    public synchronized static List<HotelEvent> readEvent() {
       return eventStore;
    }

    /**
     * 从缓存中移除事件
     *
     * @param event
     * @return
     */
    public static synchronized boolean removeEvent(HotelEvent event) {
        return eventStore.remove(event);
    }

    public static synchronized void addEvent(HotelEvent event) {
        int size = eventStore.size();
        if (size > eventMaxSize) {
            eventStore.remove(0);
        }
        eventStore.add(event);
    }


}
