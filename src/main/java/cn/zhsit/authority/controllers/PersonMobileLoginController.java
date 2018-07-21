package cn.zhsit.authority.controllers;

import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.common.handlers.ZhsContextHandler;
import cn.zhsit.common.models.DtoSession;
import cn.zhsit.common.utils.ZhsErrorsUtil;
import cn.zhsit.hotel.models.po.Enterup;
import cn.zhsit.hotel.models.po.EnterupExample;
import cn.zhsit.hotel.services.EnterupService;
import cn.zhsit.models.vo.BaseVO;
import cn.zhsit.models.vo.CheckLoggedResp;
import cn.zhsit.models.vo.LoginReq;
import cn.zhsit.models.vo.SessionResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Darren on 2017/7/11.
 */
@RestController
@RequestMapping("personmobile")
public class PersonMobileLoginController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CacheHelper cacheHelper;

    @Autowired
    private EnterupService enterupService;

    @PostMapping(value = "login")
    public String login(@Valid @RequestBody LoginReq login, Errors errors) throws Exception {
        BaseVO result = new BaseVO().fail();
        if (errors.hasErrors()) {
            result.addVal(BaseVO.Message, ZhsErrorsUtil.getMessage(errors));
            return result.toString();
        }
        EnterupExample ee = new EnterupExample();
        ee.createCriteria().andGuestmobileEqualTo(login.getLoginName());
        List<Enterup> enterlst =  enterupService.selectByExample(ee);
        if (enterlst.size()>0 && login.getPwd().equals("hotel123456")) {
            result.success();
            ZhsSession session = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
            result.addVal(BaseVO.Session, new DtoSession().setStatus(LoginStatus.Logined).setVersion(session.getSessionKey()));
            result.addVal(BaseVO.Data, enterlst.get(0));
            log.info("登录成功");
        } else {
            result.addVal(BaseVO.Message, "登录失败");
            return result.toString();
        }
        return result.toString();
    }


    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp) {
        BaseVO result = new BaseVO().success();
        cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey())
                .setLoginStatus(LoginStatus.NoLogin).setLastSessionVersion();
        return result.toString();
    }



    @PostMapping(value = "checkloggedwithoutname")
    public String checkLoggedIfWithOutLonginName() {
        BaseVO result = new BaseVO().fail();
        LoginStatus loginStatus = enterupService.checkLogged();

        ZhsSession zhsSession= cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
        CheckLoggedResp checkLoggedResp=new CheckLoggedResp();
        result.addVal(BaseVO.Data,checkLoggedResp);
        SessionResp sessionRes=new SessionResp();
        result.addVal(BaseVO.Session,sessionRes);
        sessionRes.setVersion(zhsSession.getLastSessionVersion());
        if (null == loginStatus || LoginStatus.NoLogin == loginStatus ) {
            sessionRes.setStatus(LoginStatus.NoLogin.name());
        }else if(LoginStatus.Locked==loginStatus){
            result.addVal(BaseVO.Message,"超时锁定");
            sessionRes.setStatus(loginStatus.name());
        }else if(LoginStatus.Logined==loginStatus){
            result.success();
            sessionRes.setStatus(loginStatus.name());
        }
        return result.toString();
    }


}
