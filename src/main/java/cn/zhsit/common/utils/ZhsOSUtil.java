package cn.zhsit.common.utils;

import cn.zhsit.common.enums.OSType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Darren on 2017/8/21.
 */
public class ZhsOSUtil {
    private static Logger log = LoggerFactory.getLogger(ZhsOSUtil.class);

    //        Linux
    //        Windows 7
    public static OSType osType() {
        String osName = System.getProperty("os.name").toLowerCase();
        log.info("os.name:" + osName);
        if (osName.contains("windows")) {
            return OSType.Windows;
        } else if (osName.contains("linux")){
            return OSType.Linux;
        }
        return OSType.Default;
    }

//
//    public static void main(String[] args) {
//        osType();
//    }

    public static String getSerNo() {
        try {
            long start = System.currentTimeMillis();
            Process process = Runtime.getRuntime().exec(
                    new String[]{"wmic", "cpu", "get", "ProcessorId"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String property = sc.next();
            String serial = sc.next();
            System.out.println(property + ": " + serial);
            System.out.println("time:" + (System.currentTimeMillis() - start));
            return serial;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static void main8(String [] args){
        System.out.print(getSerNo());
    }

}
