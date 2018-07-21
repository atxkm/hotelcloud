package cn.zhsit.daos;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import cn.zhsit.common.enums.RoomEventType;
import cn.zhsit.common.utils.ZhsMD5;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.daos.EquipmentSetvalMapper;
import cn.zhsit.hotel.models.po.EquipmentSetval;
import cn.zhsit.hotel.models.po.EquipmentSetvalExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class EquipmentSetvalTest {
    @Autowired
    public EquipmentSetvalMapper equipmentSetvalMapper;
    @Test
    public void addDevPerson1() {
        /**房门状态*/
        EquipmentSetval val = new EquipmentSetval();
        val.setModelid("1");
        val.setParamname("房门状态");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("0");
        val.setParamtype(RoomEventType.FangMenZhuangTai.code()+"");//房门状态
        /**时间段*/
        //val.setModelsettime("9:00-12:00");
        /**时间段*/
        val.setSetval("0");
        EquipmentSetvalExample example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        List<EquipmentSetval> lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**清理服务*/
        val = new EquipmentSetval();
        val.setModelid("2");
        val.setParamname("清理服务");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("1");
        val.setParamtype(RoomEventType.QingLiFuWu.code()+"");//清理服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**插卡取电*/
        val = new EquipmentSetval();
        val.setModelid("3");
        val.setParamname("插卡取电");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("2");
        val.setParamtype(RoomEventType.ChaKaQuDian.code()+"");//插卡取电
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**房门异常打开*/
        val = new EquipmentSetval();
        val.setModelid("4");
        val.setParamname("房门异常打开");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("3");
        val.setParamtype(RoomEventType.FangMenZhuangTai.code()+"");//房门异常打开
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }
        /**消防警告*/
        val = new EquipmentSetval();
        val.setModelid("5");
        val.setParamname("消防警告");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("4");
        val.setParamtype(RoomEventType.XiaoFangJingGao.code()+"");//消防警告
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**入侵警告*/
        val = new EquipmentSetval();
        val.setModelid("6");
        val.setParamname("入侵警告");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("5");
        val.setParamtype(RoomEventType.RuQinJingGao.code()+"");//入侵警告
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**勿扰模式*/
        val = new EquipmentSetval();
        val.setModelid("7");
        val.setParamname("勿扰模式");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("6");
        val.setParamtype(RoomEventType.WuRaoMoShi.code()+"");//勿扰模式
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }
        /**紧急模式*/
        val = new EquipmentSetval();
        val.setModelid("8");
        val.setParamname("紧急模式");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("7");
        val.setParamtype(RoomEventType.JinJiMoShi.code()+"");//紧急模式
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**稍后模式*/
        val = new EquipmentSetval();
        val.setModelid("9");
        val.setParamname("稍后模式");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("8");
        val.setParamtype(RoomEventType.ShaoHouMoShi.code()+"");//稍后模式
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**退房服务*/
        val = new EquipmentSetval();
        val.setModelid("10");
        val.setParamname("退房服务");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("9");
        val.setParamtype(RoomEventType.ShaoHouMoShi.code()+"");//退房服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**清理服务*/
        val = new EquipmentSetval();
        val.setModelid("11");
        val.setParamname("清理服务");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("10");
        val.setParamtype(RoomEventType.QingLiFuWu.code()+"");//清理服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**维修服务*/
        val = new EquipmentSetval();
        val.setModelid("12");
        val.setParamname("维修服务");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("11");
        val.setParamtype(RoomEventType.WeiXiuFuWu.code()+"");//维修服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }
        /**语音服务*/
        val = new EquipmentSetval();
        val.setModelid("13");
        val.setParamname("语音服务");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("12");
        val.setParamtype(RoomEventType.YuYinFuWu.code()+"");//语音服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**视频服务*/
        val = new EquipmentSetval();
        val.setModelid("14");
        val.setParamname("视频服务");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("13");
        val.setParamtype(RoomEventType.ShiPinFuWu.code()+"");//视频服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**呼叫服务*/
        val = new EquipmentSetval();
        val.setModelid("15");
        val.setParamname("呼叫服务");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("14");
        val.setParamtype(RoomEventType.HuJiaoFuWu.code()+"");//呼叫服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**洗衣服务*/
        val = new EquipmentSetval();
        val.setModelid("16");
        val.setParamname("洗衣服务");
        val.setTopparamtype("0");//参数类型 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("15");
        val.setParamtype(RoomEventType.XiYiFuWu.code()+"");//洗衣服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**叫餐服务*/
        val = new EquipmentSetval();
        val.setModelid("17");
        val.setParamname("叫餐服务");
        val.setTopparamtype("0");//叫餐服务 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("16");
        val.setParamtype(RoomEventType.XiYiFuWu.code()+"");//叫餐服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**叫车服务*/
        val = new EquipmentSetval();
        val.setModelid("18");
        val.setParamname("叫车服务");
        val.setTopparamtype("0");//叫餐服务 （0：房态显示，1：呼叫设置）
        val.setParambelongtype("17");
        val.setParamtype(RoomEventType.JiaoCheFuWu.code()+"");//叫车服务
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**机器人通信*/
        val = new EquipmentSetval();
        val.setModelid("19");
        val.setParamname("机器人通信");
        val.setTopparamtype("0");// （0：房态显示，1：呼叫设置）
        val.setParambelongtype("18");
        val.setParamtype(RoomEventType.JiQiRenTongXin.code()+"");//机器人通信
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**机器人联网*/
        val = new EquipmentSetval();
        val.setModelid("20");
        val.setParamname("机器人联网");
        val.setTopparamtype("0");// （0：房态显示，1：呼叫设置）
        val.setParambelongtype("19");
        val.setParamtype(RoomEventType.JiQiRenLianWang.code()+"");//机器人联网
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }
        /**机器人电量*/
        val = new EquipmentSetval();
        val.setModelid("21");
        val.setParamname("机器人电量");
        val.setTopparamtype("0");// （0：房态显示，1：呼叫设置）
        val.setParambelongtype("20");
        val.setParamtype(RoomEventType.JiQiRenDianLiang.code()+"");//机器人电量
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**机器人故障*/
        val = new EquipmentSetval();
        val.setModelid("22");
        val.setParamname("机器人故障");
        val.setTopparamtype("0");// （0：房态显示，1：呼叫设置）
        val.setParambelongtype("21");
        val.setParamtype(RoomEventType.JiQiRenGuZhang.code()+"");//机器人故障
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }

        /**机器人文字*/
        val = new EquipmentSetval();
        val.setModelid("23");
        val.setParamname("机器人文字");
        val.setTopparamtype("0");// （0：房态显示，1：呼叫设置）
        val.setParambelongtype("22");
        val.setParamtype(RoomEventType.JiQiRenWenZi.code()+"");//机器人文字
        val.setSetval("0");
        example = new EquipmentSetvalExample();
        example.createCriteria().andModelidEqualTo(val.getModelid());
        lst = equipmentSetvalMapper.selectByExample(example);
        if(lst.size()>0){
            equipmentSetvalMapper.updateByPrimaryKey(val);
        }else{
            equipmentSetvalMapper.insert(val);
        }
    }


}
