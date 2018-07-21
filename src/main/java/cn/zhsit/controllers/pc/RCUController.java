package cn.zhsit.controllers.pc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.enums.RCUOrderEnum;
import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.collections.ToFrontDeskCollection;
import cn.zhsit.hotel.models.dto.MsgSendToRCU;
import cn.zhsit.hotel.models.po.Warning;
import cn.zhsit.hotel.models.vo.MsgSendToRCUVo;

/**
 * Created by Administrator on 2017/10/20.
 */
@RestController
@RequestMapping("rcu")
public class RCUController {

	@RequestMapping("/sendRcuCommand")
    public CommResult sendRcuCommand(HttpServletRequest request, HttpServletResponse response, MsgSendToRCUVo msgSendToRCUVo) {
		 CommResult comm = new CommResult();
		 MsgSendToRCU msg = new MsgSendToRCU();
         msg.setHostname(msgSendToRCUVo.getHostname())
            .setPort(1278)
            .setOrder(RCUOrderEnum.of(msgSendToRCUVo.getOrder()))
            .setAddress(RCUAddressEnum.of(msgSendToRCUVo.getAddress()))
            .setDataString(msgSendToRCUVo.getDataString());
         boolean bool = ToFrontDeskCollection.putToRCU(msg);
         List<MsgSendToRCU> lst = ToFrontDeskCollection.findToRCU(1);
         if(lst.size()>0){
        	 System.out.println(lst.get(0));
         }
    	 if(bool){
	    	comm.setData(null);
	    	comm.setMessage("发送成功");
	    	comm.setSuccess("true");
    	 }else{
    		comm.setData(null);
	    	comm.setMessage("发送失败");
	    	comm.setSuccess("false");
    	 }
         return comm;
    }


	@RequestMapping("/selectRcuCommand")
    public CommResult selectRcuCommand(HttpServletRequest request, HttpServletResponse response, MsgSendToRCUVo msgSendToRCUVo) {
		 CommResult comm = new CommResult();
		 MsgSendToRCU msg = new MsgSendToRCU();

         boolean bool = false;
    	 if(bool){
	    	comm.setData(null);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	 }else{
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	 }
         return comm;
    }
}
