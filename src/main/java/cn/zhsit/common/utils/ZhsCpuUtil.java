package cn.zhsit.common.utils;

import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.Sigar;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Darren on 2017/8/21.
 */
public class ZhsCpuUtil {
// 获得CPU ID
    public static final String CPU_ID_CMD = "dmidecode -t 4 | grep ID |sort -u |awk -F': ' '{print $2}'";

// 获得磁盘ID
    public static final String DISK_ID_CMD = "fdisk -l |grep \"Disk identifier\" |awk {'print $3'}";


    public static void main3(String[] args) throws IOException {
        System.getProperty("os.name");//得到操作系统名字
        System.getProperty("sun.os.patch.level");//得到操作系统版本
        long start = System.currentTimeMillis();
        Process process = Runtime.getRuntime().exec(CPU_ID_CMD);
        process.getOutputStream().close();

        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        System.out.println(property + ": " + serial);
        System.out.println("time:" + (System.currentTimeMillis() - start));
    }

    public static void main2(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Process process = Runtime.getRuntime().exec(
                new String[]{"wmic", "cpu", "get", "ProcessorId"});
        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        System.out.println(property + ": " + serial);
        System.out.println("time:" + (System.currentTimeMillis() - start));
    }


    public static String getCpuIdSer(){
        try {
            System.getProperty("os.name");//得到操作系统名字
            System.getProperty("sun.os.patch.level");//得到操作系统版本
            long start = System.currentTimeMillis();
            Process process = Runtime.getRuntime().exec(CPU_ID_CMD);
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String property = sc.next();
            String serial = sc.next();
            System.out.println(property + ": " + serial);
            System.out.println("time:" + (System.currentTimeMillis() - start));
            return serial;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getMAC() {
        Sigar sigar = null;
        try {
            sigar = new Sigar();
            String[] ifaces = sigar.getNetInterfaceList();
            String hwaddr = null;
            for (int i = 0; i < ifaces.length; i++) {
                NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
                if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress())
                        || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
                        || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
                    continue;
                }
                hwaddr = cfg.getHwaddr();
                break;
            }
            return hwaddr != null ? hwaddr : null;
        } catch (Exception e) {

                return null;

        } finally {
                sigar.close();
        }
    }

    public static void main9(String[] args) {
        System.out.println(getCpuIdSer());
    }
    public static void main8(String[] args) throws IOException {
        if(OSinfo.getOSname().name().indexOf("Mac")>=0){
            System.out.println(AuthorizationUtils.getMachine());
        }else {
            System.out.println(getCpuIdSer());
        }

        System.out.println(getSerialNum());
    }


    public static String getSerialNum(){
        if(OSinfo.getOSname().name().indexOf("Mac")>=0){
            return AuthorizationUtils.getMachine();
        }else {
            return getCpuIdSer();
        }
    }
}
