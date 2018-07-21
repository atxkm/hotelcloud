package cn.zhsit.authority.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zhsit.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.common.utils.page.Page;
import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import cn.zhsit.hotel.models.po.RcuSetparam;
import cn.zhsit.hotel.models.po.RcuSetparamExample;
import cn.zhsit.hotel.models.vo.RcuSetparamResultVo;
import cn.zhsit.hotel.services.RcuService;
import cn.zhsit.hotel.services.RcuSetparamService;
import cn.zhsit.models.vo.RcuSetparamReq;

/**
 * 房间类型信息管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("rcuSetparam")
public class RcuSetparamController {
	@Autowired
	RcuSetparamService rcuSetparamService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加rcu参数设置
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addRcuSetparam")
    public CommResult addRcuSetparam(HttpServletRequest request, HttpServletResponse response,RcuSetparam rcu) {
    	
    	rcu.setRcuid(ZhsUnique.unique25());
    	int i = rcuSetparamService.insert(rcu);
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
     * 查找rcu参数设置
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findRcuSetparam")
    public CommResult findRcuSetparam(HttpServletRequest request, HttpServletResponse response,@RequestBody RcuSetparamReq rcuSetparamReq) {
    	CommResult comm = new CommResult();
    	try{
	    	RcuSetparamExample rs = new RcuSetparamExample();
	    	Page page = new Page().setPage(rcuSetparamReq.getPage().getPage().intValue()).setRows((int)rcuSetparamReq.getPage().getRows());
	    	rs.setPage(page);
	    	rcuSetparamReq.getPage().setPageEnd((rcuSetparamReq.getPage().getPage().intValue()+1)*rcuSetparamReq.getPage().getRows());
	    	rcuSetparamReq.getPage().setPageStart(rcuSetparamReq.getPage().getPage().intValue()*rcuSetparamReq.getPage().getRows());
	    	List<RcuSetparam> hotellst = rcuSetparamService.selectByFloorid(rcuSetparamReq);
	    	long count = rcuSetparamService.countByFloorid(rcuSetparamReq);
	    	
	    	RcuSetparamResultVo vo = new RcuSetparamResultVo();
	    	vo.setResultlst(hotellst);
	    	ComplexPage pagecomp = new ComplexPage();
	    	
	    	pagecomp.setTotal(count);
	    	pagecomp.setPage(rcuSetparamReq.getPage().getPage().intValue()).setRows((int)rcuSetparamReq.getPage().getRows());
	    	vo.setPage(pagecomp);
	    	if(hotellst.size()>0){
		    	comm.setData(vo);
		    	comm.setMessage("查询成功");
		    	comm.setSuccess("true");
	    	}else{
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
     * 修改rcu参数设置
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyRcuSetparam")
    public CommResult modifyRcuSetparam(HttpServletRequest request, HttpServletResponse response,RcuSetparam rcu) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(rcu.getRcuid()!=null&&!rcu.getRcuid().isEmpty()){
    		RcuSetparamExample example = new RcuSetparamExample();
    		example.createCriteria().andRcuidEqualTo(rcu.getRcuid());
    		i = rcuSetparamService.updateByExampleSelective(rcu, example);
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
    @RequestMapping("/delRcuSetparam")
    public CommResult delRcuSetparam(HttpServletRequest request, HttpServletResponse response,RcuSetparam rcuSetparam) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(rcuSetparam.getRcuid()!=null&&!rcuSetparam.getRcuid().isEmpty()){
    		i = rcuSetparamService.deleteByPrimaryKey(rcuSetparam.getRcuid());
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
    
    
    
    @RequestMapping(value = "/batchimport", method = RequestMethod.POST)
    public CommResult batchimport(@RequestParam(value="filename") MultipartFile file,
            HttpServletRequest request,HttpServletResponse response) throws IOException{
        //判断文件是否为空
		//判断文件是否为空
		if(file==null) return null;
		//获取文件名
		String name=file.getOriginalFilename();
		//进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
		long size=file.getSize();
		if(name==null || ("").equals(name) && size==0) return null;
		//判断文件是否为空
		if(file==null){
			//return "";
		}

		//获取文件名
		String fileName=file.getOriginalFilename();

		//验证文件名是否合格
		if(!ExcelImportUtils.validateExcel(fileName)){
			//return "";
		}

		//进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
		size=file.getSize();
		if(StringUtils.isEmpty(fileName) || size==0){
			//return "";
		}

		//批量导入
		List<RcuSetparam> rcus = ReadExcelSetparam.batchImport(fileName,file,"");
		//批量导入。参数：文件名，文件。
		//boolean b = batchImport(name,file);
		int tag = rcuSetparamService.insertRcuSetparam(rcus);
		CommResult comm = new CommResult();
		boolean b = false;
		if(tag>0){
			b=true;
		}
		if(b){
			String Msg ="批量导入EXCEL成功！";
			request.getSession().setAttribute("msg",Msg);
			comm.setData(null);
			comm.setMessage(Msg);
			comm.setSuccess("true");
		}else{
			String Msg ="批量导入EXCEL失败！";
			request.getSession().setAttribute("msg",Msg);
			comm.setData(null);
			comm.setMessage(Msg);
			comm.setSuccess("false");
		}

		return comm;
    }
    
    

}
