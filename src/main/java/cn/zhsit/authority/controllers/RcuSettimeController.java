package cn.zhsit.authority.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.utils.*;
import cn.zhsit.hotel.collections.FromFrontDeskCollection;
import cn.zhsit.hotel.models.po.*;
import cn.zhsit.hotel.rcu.RCU;
import cn.zhsit.hotel.services.RoomHotelService;
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
import cn.zhsit.hotel.models.vo.RcuSettimeResultVo;
import cn.zhsit.hotel.services.RcuService;
import cn.zhsit.hotel.services.RcuSetparamService;
import cn.zhsit.hotel.services.RcuSettimeService;
import cn.zhsit.models.vo.RcuSettimeReq;

/**
 * 房间类型信息管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("rcuSettime")
public class RcuSettimeController {
	@Autowired
	RcuSettimeService rcuSettimeService;
	@Autowired
	RoomHotelService roomHotelService;
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加rcu参数设置
	 * @param request
	 * @param response
	 * @param hotelbean
	 * @return
	 */
    @RequestMapping("/addRcuSettime")
    public CommResult addRcuSettime(HttpServletRequest request, HttpServletResponse response,RcuSettime rcu) {
    	
    	rcu.setRcuid(ZhsUnique.unique25());
    	int i = rcuSettimeService.insert(rcu);
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
    @RequestMapping("/findRcuSettime")
    public CommResult findRcuSettime(HttpServletRequest request, HttpServletResponse response,@RequestBody RcuSettimeReq rcuSettimeReq) {
    	RcuSettimeExample rcuSettimeExcample = new RcuSettimeExample();
    	rcuSettimeExcample.setPage(new Page().setPage(rcuSettimeReq.getPage().getPage().intValue()).setRows((int)rcuSettimeReq.getPage().getRows()));
    	if(rcuSettimeReq.getRoomid()!=null && !"".equals(rcuSettimeReq.getRoomid())){
    		rcuSettimeExcample.createCriteria().andRoomidEqualTo(rcuSettimeReq.getRoomid());
    	}
    	List<RcuSettime> hotellst = rcuSettimeService.selectByExample(rcuSettimeExcample);
    	long count = rcuSettimeService.countByExample(rcuSettimeExcample);
    	CommResult comm = new CommResult();
    	RcuSettimeResultVo vo = new RcuSettimeResultVo();
    	ComplexPage page = new ComplexPage();
    	page.setPage(rcuSettimeReq.getPage().getPage().intValue());
    	page.setRows((int)rcuSettimeReq.getPage().getRows());
    	vo.setPage(page);
    	vo.setResultlst(hotellst);
    	if(hotellst.size()>0){
	    	comm.setData(vo);
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
     * 修改rcu参数设置
     * @param request
     * @param response
     * @param hotelbean
     * @return
     */
    @RequestMapping("/modifyRcuSettime")
    public CommResult modifyRcuSetparam(HttpServletRequest request, HttpServletResponse response,RcuSettime rcu) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(rcu.getRcuid()!=null&&!rcu.getRcuid().isEmpty()){
    		RcuSettimeExample example = new RcuSettimeExample();
    		example.createCriteria().andRcuidEqualTo(rcu.getRcuid());
    		i = rcuSettimeService.updateByExampleSelective(rcu, example);
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
    @RequestMapping("/delRcuSettime")
    public CommResult delRcuSetparam(HttpServletRequest request, HttpServletResponse response,RcuSetparam rcuSetparam) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(rcuSetparam.getRcuid()!=null&&!rcuSetparam.getRcuid().isEmpty()){
    		i = rcuSettimeService.deleteByPrimaryKey(rcuSetparam.getRcuid());
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
		List<RcuSettime> rcus = ReadExcelSettime.batchImport(fileName,file,"");
		//批量导入。参数：文件名，文件。
		//boolean b = batchImport(name,file);
		int tag = rcuSettimeService.insertRcuSetimes(rcus);
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
    
    
    //批量导入客户
    public boolean batchImport(String name,MultipartFile file){
        boolean b = false;
        //创建处理EXCEL
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取客户信息集合。
        List<RcuSettime> customerList = readExcel.getExcelInfoSettime(name ,file);

        if(customerList != null){
            b = true;
        }
        
        //迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
        for(RcuSettime rcu:customerList){
        	rcuSettimeService.insert(rcu);
        }
        return b;
    }


	/**
	 * 查找实时rcu信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/findRunTimeRcu")
	public CommResult findRunTimeRcu(HttpServletRequest request, HttpServletResponse response,@RequestBody RcuSettimeReq rcuSettimeReq) {
		ConcurrentHashMap<String, RCU> rculist = FromFrontDeskCollection.getAllRCU();
		CommResult comm = new CommResult();
		RcuSettimeResultVo vo = new RcuSettimeResultVo();
		ComplexPage page = new ComplexPage();
		page.setPage(rcuSettimeReq.getPage().getPage().intValue());
		page.setRows((int)rcuSettimeReq.getPage().getRows());

		//vo.setResultlst(rculist);
		List<RcuSettime> rcuSettimes = new ArrayList<RcuSettime>();
		Object [] keystr = rculist.keySet().toArray();
		for(int i=0;i<keystr.length;i++){
			String host = keystr[i].toString();
			System.out.println(host+"   "+rculist.get(host));
			RCU rcu = rculist.get(host);
			int miao = rcu.getAddressStatus(RCUAddressEnum.Miao);
			int FenZhong = rcu.getAddressStatus(RCUAddressEnum.FenZhong);
			int XiaoShi = rcu.getAddressStatus(RCUAddressEnum.XiaoShi);
			int XiuZhengZhi1 = rcu.getAddressStatus(RCUAddressEnum.XiuZhengZhi1);
			RcuSettime aRcuSettime = new RcuSettime();
			aRcuSettime.setHour(XiaoShi+"");
			aRcuSettime.setMinutes(FenZhong+"");
			aRcuSettime.setSecond(miao+"");
			aRcuSettime.setTorevise(XiuZhengZhi1+"");
			RoomHotelExample example = new RoomHotelExample();
			example.createCriteria().andRoomipEqualTo(host);
			List<RoomHotel> roomhotels = roomHotelService.selectByExample(example);
			if(roomhotels.size()>0){
				RoomHotel aRoomHotel = roomhotels.get(0);
				aRcuSettime.setRoomid(aRoomHotel.getRoomno());
				aRcuSettime.setRoomtype(aRoomHotel.getRmtypename());
			}
			rcuSettimes.add(aRcuSettime);
		}
		List<RcuSettime> rcuSettimepage = RAMPageUtil.page(rcuSettimes,rcuSettimeReq.getPage().getPage().intValue(),(int)rcuSettimeReq.getPage().getRows());

		vo.setResultlst(rcuSettimepage);
		page.setTotal((long)rculist.size());
		vo.setPage(page);
		if(rculist.size()>0){
			comm.setData(vo);
			comm.setMessage("查询成功");
			comm.setSuccess("true");
		}else{
			vo.setResultlst(new ArrayList());
			comm.setData(vo);
			comm.setMessage("查询失败");
			comm.setSuccess("false");
		}
		return comm;
	}
}
