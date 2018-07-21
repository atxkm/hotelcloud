package cn.zhsit.authority.interceptors;

import cn.zhsit.authority.api.models.ConstantsAuthority;
import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.handlers.ZhsContextHandler;
import cn.zhsit.common.utils.ZhsCookieUtil;
import cn.zhsit.common.utils.ZhsDeviceUtil;
import cn.zhsit.common.utils.ZhsSessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Darren on 2017/7/7.
 * 拦截所有请求，包括静态资源请求，进行区分是手机设备还是PC设备
 */
@Component
public class DeviceInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(DeviceInterceptor.class);
    @Autowired
    private CacheHelper cacheHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionKey = ZhsCookieUtil.getCookieValueByName(request, ConstantsAuthority.ZhsLoginCookieName);
        if ((sessionKey == null)) {
            sessionKey = ZhsSessionUtil.getSessionId(request);
            ZhsCookieUtil.writeCookie(request, response,  ConstantsAuthority.ZhsLoginCookieName,sessionKey);
        }
        ZhsContextHandler.instance.setSessionKey(sessionKey);
        ZhsSession session = cacheHelper.getSession(sessionKey);
        if (session.getDeviceType() == null) {
            session.setDeviceType(ZhsDeviceUtil.device(request));
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ZhsContextHandler.instance.clear();
    }
}
