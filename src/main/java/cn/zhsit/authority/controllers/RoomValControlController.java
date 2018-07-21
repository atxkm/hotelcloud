package cn.zhsit.authority.controllers;

import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.utils.CommResult;
import cn.zhsit.hotel.models.dto.MsgSendToRCU;
import cn.zhsit.hotel.models.po.EquipmentHotel;
import cn.zhsit.hotel.models.po.RoomTypeHotel;
import cn.zhsit.hotel.models.vo.EquipmentValControlResp;
import cn.zhsit.hotel.models.vo.RoomControlReq;
import cn.zhsit.hotel.models.vo.RoomTypeInfo;
import cn.zhsit.hotel.rcu.RCU;
import cn.zhsit.hotel.services.EquipmentHotelService;
import cn.zhsit.hotel.services.RoomTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房间类型信息管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("roomcontrol")
public class RoomValControlController {
	@Autowired
	EquipmentHotelService equipmentHotelService;
	/**
	 * 通过ip查询房间设备值
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping("/findRoomcontrol")
    public CommResult findRoomcontrol(HttpServletRequest request, HttpServletResponse response,@RequestBody RoomControlReq roomreq) {
		CommResult comm = new CommResult();
    	if(roomreq.getHost()==null || roomreq.getHost().isEmpty()){
			comm.setData(null);
			comm.setMessage("host不能为空");
			comm.setSuccess("false");
		}
		List<EquipmentHotel> lst = equipmentHotelService.selectEquByHost(roomreq.getHost());
    	List<EquipmentValControlResp> resultlst = new ArrayList<EquipmentValControlResp>();
    	for (int i=0;i<lst.size();i++){
			EquipmentHotel aEquipmentHotel = lst.get(i);
			cn.zhsit.hotel.rcu.RCU rcu = cn.zhsit.hotel.collections.FromFrontDeskCollection.getByHost(roomreq.getHost());
			EquipmentValControlResp resp = new EquipmentValControlResp();
			BeanUtils.copyProperties(aEquipmentHotel,resp);
			if(rcu!=null) {
				if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.XiuZhengZhi1.name())) {
					int xiuZhengZhi1 = rcu.getAddressStatus(RCUAddressEnum.XiuZhengZhi1);//修正值
					resp.setSetval(xiuZhengZhi1);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.KeFangRuZhuXinXi.name())) {
					int KeFangRuZhuXinXi = rcu.getAddressStatus(RCUAddressEnum.KeFangRuZhuXinXi);//客房入住信息
					resp.setSetval(KeFangRuZhuXinXi);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.FangMenZhuangTai.name())) {
					int FangMenZhuangTai = rcu.getAddressStatus(RCUAddressEnum.FangMenZhuangTai);//房门状态	红色	8010房间房门异常打开	57(如果为异常期间，我多次轮询，都会返给2)
					resp.setSetval(FangMenZhuangTai);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.XiaoFangJingGao.name())) {
					int XiaoFangJingGao = rcu.getAddressStatus(RCUAddressEnum.XiaoFangJingGao);//消防警告	红色	8010房间消防警告	60  （若没取消警告，会一直返给警告）
					resp.setSetval(XiaoFangJingGao);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.RuQinJingGao.name())) {
					int RuQinJingGao = rcu.getAddressStatus(RCUAddressEnum.RuQinJingGao);//入侵警告	红色	8010房间入侵警告	61
					resp.setSetval(RuQinJingGao);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.JinJiMoShi.name())) {
					int JinJiMoShi = rcu.getAddressStatus(RCUAddressEnum.JinJiMoShi);//紧急模式	红色	8010房间紧急呼叫。	66
					resp.setSetval(JinJiMoShi);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.ShaoHouMoShi.name())) {
					int ShaoHouMoShi = rcu.getAddressStatus(RCUAddressEnum.ShaoHouMoShi);//稍后模式	绿色	8010房间打开稍后模式。	67
					resp.setSetval(ShaoHouMoShi);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.TuiFangMoShi.name())) {
					int TuiFangMoShi = rcu.getAddressStatus(RCUAddressEnum.TuiFangMoShi);//退房服务	蓝色	8010房间呼叫退房服务。	68
					resp.setSetval(TuiFangMoShi);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.QingLiFuWu.name())) {
					int QingLiFuWu = rcu.getAddressStatus(RCUAddressEnum.QingLiFuWu);//清理服务	蓝色	8010房间呼叫清理服务。	69
					resp.setSetval(QingLiFuWu);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.WeiXiuFuWu.name())) {
					int WeiXiuFuWu = rcu.getAddressStatus(RCUAddressEnum.WeiXiuFuWu);//维修服务	黄色	8010房间呼叫维修服务。	70
					resp.setSetval(WeiXiuFuWu);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.YuYinFuWu.name())) {
					int YuYinFuWu = rcu.getAddressStatus(RCUAddressEnum.YuYinFuWu);//语音服务	蓝色	8010房间呼叫语音服务。	71
					resp.setSetval(YuYinFuWu);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.ShiPinFuWu.name())) {
					int ShiPinFuWu = rcu.getAddressStatus(RCUAddressEnum.ShiPinFuWu);//视频服务	蓝色	8010房间呼叫视频服务。	72
					resp.setSetval(ShiPinFuWu);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.HuJiaoFuWu.name())) {
					int HuJiaoFuWu = rcu.getAddressStatus(RCUAddressEnum.HuJiaoFuWu);//呼叫服务	蓝色	8010房间要求呼叫服务。	73
					resp.setSetval(HuJiaoFuWu);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.XiYiFuWu.name())) {
					int XiYiFuWu = rcu.getAddressStatus(RCUAddressEnum.XiYiFuWu);//洗衣服务	蓝色	8010房间呼叫洗衣服务。	74
					resp.setSetval(XiYiFuWu);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.JiaoCanFuWu.name())) {
					int JiaoCanFuWu = rcu.getAddressStatus(RCUAddressEnum.JiaoCanFuWu);//叫餐服务	蓝色	8010房间呼叫叫餐服务。	75
					resp.setSetval(JiaoCanFuWu);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.JiaoCheFuWu.name())) {
					int JiaoCheFuWu = rcu.getAddressStatus(RCUAddressEnum.JiaoCheFuWu);//叫车服务	蓝色	8010房间呼叫叫车服务。	76
					resp.setSetval(JiaoCheFuWu);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.ShiJiWenDu79.name())) {
					int ShiJiWenDu79 = rcu.getAddressStatus(RCUAddressEnum.ShiJiWenDu79);//实际温度1	数值
					resp.setSetval(ShiJiWenDu79);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.SheDingWenDu1.name())) {
					int SheDingWenDu1 = rcu.getAddressStatus(RCUAddressEnum.SheDingWenDu1);//设定温度1	数值
					resp.setSetval(SheDingWenDu1);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.KaiGuanZhuangTai1.name())) {
					int KaiGuanZhuangTai1 = rcu.getAddressStatus(RCUAddressEnum.KaiGuanZhuangTai1);//开关状态1	0为关，1为开
					resp.setSetval(KaiGuanZhuangTai1);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.FengSuZhuangTai1.name())) {
					int FengSuZhuangTai1 = rcu.getAddressStatus(RCUAddressEnum.FengSuZhuangTai1);//风速状态1	0为关，1为低，2为中，3为高
					resp.setSetval(FengSuZhuangTai1);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.MoShiZhuangTai1.name())) {
					int MoShiZhuangTai1 = rcu.getAddressStatus(RCUAddressEnum.MoShiZhuangTai1);//模式状态1	0为制热，1为制冷，2为纯风
					resp.setSetval(MoShiZhuangTai1);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.SuoDingZhuangTai1.name())) {
					int SuoDingZhuangTai1 = rcu.getAddressStatus(RCUAddressEnum.SuoDingZhuangTai1);//锁定状态1	0为无锁定，1为锁定
					resp.setSetval(SuoDingZhuangTai1);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.ShangXiaFengXiang1.name())) {
					int ShangXiaFengXiang1 = rcu.getAddressStatus(RCUAddressEnum.ShangXiaFengXiang1);//上下风向1	0为关，1为开
					resp.setSetval(ShangXiaFengXiang1);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.ZuoYouSaoFeng1.name())) {
					int ZuoYouSaoFeng1 = rcu.getAddressStatus(RCUAddressEnum.ZuoYouSaoFeng1);//左右扫风1	0为关，1为开
					resp.setSetval(ZuoYouSaoFeng1);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.SheDingWenDu2.name())) {
					int SheDingWenDu2 = rcu.getAddressStatus(RCUAddressEnum.SheDingWenDu2);//设定温度2	数值
					resp.setSetval(SheDingWenDu2);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.DengGuang130.name())) {
					int DengGuang130 = rcu.getAddressStatus(RCUAddressEnum.DengGuang130);////空调3的：114至128之间只要有下发，就得下129的1
					resp.setSetval(DengGuang130);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.JiQiRenTongXin.name())) {
					int JiQiRenTongXin = rcu.getAddressStatus(RCUAddressEnum.JiQiRenTongXin);//机器人通信	黄色	8010房间机器人通信故障。	216
					resp.setSetval(JiQiRenTongXin);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.JiQiRenLianWang.name())) {
					int JiQiRenLianWang = rcu.getAddressStatus(RCUAddressEnum.JiQiRenLianWang);//机器人联网	黄色	8010房间机器人联网故障。	217
					resp.setSetval(JiQiRenLianWang);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.JiQiRenDianLiang.name())) {
					int JiQiRenDianLiang = rcu.getAddressStatus(RCUAddressEnum.JiQiRenDianLiang);//机器人电量	黄色	8010房间机器人电量为5%。	218
					resp.setSetval(JiQiRenDianLiang);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.JiQiRenGuZhang.name())) {
					int JiQiRenGuZhang = rcu.getAddressStatus(RCUAddressEnum.JiQiRenGuZhang);//机器人故障	黄色	8010房间机器人故障。	219
					resp.setSetval(JiQiRenGuZhang);
				} else if (aEquipmentHotel.getEquType().equals(RCUAddressEnum.JiQiRenWenZi.name())) {
					int JiQiRenWenZi = rcu.getAddressStatus(RCUAddressEnum.JiQiRenWenZi);//机器人文字	蓝色	8010房间发送信息：*****	220
					resp.setSetval(JiQiRenWenZi);
				}
			}
			resultlst.add(resp);
		}

    	if(lst.size()>0){
	    	comm.setData(resultlst);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(new ArrayList());
	    	comm.setMessage("没有查询到数据");
	    	comm.setSuccess("true");
    	}
        return comm;
    }
	/**
	 * 通过ip查询房间设备值
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/setRoomcontrolVal")
	public CommResult setRoomcontrolVal(HttpServletRequest request, HttpServletResponse response,@RequestBody RoomControlReq roomreq) {
		CommResult comm = new CommResult();
		if (roomreq.getHost() == null || roomreq.getHost().isEmpty()) {
			comm.setData(null);
			comm.setMessage("host不能为空");
			comm.setSuccess("false");
		}
		RCU rcu = cn.zhsit.hotel.collections.FromFrontDeskCollection.getByHost(roomreq.getHost());
		MsgSendToRCU msg = new MsgSendToRCU();
		if(rcu!=null) {
			msg.setDataString(roomreq.getSetval());
			RCUAddressEnum[] allLight = RCUAddressEnum.values ();
			for (RCUAddressEnum aLight : allLight) {

				if(aLight.name().equals(roomreq.getEqutype())){
					msg.setAddress(aLight);
					break;
				}
			}
			roomreq.getEqutype();
			msg.setHostname(roomreq.getHost());
			msg.setPort(rcu.getPort());
		}
		boolean tag = cn.zhsit.hotel.collections.ToFrontDeskCollection.putToRCU(msg);
		comm.setData(tag);
		comm.setMessage("设置成功");
		comm.setSuccess("true");
		return comm;
	}

}
