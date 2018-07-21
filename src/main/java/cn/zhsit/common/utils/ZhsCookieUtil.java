package cn.zhsit.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darren on 2017/7/8.
 */
public class ZhsCookieUtil {
    private static Logger log = LoggerFactory.getLogger(ZhsCookieUtil.class);


    /**
     * 将cookie封装到Map里面
     *
     * @param req
     * @return
     */
    public static Map<String, Cookie> readCookieMap(HttpServletRequest req) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = req.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
//                log.info("cookie name:{} -->value:{}", cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }

    /**
     * 写cookie，含过期时间
     *
     * @param req
     * @param resp
     * @param cookieName
     * @param cookieVal
     * @param expiry     过期时间,秒
     * @return
     */
    public static boolean writeCookie(HttpServletRequest req, HttpServletResponse resp, String cookieName, String cookieVal, int expiry) {
        Cookie cookie = new Cookie(cookieName, cookieVal);
        cookie.setPath("/");
        cookie.setMaxAge(expiry);
        cookie.setHttpOnly(true);
        cookie.setDomain(ZhsIpDomainUtil.getClientDomain(req));
        resp.addCookie(cookie);
        return true;
    }

    /**
     * 写cookie，无过期时间
     *
     * @param req
     * @param resp
     * @param cookieName
     * @param cookieVal
     * @return
     */
    public static boolean writeCookie(HttpServletRequest req, HttpServletResponse resp, String cookieName, String cookieVal) {
        Cookie cookie = new Cookie(cookieName, cookieVal);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setDomain(ZhsIpDomainUtil.getClientDomain(req));
        resp.addCookie(cookie);
        return true;
    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            return (Cookie) cookieMap.get(name);
        } else {
            return null;
        }
    }


    /**
     * 根据名字获取cookie值
     *
     * @param req
     * @param name cookie名字
     * @return
     */
    public static String getCookieValueByName(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
