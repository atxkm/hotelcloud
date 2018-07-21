package cn.zhsit.authority.controllers;

import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.hotel.collections.FromFrontDeskCollection;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.models.po.RoomHotelExample;
import cn.zhsit.hotel.models.vo.RoomEquReqVo;
import cn.zhsit.hotel.models.vo.RoomHotelBeanVo;
import cn.zhsit.hotel.models.vo.RoomHotelEquRespVo;
import cn.zhsit.hotel.models.vo.RoomHotelVo;
import cn.zhsit.hotel.rcu.RCU;
import cn.zhsit.hotel.services.RoomHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房间设备管理
 * 手机端用户查询所有设备列表以及对应的值
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("roomequ")
public class RoomEquController {
	public static Map<String,String> roomidmap = new HashMap<String, String>();
	@Autowired
	RoomHotelService roomHotelService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")

    /**
     * 查找房间
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findHotelEqu")
    public CommResult findHotelEqu(HttpServletRequest request, HttpServletResponse response,@RequestBody RoomEquReqVo roomEquReqVo) {
    	RoomHotelExample roomhotelexample = new RoomHotelExample();
    	CommResult comm = new CommResult();
    	if(roomEquReqVo.getRoomid()==null || "".equals(roomEquReqVo.getRoomid())){
    		comm.setData(null);
	    	comm.setMessage("房间ID不有为空");
	    	comm.setSuccess("flase");
	    	return comm;
    	}
    	try{
    		Map<String,String> equmap = new HashMap<String,String>();
    		int kongtiao = 0;
    		int dengguang = 0;
	    	List<RoomHotelEquRespVo> hotellst = roomHotelService.selectByRoomId(roomEquReqVo);
	    	for (RoomHotelEquRespVo roomHotelEquRespVo:hotellst){
	    		if(roomHotelEquRespVo.getHost()!=null) {
					RCU rcu = FromFrontDeskCollection.getByHost(roomHotelEquRespVo.getHost());
					if(roomHotelEquRespVo.getEquType()!=null) {
						if(roomHotelEquRespVo.getEquType().equals("kongtiao")){
							kongtiao++;
							roomHotelEquRespVo.setSerialno(kongtiao);
							RCUAddressEnum addrenum = RCUAddressEnum.SheDingWenDu1;
							/**---------------------空调---------------------*/

							/**实际温度1	数值*/
							Integer temp = rcu.getAddressStatus(RCUAddressEnum.ShiJiWenDu79);
							if (temp != null) {
								equmap.put("SheDingWenDu1",temp.toString());
							}

							/**开关状态1	0为关，1为开*/
							temp = rcu.getAddressStatus(RCUAddressEnum.KaiGuanZhuangTai1);
							if (temp != null) {
								equmap.put("KaiGuanZhuangTai1",temp.toString());
							}

							/**风速状态1	0为关，1为低，2为中，3为高*/
							temp = rcu.getAddressStatus(RCUAddressEnum.FengSuZhuangTai1);
							if (temp != null) {
								equmap.put("FengSuZhuangTai1",temp.toString());
							}

							/**模式状态1	0为制热，1为制冷，2为纯风*/
							temp = rcu.getAddressStatus(RCUAddressEnum.MoShiZhuangTai1);
							if (temp != null) {
								equmap.put("MoShiZhuangTai1",temp.toString());
							}

							/** 84	锁定状态1	0为无锁定，1为锁定*/
							temp = rcu.getAddressStatus(RCUAddressEnum.SuoDingZhuangTai1);
							if (temp != null) {
								equmap.put("SuoDingZhuangTai1",temp.toString());
							}

							/** 85	上下风向1	0为关，1为开*/
							temp = rcu.getAddressStatus(RCUAddressEnum.ShangXiaFengXiang1);
							if (temp != null) {
								equmap.put("ShangXiaFengXiang1",temp.toString());
							}

