package cn.zhsit.authority.interceptors;

import cn.zhsit.authority.annotations.Authority;
import cn.zhsit.authority.api.ApiServiceAuthority;
import cn.zhsit.authority.api.models.AuthorityModel;
import cn.zhsit.authority.api.models.Person;
import cn.zhsit.authority.api.models.Wrapper;
import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.Msg;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.common.configs.ZhsConfig;
import cn.zhsit.common.enums.DeviceType;
import cn.zhsit.common.handlers.ZhsContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Darren on 2017/7/7.
 * 权限判断拦截
 */
@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(AuthorityInterceptor.class);
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private ApiServiceAuthority apiServiceAuthority;
    @Autowired
    private ZhsConfig zhsConfig;
//    private String noAuthorityPcUrl;
//    private String noAuthorityMobileUrl;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!((HandlerMethod) handler).hasMethodAnnotation(Authority.class)) {
            return true;
        }
        Authority authority = ((HandlerMethod) handler).getMethodAnnotation(Authority.class);
        ZhsSession session= cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
        Person person = new Person().setId(session.getPersonId());
        AuthorityModel authorityModel = new AuthorityModel().setCode(authority.code());
        Wrapper wrapper= apiServiceAuthority.checkAuthority(person, authorityModel);
        if(Boolean.TRUE==wrapper.getSuccess()){
            return true;
        }
        respNoAuthority(request, response);
        return false;
    }

    private void respNoAuthority(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String toUrl = null;
        ZhsSession session = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
        if (session.getDeviceType() == DeviceType.Mobile) {
            toUrl =zhsConfig.getNoAuthorityMobileUrl() ;
        } else {
            toUrl = zhsConfig.getNoAuthorityPcUrl();
        }

        //ajax请求未登陆 则返回跳转登陆页面的报文
        if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
            Msg msg = new Msg();
            msg.ajaxGo();
            msg.addVal("zhsGoUrl", request.getContextPath() + toUrl);
            msg.addVal("msg", "无此权限");
            response.getWriter().print(msg.toJson());
            return;
        }
        response.sendRedirect(request.getContextPath() + toUrl);
    }


//    public AuthorityInterceptor setNoAuthorityPcUrl(String noAuthorityPcUrl) {
//        this.noAuthorityPcUrl = noAuthorityPcUrl;
//        return this;
//    }
//
//    public AuthorityInterceptor setNoAuthorityMobileUrl(String noAuthorityMobileUrl) {
//        this.noAuthorityMobileUrl = noAuthorityMobileUrl;
//        return this;
//    }
}
