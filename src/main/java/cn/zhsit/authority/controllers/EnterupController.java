package cn.zhsit.authority.controllers;

import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.collections.ToFrontDeskCollection;
import cn.zhsit.hotel.commands.RoomCommands;
import cn.zhsit.hotel.models.dto.MsgSendToFrontDeskPerson;
import cn.zhsit.hotel.models.po.Enterup;
import cn.zhsit.hotel.models.po.EnterupExample;
import cn.zhsit.hotel.models.po.RoomHotel;
import cn.zhsit.hotel.models.po.RoomHotelExample;
import cn.zhsit.hotel.models.vo.EnterupVo;
import cn.zhsit.hotel.models.vo.EnterupVoResp;
import cn.zhsit.hotel.services.EnterupService;
import cn.zhsit.hotel.services.RoomHotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登记信息
 * Created by Administrator on 2017/11/22.
 */
@RestController
@RequestMapping("enter")
public class EnterupController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private EnterupService enterupService;
    @Autowired
    private RoomHotelService roomHotelService;

    @RequestMapping("/addEnterup")
    public CommResult addEnterup(HttpServletRequest request, HttpServletResponse response,@RequestBody Enterup enterup) {
    	CommResult comm = new CommResult();
    	try{
	    	enterup.setEnterid(ZhsUnique.unique25());
	    	
	    	int i = enterupService.insert(enterup);
	    	if(i>0){
		    	comm.setData(null);
		    	comm.setMessage("保存成功");
		    	comm.setSuccess("true");
		    	String roomid = enterup.getRoomid();
		    	//String [] arr = roomid.split(" ");
		    	//for(int x=0;x<arr.length;x++){
				if(roomid!=null) {
					RoomHotelExample ex = new RoomHotelExample();
					ex.createCriteria().andIdEqualTo(roomid);
					List<RoomHotel> lst = roomHotelService.selectByExample(ex);
					if (lst.size() > 0) {
						RoomHotel aRoomHotel = lst.get(0);
						RoomCommands.cleanGuestRequest(aRoomHotel.getRoomip());
					}
				}
	    	}else{
	    		comm.setData(null);
		    	comm.setMessage("保存失败");
		    	comm.setSuccess("false");
	    	}
	    	return comm;
    	}catch(Exception e){
    		e.printStackTrace();
    		comm.setData(null);
	    	comm.setMessage("保存失败"+e.getMessage());
	    	comm.setSuccess("false");
    	}
       return null;
    }
    
    /**
     * 查找rcu
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findEnterup")
    public CommResult findEnterup(HttpServletRequest request, HttpServletResponse response,@RequestBody EnterupVo enterupVo) {
		CommResult comm = new CommResult();
    	try {
			EnterupExample example = new EnterupExample();
			example.setPage(new Page().setPage(enterupVo.getPage().getPage().intValue()).setRows((int) enterupVo.getPage().getRows()));
			List<Enterup> hotellst = enterupService.selectByExample(example);
			long total = enterupService.countByExample(example);
			EnterupVoResp resp = new EnterupVoResp();
			resp.setResultlst(hotellst);
			ComplexPage page = new ComplexPage();
			page.setTotal(total);
			page.setPage(enterupVo.getPage().getPage().intValue());
			page.setRows((int) enterupVo.getPage().getRows());
			resp.setPage(page);
			if (hotellst.size() > 0) {
				comm.setData(resp);
				comm.setMessage("查询成功");
				comm.setSuccess("true");
			} else {
				comm.setData(null);
				comm.setMessage("查询成功，没有数据");
				comm.setSuccess("true");
			}
			return comm;
		}catch(Exception e){
    		e.printStackTrace();
			comm.setData(null);
			comm.setMessage("查询失败");
			comm.setSuccess("false");
			return comm;
		}
    }
    /**
     * 修改rcu
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyEnterup")
    public CommResult modifyEnterup(HttpServletRequest request, HttpServletResponse response,@RequestBody Enterup enterup) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(enterup.getEnterid()!=null&&!enterup.getEnterid().isEmpty()){
    		EnterupExample example = new EnterupExample();
    		example.createCriteria().andEnteridEqualTo(enterup.getEnterid());
    		i = enterupService.updateByExampleSelective(enterup, example);
    	}else{
    		comm.setMessage("id不能为空");
    		i=-1;
    	}
    	
    	if(i>0){
	    	comm.setData(null);
	    	comm.setMessage("修改成功");
	    	comm.setSuccess("true");
    	}else if(i==-1){
    		comm.setData(null);
	    	comm.setSuccess("false");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("修改失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    /**
     * 删除rcu
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/delEnterup")
    public CommResult delEnterup(HttpServletRequest request, HttpServletResponse response,@RequestBody Enterup enterup) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(enterup.getGuestmobile()!=null&&!enterup.getGuestmobile().isEmpty()){
    		EnterupExample example = new EnterupExample();
    		example.createCriteria().andGuestmobileEqualTo(enterup.getGuestmobile());
			MsgSendToFrontDeskPerson msg = new MsgSendToFrontDeskPerson();
			msg.setDataString(RCUAddressEnum.TuiFangMoShi.name());
			int mockNum = 1101;
			msg.setDataString(mockNum++ + "房间客户退房");
			ToFrontDeskCollection.putToFrontDeskPerson(msg);
    		i = enterupService.deleteByExample(example);
    	}else{
    		comm.setMessage("id不能为空");
    		i=-1;
    	}
    	if(i>0){
	    	comm.setData(null);
	    	comm.setMessage("删除成功");
	    	comm.setSuccess("true");
    	}else if(i==-1){
    		comm.setData(null);
	    	comm.setSuccess("false");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("删除失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
  

}
