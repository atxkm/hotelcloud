package cn.zhsit.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 随机工具类
 */
public class ZhsRandomUtil {

    public final static String[] numArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public final static char[] charArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z'};
    public final static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public final static Random random = new Random();

    //生成8位数字与字母组合的字符串
    public static String getNumAndChar(int n){
        int charCount = random.nextInt(n-1);
        if(charCount<1){
            charCount=1;
        }
        int numCount = n-charCount;
        String chars=getRandomChar(charCount);
        String nums=getRandomNum(numCount);
        String str=chars+nums;
        return mix(str);
    }

    //将字符串中的字符顺序混淆
    public static String mix(String str){
        int length=str.length();
        List<String> list=new ArrayList();
        for (int i= 0;i<length;i++){
            list.add(str.substring(i, i + 1));
        }
        Collections.shuffle(list);
        StringBuilder sb=new StringBuilder();
        for(String s:list){
            sb.append(s);
        }
        return sb.toString();
    }
    //将字符串中的字符顺序混淆
    public static String mix(List<String> list){
        Collections.shuffle(list);
        StringBuilder sb=new StringBuilder();
        for(String s:list){
            sb.append(s);
        }
        return sb.toString();
    }
    //获取随机n个字母
    public static String getRandomChar(int i){
        String randChar="";
        for(int k=0;k<i;k++){
            randChar +=charArray[new Random().nextInt(charArray.length)];
        }
        return randChar;
    }

    /**
     * 生成num位的随机数
     *
     * @param num 要随机生成的位数
     * @return
     */
    public static String getRandomNum(int num) {
        String rand = "";
        for (int i = 0; i < num; i++) {
            rand += numArray[new Random().nextInt(numArray.length)];
        }
        return rand;
    }

    /**
     * 生成不多于n位的随机数
     *
     * @param n
     * @return
     */
    public static String getNoMoreBitRandomNum(int n) {
        int num = random.nextInt(n);
        return getRandomNum(num);
    }

    /**
     * 生成不大于
     *
     * @param max
     * @return
     */
    public static int noGreaterThan(int max) {
        return random.nextInt(max);
    }

}
