package cn.zhsit.hotel.collections;

import cn.zhsit.hotel.models.dto.HotelEvent;
import cn.zhsit.hotel.rcu.RCU;
import cn.zhsit.hotel.rcu.XiaoQiao;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/10/19.
 */
public class FromFrontDeskCollection {
    /**
     * HashMap<RCU.host, RCU>
     */
    private static final ConcurrentHashMap<String, RCU> rcuStore = new ConcurrentHashMap<>();
//    /**
//     * 机器人<host,机器人文字>
//     */
//    private static final ConcurrentHashMap<String, List<XiaoQiao>> xiaoQiaoStore = new ConcurrentHashMap<>();
//    /**
//     * 事件
//     */
//    private static final List<HotelEvent> eventStore = Collections.synchronizedList(new LinkedList<>());

    //超时时间(毫秒)
    private static final int timeOutMillSeconds = 1000 * 60 * 5;
    //每个host存放机器人小乔信息的最大数
    private static final int xiaoQiaoMaxSize = 1000;
    //事件容器最大值
    private static final int eventMaxSize=10000;

    /**
     * 获取全部RCU信息(超时没有返回的除外)。超时时间参考 {@link #timeOutMillSeconds}
     *
     * @return
     */
    public static ConcurrentHashMap<String, RCU> getAllRCU() {
        rcuStore.forEach((host, rcu) -> {
            if (System.currentTimeMillis() - rcu.getLastTime() > timeOutMillSeconds) {
                rcuStore.remove(host);
            }
        });
        return rcuStore;
    }

    /**
     * 根据RCU的ip获取RCU信息
     *
     * @param host
     * @return
     */
    public static RCU getByHost(String host) {
        RCU rcu = rcuStore.get(host);
        if (rcu != null) {
            if (System.currentTimeMillis() - rcu.getLastTime() > timeOutMillSeconds) {
                rcuStore.remove(host);
                return null;
            }
        }
        return rcu;
    }

    /**
     * 更新RCU的信息
     *
     * @param rcu
     */
    public static void update(RCU rcu) {
        rcuStore.put(rcu.getHost(), rcu);
    }

//    //添加机器人小乔信息
//    public static synchronized void addXiaoQiaoInfo(XiaoQiao xiaoQiao) {
//        List<XiaoQiao> list = xiaoQiaoStore.get(xiaoQiao.getHost());
//        if (list == null) {
//            list = new LinkedList<>();
//            xiaoQiaoStore.put(xiaoQiao.getHost(), list);
//        }
//        if (xiaoQiaoStore.size() > xiaoQiaoMaxSize) {
//            xiaoQiaoStore.remove(0);
//        }
//        list.add(xiaoQiao);
//    }

//    //添加机器人小乔信息
//    public static void addXiaoQiaoInfo(List<XiaoQiao> xiaoQiaoList) {
//        xiaoQiaoList.forEach(xiaoQiao -> {
//            addXiaoQiaoInfo(xiaoQiao);
//        });
//    }

//    /**
//     * 只读（进行copy list,不copy机器人小乔对象）所有的机器人的所有信息
//     *
//     * @return Map<host, List<XiaoQiao>>
//     */
//    public static Map<String, List<XiaoQiao>> readAllXiaoQiao() {
//        Map<String, List<XiaoQiao>> all = new HashMap<>();
//        xiaoQiaoStore.forEach((host, xiaoQiaoList) -> {
//            List<XiaoQiao> copyList = new ArrayList<XiaoQiao>();
//            ArrayUtils.clone(xiaoQiaoList.toArray());
//            all.put(host, copyList);
//        });
//        return all;
//    }

//    /**
//     * 根据RCU的host只读（进行copy list,不copy小乔对象）机器人的信息
//     *
//     * @return
//     */
//    public static List<XiaoQiao> readXiaoQiao(String host) {
//        List<XiaoQiao> listInStore = xiaoQiaoStore.get(host);
//        if (listInStore == null || listInStore.size() < 1) {
//            return null;
//        }
//        List<XiaoQiao> copyList = new ArrayList<>();
//        listInStore.forEach(xiaoQiao -> {
//            copyList.add(xiaoQiao);
//        });
//        return copyList;
//    }
//
//    /**
//     * 删除式读（删除历史的机器人小乔对象）所有的机器人的所有信息
//     *
//     * @return
//     */
//    public static Map<String, List<XiaoQiao>> removeAllXiaoQiao() {
//        Map<String, List<XiaoQiao>> all = new HashMap<>();
//        xiaoQiaoStore.forEach((host, xiaoQiaoList) -> {
//            List<XiaoQiao> copyList = new ArrayList<XiaoQiao>();
//            for (int i = xiaoQiaoList.size() - 1; i >= 0; i--) {
//                try {
//                    copyList.add(xiaoQiaoList.remove(i));
//                } catch (IndexOutOfBoundsException outBound) {
//                }
//            }
//            all.put(host, copyList);
//        });
//        return all;
//    }
//
//    /**
//     *根据RCU的host删除时读机器人小乔信息对象列表
//     * @param host
//     * @return
//     */
//    public List<XiaoQiao> removeXiaoQiao(String host) {
//        List<XiaoQiao> listInStore = xiaoQiaoStore.get(host);
//        if (null == listInStore || listInStore.size() < 1) {
//            return null;
//        }
//        List<XiaoQiao> copyList = new ArrayList<>();
//        for (int i = listInStore.size() - 1; i >= 0; i--) {
//            try {
//                XiaoQiao xiaoQiao = listInStore.remove(i);
//                copyList.add(xiaoQiao);
//            } catch (IndexOutOfBoundsException outOfBound) {
//            }
//        }
//        return copyList;
//    }
//
//    public static synchronized void addEvent(HotelEvent event) {
//        int size=eventStore.size();
//        if (size > eventMaxSize) {
//            eventStore.remove(0);
//        }
//        eventStore.add(event);
//    }
}
