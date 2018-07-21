package cn.zhsit.common.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2017/7/2.
 */
public class ZhsClassUtil {

    public static List<Method> getMethodWithAnnotation(Class clazz, Class<? extends Annotation> annotationType) {
        List<Method> list = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation an = method.getDeclaredAnnotation(annotationType);
            if (null != an) {
                list.add(method);
            }
        }
        return list;
    }
}