							/** 86	左右扫风1	0为关，1为开*/
							temp = rcu.getAddressStatus(RCUAddressEnum.ZuoYouSaoFeng1);
							if (temp != null) {
								equmap.put("ZuoYouSaoFeng1",temp.toString());
							}

							/** 87	修正值1	数值*/
							temp = rcu.getAddressStatus(RCUAddressEnum.XiuZhengZhi1);
							if (temp != null) {
								equmap.put("XiuZhengZhi1",temp.toString());
							}

							/**---------------------空调二---------------------*/
							/**实际温度1	数值*/
							temp = rcu.getAddressStatus(RCUAddressEnum.ShiJiWenDu2);
							if (temp != null) {
								equmap.put("ShiJiWenDu2",temp.toString());
							}

							/**开关状态1	0为关，1为开*/
							temp = rcu.getAddressStatus(RCUAddressEnum.KaiGuanZhuangTai2);
							if (temp != null) {
								equmap.put("KaiGuanZhuangTai2",temp.toString());
							}

							/**风速状态1	0为关，1为低，2为中，3为高*/
							temp = rcu.getAddressStatus(RCUAddressEnum.FengSuZhuangTai2);
							if (temp != null) {
								equmap.put("FengSuZhuangTai2",temp.toString());
							}

							/**模式状态1	0为制热，1为制冷，2为纯风*/
							temp = rcu.getAddressStatus(RCUAddressEnum.MoShiZhuangTai2);
							if (temp != null) {
								equmap.put("MoShiZhuangTai2",temp.toString());
							}

							/** 84	锁定状态1	0为无锁定，1为锁定*/
							temp = rcu.getAddressStatus(RCUAddressEnum.SuoDingZhuangTai2);
							if (temp != null) {
								equmap.put("SuoDingZhuangTai2",temp.toString());
							}

							/** 85	上下风向1	0为关，1为开*/
							temp = rcu.getAddressStatus(RCUAddressEnum.ShangXiaFengXiang2);
							if (temp != null) {
								equmap.put("ShangXiaFengXiang2",temp.toString());
							}

							/** 86	左右扫风1	0为关，1为开*/
							temp = rcu.getAddressStatus(RCUAddressEnum.ZuoYouSaoFeng2);
							if (temp != null) {
								equmap.put("ZuoYouSaoFeng2",temp.toString());
							}

							/** 87	修正值1	数值*/
							temp = rcu.getAddressStatus(RCUAddressEnum.XiuZhengZhi2);
							if (temp != null) {
								equmap.put("XiuZhengZhi2",temp.toString());
							}
						}else if(roomHotelEquRespVo.getEquType().equals("dengguang")){
							dengguang++;
							roomHotelEquRespVo.setSerialno(dengguang);
							Integer temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang130);
							if (temp != null) {
								equmap.put("DengGuang130",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang131);
							if (temp != null) {
								equmap.put("DengGuang131",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang132);
							if (temp != null) {
								equmap.put("DengGuang132",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang133);
							if (temp != null) {
								equmap.put("DengGuang133",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang134);
							if (temp != null) {
								equmap.put("DengGuang134",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang135);
							if (temp != null) {
								equmap.put("DengGuang135",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang136);
							if (temp != null) {
								equmap.put("DengGuang136",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang137);
							if (temp != null) {
								equmap.put("DengGuang137",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang138);
							if (temp != null) {
								equmap.put("DengGuang138",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang139);
							if (temp != null) {
								equmap.put("DengGuang139",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang140);
							if (temp != null) {
								equmap.put("DengGuang140",temp.toString());
							}

							temp = rcu.getAddressStatus(RCUAddressEnum.DengGuang140);
							if (temp != null) {
								equmap.put("DengGuang140",temp.toString());
							}
						}
					}
				}

				roomHotelEquRespVo.setEquMapValue(equmap);
			}
	    	comm.setData(hotellst);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	}catch(Exception e){
    		e.printStackTrace();
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    
    
    

    

}
