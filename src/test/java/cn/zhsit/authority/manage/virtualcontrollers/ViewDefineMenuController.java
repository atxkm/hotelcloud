package cn.zhsit.authority.manage.virtualcontrollers;

import cn.zhsit.authority.annotations.Authority;
import cn.zhsit.authority.annotations.Menu;
import cn.zhsit.authority.manage.annotations.ZhsVirtualController;

/**
 * Created by Darren on 2017/7/9.
 */
@ZhsVirtualController
public class ViewDefineMenuController {
//    序号	一级菜单	二级菜单
//    1	主页
//    2	房态显示	主楼一层、主楼二层（按照房间设置的楼层）
//    3	客房管理	信息查询、信息管理、文字信息
//    4	房间设置	房间类型、房间楼栋、房间编号、设备模式
//    5	RCU设置	工程设置、参数设置、时间设置、复位升级，
//    6	系统设置	身份设置、图标设置、呼叫设置、接口设置、主题选择
//    7	系统帮助	注册信息、图例说明、使用帮助、接口说明，

    @Authority(code = "home.show",descr="主页",group = "主页")
    @Menu(menuShow = "主页")
    public String home(){
        return "";
    }

    @Authority(code = "room.status",descr="房态显示",group = "房态显示")
    @Menu(menuShow = "房态显示")
    public String roomStatus(){
        return "";
    }

    @Authority(code = "room.manage",descr="客房管理",group = "客房管理")
    @Menu(menuShow = "客房管理")
    public String roomManage(){
        return "";
    }

    @Authority(code = "info.query",descr="信息查询",group = "客房管理")
    @Menu(menuShow = "信息查询")
    public String infoQuery(){
        return "";
    }

    @Authority(code = "info.manage",descr="信息管理",group = "客房管理")
    @Menu(menuShow = "信息管理")
    public String infoManage(){
        return "";
    }

    @Authority(code = "text.info",descr="文字信息",group = "客房管理")
    @Menu(menuShow = "文字信息")
    public String textInfo(){
        return "";
    }


    @Authority(code = "rcu.set",descr="RCU设置",group = "RCU设置")
    @Menu(menuShow = "RCU设置")
    public String hello1() {
        return "";
    }

    @Authority(code = "project.set",descr="工程设置",group = "RCU设置")
    @Menu(menuShow = "工程设置")
    public String hello2() {
        return "";
    }
}
