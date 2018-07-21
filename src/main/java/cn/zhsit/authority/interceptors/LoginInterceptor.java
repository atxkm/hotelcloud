package cn.zhsit.authority.interceptors;

import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.authority.interceptors.models.Msg;
import cn.zhsit.authority.interceptors.models.ZhsSession;
import cn.zhsit.authority.managers.PersonAuthorityManager;
import cn.zhsit.common.configs.ZhsConfig;
import cn.zhsit.common.enums.DeviceType;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.common.handlers.ZhsContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Darren on 2017/7/7.
 * 验证是否登录拦截器,判断登录超时
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    @Autowired
    private PersonAuthorityManager personAuthorityManager;
    @Autowired
    private ZhsConfig zhsConfig;
    @Autowired
    private CacheHelper cacheHelper;

    //验证是否登录拦,判断登录超时
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //验证超时验证
        ZhsSession session = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
        LoginStatus loginStatus = session.checkLoginStatus(zhsConfig.getExpirySecond());
//        if (1 == 1) {//TODO 这里是模拟数据(模拟登录功能)
//            session.setLoginStatus(ZhsSession.LoginStatus.Logged);
//            PersonAuthority p= personAuthorityManager.selectByLoginName("feng");
//            if(null!=p){
//                session.setPersonId(p.getId());
//            }
//            return true;
//        }
        if (loginStatus == LoginStatus.Logined) {
            return true;
        }
        goLogin(req, resp);
        return false;
    }

    //去登录
    private void goLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String loginUrl = null;
        ZhsSession session = cacheHelper.getSession(ZhsContextHandler.instance.getSessionKey());
        if (session.getDeviceType() == DeviceType.Mobile) {
            if (session.getPersonId() == null) {
                loginUrl = zhsConfig.getMobileLoginUrl();
            } else {
                //TODO 当用户在此次浏览器打开后登录过,只是超时，需要输入密码，但不需要输入用户名
                throw new RuntimeException("当用户在此次浏览器打开后登录过,只是超时，需要输入密码，但不需要输入用户名 拦截器部分尚为进行配置");
            }
        } else {
            if (session.getPersonId() == null) {
                loginUrl = zhsConfig.getPcLoginUrl();
            } else {
                //TODO 当用户在此次浏览器打开后登录过,只是超时，需要输入密码，但不需要输入用户名
                throw new RuntimeException("当用户在此次浏览器打开后登录过,只是超时，需要输入密码，但不需要输入用户名 拦截器部分尚为进行配置");
            }
        }

        //ajax请求未登陆 则返回跳转登陆页面的报文
        if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
            Msg msg = new Msg();
            msg.ajaxGo();
            msg.addVal("zhsGoUrl", request.getContextPath() + loginUrl);
            msg.addVal("msg", "请登录");
            response.getWriter().print(msg.toJson());
            return;
        }
        response.sendRedirect(request.getContextPath() + loginUrl);
    }

}
