package cn.zhsit.hotel.models.dto;

import cn.zhsit.common.enums.RDBOperate;
import cn.zhsit.common.enums.RDBTables;

/**
 * Created by Administrator on 2017/11/7.
 */
public class MsgToRDB {
    private RDBOperate operate;
//    private RDBTables table;
//    /**
//     * id
//     */
//    private String id;
    private Object po;

    public RDBOperate getOperate() {
        return operate;
    }

    public MsgToRDB setOperate(RDBOperate operate) {
        this.operate = operate;
        return this;
    }

//    public RDBTables getTable() {
//        return table;
//    }
//
//    public MsgToRDB setTable(RDBTables table) {
//        this.table = table;
//        return this;
//    }

//    public String getId() {
//        return id;
//    }
//
//    public MsgToRDB setId(String id) {
//        this.id = id;
//        return this;
//    }

    public Object getPo() {
        return po;
    }

    public MsgToRDB setPo(Object po) {
        this.po = po;
        return this;
    }
}
