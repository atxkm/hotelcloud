package cn.zhsit.authority.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.zhsit.common.utils.CommResult;
import cn.zhsit.common.utils.ReadExcel;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.MessageExample;
import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import cn.zhsit.hotel.services.MessageService;
import cn.zhsit.hotel.services.RcuService;

/**
 * 房间类型信息管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("message")
public class MessageController {
	@Autowired
	MessageService messageService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加rcu
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addMessage")
    public CommResult addMessage(HttpServletRequest request, HttpServletResponse response,@RequestBody Message message) {
    	
    	message.setMessageid(ZhsUnique.unique25());
    	int i = messageService.insert(message);
    	CommResult comm = new CommResult();
    	if(i>0){
	    	comm.setData(null);
	    	comm.setMessage("保存成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("保存失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    
    /**
     * 查找rcu
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findMessage")
    public CommResult findMessage(HttpServletRequest request, HttpServletResponse response) {
    	
    	List<Message> hotellst = messageService.selectByExample(null);
    	CommResult comm = new CommResult();
    	if(hotellst.size()>0){
	    	comm.setData(hotellst);
	    	comm.setMessage("查询成功");
	    	comm.setSuccess("true");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    /**
     * 修改rcu
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyMessage")
    public CommResult modifyMessage(HttpServletRequest request, HttpServletResponse response,@RequestBody Message message) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(message.getMessageid()!=null&&!message.getMessageid().isEmpty()){
    		MessageExample example = new MessageExample();
    		example.createCriteria().andMessageidEqualTo(message.getMessageid());
    		i = messageService.updateByExampleSelective(message, example);
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
    @RequestMapping("/delMessage")
    public CommResult delMessage(HttpServletRequest request, HttpServletResponse response,@RequestBody Message message) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(message.getMessageid()!=null&&!message.getMessageid().isEmpty()){
    		i = messageService.deleteByPrimaryKey(message.getMessageid());
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
