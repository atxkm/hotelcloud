package cn.zhsit.authority.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Darren on 2017/7/1.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Login
public @interface Authority {
    //权限码(请全部用英文字母和数字),每个方法对应的权限名称不要重复
    String code();
    //权限组
    String group() default "";
    //权限描述
    String descr() default "";
}
