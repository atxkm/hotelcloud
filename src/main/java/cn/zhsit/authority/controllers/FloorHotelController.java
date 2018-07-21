package cn.zhsit.authority.controllers;

import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.common.handlers.ZhsContextHandler;
import cn.zhsit.common.models.DtoSession;
import cn.zhsit.hotel.models.vo.FloorHotelVo;
import cn.zhsit.hotel.models.vo.FloorlVo;
import cn.zhsit.hotel.services.FloorHotelService;
import cn.zhsit.models.vo.BaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
@RestController
@RequestMapping("floor")
public class FloorHotelController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private FloorHotelService floorHotelService;


    @RequestMapping(value = "allfloor", method = {RequestMethod.GET, RequestMethod.POST})
    public String login() throws Exception {
        BaseVO result = new BaseVO().fail();
        List<FloorlVo> voList= floorHotelService.findAllFloors();
        result.success();
        ZhsSession session = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
        result.addVal(BaseVO.Session, new DtoSession().setStatus(LoginStatus.Logined).setVersion(session.getSessionKey()));
        result.addVal(BaseVO.Data, voList);
        return result.toString();
    }

}
