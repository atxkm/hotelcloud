package cn.zhsit.common.utils;

import cn.zhsit.common.enums.DeviceType;
import cn.zhsit.common.enums.OSType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Darren on 2017/7/10.
 * 判断客户端设备类型
 */
public class ZhsDeviceUtil {
    private static Logger log = LoggerFactory.getLogger(ZhsDeviceUtil.class);
    public static final String CPU2 = "dmidecode | grep 'Serial Number'";

    public static DeviceType device(HttpServletRequest request) {
        String[] mobileAgents = {"iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
                "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
                "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
                "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
                "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
                "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
                "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
                "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
                "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
                "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
                "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
                "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
                "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
                "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
                "Googlebot-Mobile"};
        if (request.getHeader("User-Agent") != null) {
            String userAgent = request.getHeader("User-Agent").toLowerCase();
            for (String mobileAgent : mobileAgents) {
                if (userAgent.indexOf(mobileAgent) >= 0) {
                    return DeviceType.Mobile;
                }
            }
        }
        return DeviceType.Default;
    }


    /**
     * 判断是linux还是windows
     *
     * @return
     */
    public static String unique() {
        String unique = null;
        OSType os = ZhsOSUtil.osType();
        switch (os) {
            case Windows:
                unique = windowsSerial();
                break;
            case Linux:
                unique = linuxSerial();
                break;
            default:
                unique = "zhsit.cn";
        }
        return ZhsMD5.md5Twice(unique);
    }

    private static String linuxSerial() {
//        Serial Number
        String serial = "zhsit.cn";
        try {
            Process process = Runtime.getRuntime().exec(CPU2);
            InputStream is = null;
            InputStreamReader isr = null;
            BufferedReader buffer = null;
            String line = null;
            is = process.getInputStream();
            isr = new InputStreamReader(is);
            buffer = new BufferedReader(isr);
            while ((line = buffer.readLine()) != null) {
                String ll = line.toLowerCase();
                log.info("获取的设备信息{}", line);
                if (ll.contains("uuid")) {
                    serial=ll;
                    break;
                }
                if (line.contains("Final Memory:")) {
                    break;
                }
            }
            process.getOutputStream().flush();
            log.info("执行脚本结束");
        } catch (Exception e) {
            log.error("获取linux设备信息时异常");
        }
        return serial;
    }

    private static String windowsSerial() {
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"wmic", "cpu", "get", "ProcessorId"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String property = sc.next();
            String serial = sc.next();
            log.info("获取的cpu信息" + property + ": " + serial);
            return serial;
        } catch (Exception e) {
            log.info("获取windows序号时异常");
        }
        return "zhsit.cn";
    }
}
