package cn.zhsit.common.utils;

import java.lang.reflect.Field;


public class ZhsReflectUtil {

    /**
     * 注意：只能设置本类属性的值
     *
     * @param obj
     * @param propertyName
     * @param newVal
     */
    public static void setFieldValue(Object obj, String propertyName, Object newVal) {
        Class clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            boolean fieldAccessible = field.isAccessible();
            field.setAccessible(true);
            try {
                if (field.getName().equals(propertyName)) {
                    field.set(obj, newVal);
                    break;
                }
            } catch (Throwable throwable) {
                System.err.println("ZhsReflectUtil.setFieldValue  error,name:" + clazz.getName() + ",propertyName:" + propertyName + ",newVal:" + newVal);
            } finally {
                field.setAccessible(fieldAccessible);
            }
        }
    }

    /**
     * 注意：只能获取本类、父类、爷级类属性的值,不能获取更高别类的属性值
     *
     * @param obj
     * @param propertyName
     * @return
     */
    public static Object getFieldValue(final Object obj, final String propertyName) {
        Class clazz = obj.getClass();
        {
            Object val = getFieldVal(clazz, obj, propertyName);
            if (null != val) {
                return val;
            }
        }
        clazz = clazz.getSuperclass();
        {
            if (null != clazz) {
                Object val = getFieldVal(clazz, obj, propertyName);
                if (null != val) {
                    return val;
                }
            }
        }
        clazz = clazz.getSuperclass();
        {
            if (null != clazz) {
                Object val = getFieldVal(clazz, obj, propertyName);
                if (null != val) {
                    return val;
                }
            }
        }
        return null;
    }

    public static Object getFieldVal(final Class clazz, final Object obj, final String propertyName) {
        for (Field field : clazz.getDeclaredFields()) {
            boolean fieldAccessible = field.isAccessible();
            field.setAccessible(true);
            try {
                if (field.getName().equals(propertyName)) {
                    return field.get(obj);
                }
            } catch (Throwable throwable) {
                System.err.println("ZhsReflectUtil.getObject  error,name:" + clazz.getName() + ",propertyName:" + propertyName);
            } finally {
                field.setAccessible(fieldAccessible);
            }
        }
        return null;
    }

}
