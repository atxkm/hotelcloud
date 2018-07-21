package cn.zhsit.hotel.collections;

import cn.zhsit.hotel.models.dto.MsgSendToFrontDeskPerson;
import cn.zhsit.hotel.models.dto.MsgSendToRCU;
import cn.zhsit.hotel.models.dto.MsgSoftUpdate;
import java.util.*;

/**
 * Created by Administrator on 2017/10/19.
 */
public class ToFrontDeskCollection {
    //存储发送给RCU的消息
    private static final List<MsgSendToRCU> storeToRCU = Collections.synchronizedList(new LinkedList());
    //存储发送给前台人员的消息
    private static final List<MsgSendToFrontDeskPerson> storeToFrontDeskPerson = Collections.synchronizedList(new LinkedList());
    //存储发送诶前台的RCU软件更新消息
    private static final List<MsgSoftUpdate> storeSoftUpdate = Collections.synchronizedList(new LinkedList());
    //给RCU的指令最多装20万
    private static final int rcuMaxSize = 100 * 100 * 20;
    //给前台的消息条数最多1万
    private static final int personMaxSize = 10000;
    //发送给前台的RCU软件更新消息最大值
    private static final int softUpdateMaxSize = 100;

    /**
     * 存放发送给RCU的消息
     * demo {cn.zhsit.tasks.MockDataSendToFrontDeskTest#mockToRCuData}
     */

    public static boolean putToRCU(MsgSendToRCU msg) {
        if (storeToRCU.size() > rcuMaxSize) {
            storeToRCU.remove(0);
        }
        return storeToRCU.add(msg);
    }

    //存放发送给RCU的消息
    public static boolean putToRCU(Collection<MsgSendToRCU> msgList) {
        for (MsgSendToRCU msg : msgList) {
            putToRCU(msg);
        }
        return true;
    }

    public static boolean removeToRCU(Collection<MsgSendToRCU> msgs) {
        return storeToRCU.removeAll(msgs);
    }

    public static boolean removeToRCU(MsgSendToRCU msg) {
        return storeToRCU.remove(msg);
    }

    /**
     * 查找发送给RCU的消息
     *
     * @param num
     * @return
     */
    public static List<MsgSendToRCU> findToRCU(int num) {
        List<MsgSendToRCU> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            try {
                MsgSendToRCU msg = storeToRCU.get(i);
                list.add(msg);
            } catch (IndexOutOfBoundsException indexOut) {
                break;
            }
        }
        return list;
    }

    /**
     * 存放发送给前台人员的消息
     * demo {cn.zhsit.tasks.MockDataSendToFrontDeskTest#mockToFrontDeskPerson}
     */
    public static boolean putToFrontDeskPerson(MsgSendToFrontDeskPerson msg) {
        if (storeToFrontDeskPerson.size() > personMaxSize) {
            storeToFrontDeskPerson.remove(0);
        }
        return storeToFrontDeskPerson.add(msg);
    }

    public static boolean putToFrontDeskPerson(Collection<MsgSendToFrontDeskPerson> msgList) {
        for (MsgSendToFrontDeskPerson msg : msgList) {
            putToFrontDeskPerson(msg);
        }
        return true;
    }

    public static boolean removeToFrontDeskPerson(Collection<MsgSendToFrontDeskPerson> msgs) {
        return storeToFrontDeskPerson.removeAll(msgs);
    }

    public static boolean removeToFrontDeskPerson(MsgSendToFrontDeskPerson msg) {
        return storeToFrontDeskPerson.remove(msg);
    }

    /**
     * 查找发送给前台人员的消息
     *
     * @param num
     * @return
     */
    public static List<MsgSendToFrontDeskPerson> findToFrontDeskPerson(int num) {
        List<MsgSendToFrontDeskPerson> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            try {
                MsgSendToFrontDeskPerson msg = storeToFrontDeskPerson.get(i);
                list.add(msg);
            } catch (IndexOutOfBoundsException indexOut) {
                break;
            }
        }
        return list;
    }

    /**
     * 存放发送给前台端的 RCU软件更新消息
     * @param msg
     * @return
     */
    public static boolean putSoftUpdate(MsgSoftUpdate msg) {
        if (storeSoftUpdate.size() > softUpdateMaxSize) {
            storeSoftUpdate.remove(0);
        }
        return storeSoftUpdate.add(msg);
    }

    /**
     * 查找软件更新信息列表
     * @param num
     * @return
     */
    public static List<MsgSoftUpdate> findSoftUpdate(int num) {
        List<MsgSoftUpdate> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            try {
                MsgSoftUpdate msg = storeSoftUpdate.get(i);
                list.add(msg);
            } catch (IndexOutOfBoundsException indexOut) {
                break;
            }
        }
        return list;
    }

    public static boolean removeSoftUpdate(Collection<MsgSoftUpdate> msgs) {
        return storeSoftUpdate.removeAll(msgs);
    }

    public static boolean removeSoftUpdate(MsgSoftUpdate msg) {
        return storeSoftUpdate.remove(msg);
    }
}
