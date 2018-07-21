package cn.zhsit.common.utils;

import org.apache.commons.codec.language.Soundex;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Administrator on 2017/10/29.
 */
public class ZhsErrorsUtil {

    /**
     * 分号分隔，句号结束。
     * @param errors
     * @return
     */
    public static String getMessage(Errors errors) {
        StringBuilder sb = new StringBuilder();
        List<ObjectError> objectErrors=errors.getAllErrors();
        for (ObjectError error : objectErrors) {
            sb.append(error.getDefaultMessage()).append(";");
        }
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length() - 1);
            sb.append("。");
        }
        return sb.toString();
    }
}
