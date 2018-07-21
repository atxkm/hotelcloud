package cn.zhsit.authority.interceptors;

import cn.zhsit.common.constants.ZhsConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhsit on 2016/8/19.
 */
@Component
public class CharacterEncodingInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setCharacterEncoding(ZhsConstants.UTF8);
        response.setCharacterEncoding(ZhsConstants.UTF8);
       response.setHeader("Access-Control-Allow-Origin","*");
      //  response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
    //    response.setHeader("Access-Control-Allow-Credentials","true");
    //    response.setHeader("Access-Control-Allow-Methods","*");
//        response.setHeader("Access-Control-Allow-Headers ","*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
        //Accept, Origin, XRequestedWith, Content-Type, LastModified
        return true;
    }

}
