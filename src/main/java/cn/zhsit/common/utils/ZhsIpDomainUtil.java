package cn.zhsit.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Darren on 2017/7/9.
 */
public class ZhsIpDomainUtil {
    private static Logger log = LoggerFactory.getLogger(ZhsCookieUtil.class);

    public static String getClientDomain(HttpServletRequest request) {
        String domain = "";
        String domainHost = request.getServerName();
        try {
            if (domainHost!=null && domainHost.trim().length()>0) {
                if (domainHost.equals("localhost")) {
                    domain = domainHost;
                } else {
                    String[] segments = domainHost.split("\\.");
                    if (segments.length > 1) {
                        if (ZhsNumberUtil.isNumeric(segments[segments.length - 1])) { //是否是ip地址
                            domain = domainHost;
                        } else {
                            domain = segments[segments.length - 2] + "." + segments[segments.length - 1];
                            if (domain.contains("com.cn")
                                    ||domain.contains("gov.cn")
                                    ||domain.contains("net.cn")
                                    ||domain.contains("org.cn")
                                    ||domain.contains("ac.cn")
                                    ) {
                                domain = segments[segments.length - 3] + "." + segments[segments.length - 2] + "." + segments[segments.length - 1];
                            }
                        }
                    } else {
                        domain = domainHost;
                    }
                }
            }
        } catch (Exception e) {
            domain = domainHost;
        }
        return domain;
    }

    //获取客户的ip
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
