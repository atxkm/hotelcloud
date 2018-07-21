package cn.zhsit.common.enums;

/**
 * Created by Darren on 2017/7/14.
 */
public enum RoleEnum {
    //    人员类型:1超级权限人员;2管理员;3一般人员;4楼层管理人员;5房间人员
    Super("super", "超级权限人员","可以具有软件的全部权限，包括复位RCU、更新RCU程序、删除或导出数据库数据等。显示全部内容。",1),
    Manager("manager", "管理员","给人员设置不同权限。例如管理员具有设置空调的预设值等功能，其他用户只能查看空调等，不能设置。",2),
    General("general", "一般人员","只能拥有管理员设置的权限，例如客房部，具有客房管理所有功能，客房维护管理，客房故障保修，维修结果录入等功能。",3),
    FloorManager("floormanager", "楼层管理人员","只拥有管理本楼层的房间权限。显示本楼层的相关信息",4),
    RoomManager("roommanager", "房间人员","拥有控制房间内设备的权限。只显示当前房间的可控设备。",5),;
    private String code;
    private String name;
    private String descr;
    private int orderNum;

    RoleEnum(String code, String name, String descr, int orderNum) {
        this.code = code;
        this.name = name;
        this.descr = descr;
        this.orderNum=orderNum;
    }

    public String getCode() {
        return code;
    }

    public String getDescr() {
        return descr;
    }

    public String getName() {
        return name;
    }

    public int getOrderNum() {
        return orderNum;
    }
}
