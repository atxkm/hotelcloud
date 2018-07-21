package cn.zhsit.controllers.pc;

import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.authority.services.PersonAuthorityService;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.common.handlers.ZhsContextHandler;
import cn.zhsit.common.models.DtoSession;
import cn.zhsit.common.utils.ZhsErrorsUtil;
import cn.zhsit.models.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by Darren on 2017/7/11.
 */
@RestController
@RequestMapping("person")
public class PersonAuthorityController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private PersonAuthorityService personAuthorityService;

    @PostMapping(value = "login")
    public String login(@Valid @RequestBody LoginReq login, Errors errors) throws Exception {
        BaseVO result = new BaseVO().fail();
        if (errors.hasErrors()) {
            result.addVal(BaseVO.Message, ZhsErrorsUtil.getMessage(errors));
            return result.toString();
        }
        if (!personAuthorityService.checkPwd(login, errors)) {
            result.addVal(BaseVO.Message, ZhsErrorsUtil.getMessage(errors));
            return result.toString();
        } else {
            result.success();
            ZhsSession session = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
            result.addVal(BaseVO.Session, new DtoSession().setStatus(LoginStatus.Logined).setVersion(session.getSessionKey()));
            result.addVal(BaseVO.Data, personAuthorityService.findPersonAuthority(session.getPersonId()));
            log.info("登录成功");
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
//
//    @Deprecated
//    @PostMapping(value = "checklogged")
//    public String checkLoggedIf(@Valid @RequestBody CheckLoggedReq check, Errors errors) {
//        BaseVO result = new BaseVO().fail();
//        if (errors.hasErrors()) {
//            result.addVal(BaseVO.Message, ZhsErrorsUtil.getMessage(errors));
//            return result.toString();
//        }
//        ZhsSession zhsSession= cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
//        LoginStatus loginStatus = personAuthorityService.checkLogged(check, errors);
//        CheckLoggedResp checkLoggedResp=new CheckLoggedResp();
//        result.addVal(BaseVO.Data,checkLoggedResp);
//        SessionResp sessionRes=new SessionResp();
//        result.addVal(BaseVO.Session,sessionRes);
//        sessionRes.setVersion(zhsSession.getLastSessionVersion());
//
//        if (null == loginStatus || LoginStatus.NoLogin == loginStatus ) {
//            sessionRes.setStatus(LoginStatus.NoLogin.name());
//        }else if(LoginStatus.Locked==loginStatus){
//            sessionRes.setStatus(loginStatus.name());
//            result.addVal(BaseVO.Message,"超时锁定");
//        }else if(LoginStatus.Logined==loginStatus){
//            result.success();
//            sessionRes.setStatus(loginStatus.name());
//        }
//
//        return result.toString();
//    }


    @PostMapping(value = "checkloggedwithoutname")
    public String checkLoggedIfWithOutLonginName() {
        BaseVO result = new BaseVO().fail();
        LoginStatus loginStatus = personAuthorityService.checkLogged();

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
