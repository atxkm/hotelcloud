package cn.zhsit.hotel.collections;

import cn.zhsit.hotel.models.dto.MsgSendToRCU;
import cn.zhsit.hotel.models.dto.MsgToRDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
public class ToRDBCollection {

    private static final List<MsgToRDB> storeToRDB = Collections.synchronizedList(new LinkedList());
    //给RCU的指令最多装20万
    private static final int rdbMaxSize = 100 * 100 * 20;

    public static boolean putToRDB(MsgToRDB msg) {
        if (storeToRDB.size() > rdbMaxSize) {
            storeToRDB.remove(0);
        }
        return storeToRDB.add(msg);
    }




    public static List<MsgToRDB> findToRDB(int num) {
        List<MsgToRDB> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            try {
                MsgToRDB msg = storeToRDB.get(i);
                list.add(msg);
            } catch (IndexOutOfBoundsException indexOut) {
                break;
            }
        }
        return list;
    }

    public static void remove(MsgToRDB msgToRDB) {
        storeToRDB.remove(msgToRDB);
    }

    public static void remove(List<MsgToRDB> msgToRDBs) {
        storeToRDB.removeAll(msgToRDBs);
    }
}
