package cn.zhsit.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Darren on 2017/7/9.
 */
public class ZhsNumberUtil {

//    1.用JAVA自带的函数
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }



//    2.用正则表达式
//    表达式修改为“^-?[0-9]+”即可，修改为“-?[0-9]+.?[0-9]+”即可匹配所有数字。
    public static boolean isNumericWithMatcher(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

}
