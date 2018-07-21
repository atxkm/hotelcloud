package cn.zhsit.controllers;

import cn.zhsit.authority.api.models.ConstantsAuthority;
import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.enums.DeviceType;
import cn.zhsit.common.handlers.ZhsContextHandler;
import cn.zhsit.common.utils.ZhsCookieUtil;
import cn.zhsit.common.utils.ZhsSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Darren on 2017/7/24.
 */
@Controller
public class RootController {
    @Autowired
    private CacheHelper cacheHelper;

    @RequestMapping("/")
    public String toIndex(HttpServletRequest request){
        String sessionKey = ZhsCookieUtil.getCookieValueByName(request, ConstantsAuthority.ZhsLoginCookieName);
        if ((sessionKey == null)) {
            sessionKey = ZhsSessionUtil.getSessionId(request);
        }
        ZhsContextHandler.instance.setSessionKey(sessionKey);
        ZhsSession session = cacheHelper.getSession(sessionKey);
        if(session.getDeviceType()== DeviceType.Mobile){
//            return "forward:/m/index";
            return "redirect:/mobile/index.html";
        }
//        return "forward:/p/index";
        return "redirect:/app/index.html";
    }

}
