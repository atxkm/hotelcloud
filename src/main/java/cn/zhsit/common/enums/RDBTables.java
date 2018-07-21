package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/11/7.
 */
public enum RDBTables {
    /**
     * 消息表
     */
    Message("t_message");

    private String tableName;

    RDBTables(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
