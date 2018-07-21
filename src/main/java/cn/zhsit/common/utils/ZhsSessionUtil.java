package cn.zhsit.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhsit on 2016/8/19.
 */
public class ZhsSessionUtil {

    /**
     * 获取session中的值
     *
     * @param request
     * @param key
     * @return
     */
    public static Object getSessionVal(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return session.getAttribute(key);
    }

    /**
     * 生成随机数设置到session，并从session中获取此值
     *
     * @param request
     * @param key
     * @return
     */
    public static Object setAndGetSessionVal(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        String token = ZhsRandomUtil.getRandomNum(18);
        session.setAttribute(key, token);
        return session.getAttribute(key);
    }

    /**
     * 使用UUID设置token值，并存放到Session中
     *
     * @param request
     * @param key
     * @return
     */
    public static Object setAndGetSessionTokenVal(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        String token = ZhsUnique.unique25();
        session.setAttribute(key, token);
        return session.getAttribute(key);
    }

    /**
     * 将值存入到session中
     *
     * @param request
     * @param key
     * @param val
     * @return
     */
    public static boolean setSessionVal(HttpServletRequest request, String key, Object val) {
        HttpSession session = request.getSession();
        if (null == session) {
            return false;
        }
        session.setAttribute(key, val);
        return true;
    }

    public static boolean setIfNotExist(HttpServletRequest request, String key) {
        Object val = getSessionVal(request, key);
        if (null == val) {
            HttpSession session = request.getSession();
            if (null == session) {
                return false;
            }
            String sessionKey = ZhsRandomUtil.getRandomNum(15);
            session.setAttribute(key, sessionKey);
        }
        return true;
    }

    public static boolean setIfNotExistSession(HttpServletRequest request, String key) {
        Object val = getSessionVal(request, key);
        if (null == val) {
            HttpSession session = request.getSession();
            if (null == session) {
                return false;
            }
            String sessionKey = ZhsUnique.unique25();
            session.setAttribute(key, sessionKey);
        }
        return true;
    }

    /**
     * 从session中移除值
     *
     * @param request
     * @param key
     * @return
     */
    public static boolean removeSessionVal(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        if (null == session) {
            return true;
        }
        session.removeAttribute(key);
        return true;
    }

    /**
     * 从session中获取值，并将其从session中删除
     *
     * @param request
     * @param key
     * @return
     */
    public static Object getAndRemoveSessionVal(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        Object o = session.getAttribute(key);
        session.removeAttribute(key);
        return o;
    }


    /**
     * 获取HttpSession的ID
     * @param request
     * @return
     */
    public static String getSessionId(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        return httpSession.getId();
    }
}
