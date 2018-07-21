package cn.zhsit.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 实现MD5加密
 * Created by zhsit on 2016/8/20.
 */
public class ZhsMD5 {

    /**
     * 获取加密后的字符串
     *
     * @param text 原文
     * @param key  密钥
     * @return
     */
    public static String md5(String text, String key) {
        try {
            // 拿到一个MD5转换器
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 输入的字符串转换成字节数组
            byte[] inputByteArray = text.getBytes();
            // inputByteArray是输入字符串转换得到的字节数组
            messageDigest.update(inputByteArray);
            // 转换并返回结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest(key.getBytes());
            // 字符数组转换成字符串返回
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }


    /**
     * 获取加密后的字符串
     *
     * @param text 原文
     * @return 32 位长度字符串
     */
    public static String md5(String text) {
        try {
            // 拿到一个MD5转换器
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 输入的字符串转换成字节数组
            byte[] inputByteArray = text.getBytes();
            // inputByteArray是输入字符串转换得到的字节数组
            messageDigest.update(inputByteArray);
            // 转换并返回结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
            // 字符数组转换成字符串返回
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * md5 两次
     * @param text
     * @return
     */
    public static String md5Twice(String text){
//        String md5Once = md5(text);
        //密码 20170423
        String md5Once = md5(text).substring(2)+"www.zhsit.cn";
        return md5(md5Once);
    }

    /**
     * 用户密码加密
     * @param text
     * @return
     */
    public static String pwd(String text){
        return md5Twice(text).substring(2);
    }
    private static String byteArrayToHex(byte[] byteArray) {

        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray = new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }

}
