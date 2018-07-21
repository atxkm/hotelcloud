package cn.zhsit.authority.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zhsit.common.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.zhsit.hotel.models.po.Message;
import cn.zhsit.hotel.models.po.MessageExample;
import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import cn.zhsit.hotel.models.po.SoftReg;
import cn.zhsit.hotel.models.po.SoftRegExample;
import cn.zhsit.hotel.models.vo.SoftRegVoReq;
import cn.zhsit.hotel.services.SoftRegService;

/**
 * 软件注册管理
 * @author zhb
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("softreg")
public class SoftRegController {
	@Autowired
	SoftRegService softRegService;


	public static Date addDate(Date d,long day) throws ParseException {
		long time = d.getTime();
		day = day*24*60*60*1000;
		time+=day;
		return new Date(time);
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/createSoftSecurity")
	public CommResult addSoftreg(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		CommResult comm = new CommResult();
		try {
			DesUtils des = new DesUtils(DesUtils.PASSWORDKEY);//自定义密钥
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String michi = ZhsCpuUtil.getSerialNum()+","+DesUtils.enableDate(20);
			String entymich = des.encrypt(michi);
			comm.setData(entymich);
			comm.setMessage("生成成功");
			comm.setSuccess("true");
		}
		catch (Exception e) {
			//e.printStackTrace();
			comm.setData(null);
			comm.setMessage("生成失败");
			comm.setSuccess("false");
		}
		return comm;
	}
    //@Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
	/**
	 * 增加注册信息
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping(value="/addSoftreg")
		public CommResult addSoftreg(HttpServletRequest request, HttpServletResponse response,@RequestBody SoftRegVoReq softRegReq) throws ParseException {
		String numarr[]=null;

		try {
				CommResult comm = new CommResult();
				SoftReg softReg = new SoftReg();
				BeanUtils.copyProperties(softRegReq, softReg);
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(new Date().getTime());
				Calendar calend = Calendar.getInstance();
				Long endTime = addDate(new Date(), 30).getTime();
				calend.setTimeInMillis(endTime);
				softReg.setStartdate(cal.getTime());
				DesUtils des = new DesUtils(DesUtils.PASSWORDKEY);//自定义密钥
				String decmichino ="";
				try {
					decmichino = des.decrypt(softReg.getMachineno());
				}catch(Exception e){
					e.printStackTrace();
				}
				if(decmichino.length()>0) {
					numarr = decmichino.split(",");
					SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
					softReg.setEnddate(sf.parse(numarr[1]));
					softReg.setId(ZhsUnique.unique25());
					String serial = ZhsCpuUtil.getSerialNum();
					if (numarr[0].equals(serial)) {
						softReg.setMachineno(numarr[0]);
					} else {
						comm.setData(null);
						comm.setMessage("机器码错误");
						comm.setSuccess("false");
						return comm;
					}
					softReg.setAssigtime(new Date());

					SoftRegExample example = new SoftRegExample();
					example.createCriteria().andMachinenoEqualTo(numarr[0]);
					List<SoftReg> softregs = softRegService.selectByExample(example);
					if (softregs.size() > 0) {
						SoftReg aSoftReg = softregs.get(0);
						comm.setData(null);
						comm.setSuccess("false");
						comm.setMessage("该注册码已被使用");
						return comm;
					}
					int i = softRegService.insert(softReg);
					if (i > 0) {
						comm.setData(null);
						comm.setMessage("保存成功");
						comm.setSuccess("true");
					} else {
						comm.setData(null);
						comm.setMessage("保存失败");
						comm.setSuccess("false");
					}

					return comm;
				}
				return null;
			}catch(Exception e){
				e.printStackTrace();
			}
        return null;
    }
    
    /**
     * 查找注册信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findSoftreg")
    public CommResult findSoftreg(HttpServletRequest request, HttpServletResponse response) {
    	
    	List<SoftReg> hotellst = softRegService.selectByExample(null);
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
     * 注册机器信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/modifySoftreg")
    public CommResult modifySoftreg(HttpServletRequest request, HttpServletResponse response,@RequestBody SoftRegVoReq softRegReq) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	SoftReg softReg = new SoftReg();
    	BeanUtils.copyProperties(softRegReq, softReg);
    	if(softRegReq.getRegnumber()!=null&&!softRegReq.getRegnumber().isEmpty()){
    		SoftRegExample example = new SoftRegExample();
    		example.createCriteria().andRegnumberEqualTo(softReg.getRegnumber());
			List<SoftReg> softregs = softRegService.selectByExample(example);
			if(softregs.size()>0){
				SoftReg aSoftReg = softregs.get(0);
				i = softRegService.updateByExampleSelective(aSoftReg, example);
			}else{
				comm.setData(null);
				comm.setSuccess("true");
				comm.setMessage("注册失败");
			}

    	}else{
			String serial = ZhsCpuUtil.getSerialNum();
			SoftRegExample example = new SoftRegExample();
			example.createCriteria().andRegnumberEqualTo(serial);
			List<SoftReg> softregs = softRegService.selectByExample(example);
			if(softregs.size()>0){
				SoftReg aSoftReg = softregs.get(0);
				i = softRegService.updateByExampleSelective(aSoftReg, example);
			}else{
				comm.setData(null);
				comm.setMessage("注册失败");
				comm.setSuccess("true");
			}
    	}
    	
    	if(i>0){
	    	comm.setData(null);
	    	comm.setMessage("注册成功");
	    	comm.setSuccess("true");
    	}else if(i==-1){
    		comm.setData(null);
	    	comm.setSuccess("false");
    	}else{
    		comm.setData(null);
	    	comm.setMessage("注册失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    /**
     * 删除注册信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/delSoftreg")
    public CommResult delSoftreg(HttpServletRequest request, HttpServletResponse response,@RequestBody SoftReg softReg) {
    	int i = 0;
    	CommResult comm = new CommResult();
    	if(softReg.getId()!=null&&!softReg.getId().isEmpty()){
    		i = softRegService.deleteByPrimaryKey(softReg.getId());
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
    
    
    /**
	 *
     * 软件剩余使用天数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/findSoftregSurplus")
    public CommResult findSoftregSurplus(HttpServletRequest request, HttpServletResponse response,@RequestBody(required=false) SoftRegVoReq softRegVo) {
    	CommResult comm = new CommResult();
    	try{
	    	SoftRegExample example = new SoftRegExample();
			String serial = ZhsCpuUtil.getSerialNum();
	    	example.createCriteria().andRegnumberEqualTo(serial);
	    	List<SoftReg> hotellst = softRegService.selectByExample(example);
	    	int i = 0;

	    	if(hotellst.size()>0){
	    		SoftReg aSoftReg = hotellst.get(0);
	    		i = differentDays(new Date(),aSoftReg.getEnddate());
	    	}
	    	
	    	if(hotellst.size()>0){
		    	comm.setData(i);
		    	comm.setMessage("查询成功");
		    	comm.setSuccess("true");
	    	}else{
	    		comm.setData(null);
		    	comm.setMessage("注册号码错误或不存在，请修改后重试");
		    	comm.setSuccess("true");
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    		comm.setData(null);
	    	comm.setMessage("查询失败");
	    	comm.setSuccess("false");
    	}
        return comm;
    }
    /**
     * date2比date1多的天数
     * @param date1    
     * @param date2
     * @return    
     */
    public int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
       int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1)+"   "+day2+"   "+day1);
            return day2-day1;
        }
    }



	/**
	 * 机器号码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/findMachineNumber")
	public CommResult findMachineNumber(HttpServletRequest request, HttpServletResponse response) {
		CommResult comm = new CommResult();
		try{
			String serial = ZhsCpuUtil.getSerialNum();
			comm.setData(serial);
		}catch(Exception e){
			e.printStackTrace();
			comm.setData(null);
			comm.setMessage("查询失败");
			comm.setSuccess("false");
		}
		return comm;
	}
}
