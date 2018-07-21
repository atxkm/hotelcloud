package cn.zhsit.authority.manage.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Darren on 2017/7/9.
 * 虚拟controller
 * 1.用于定义前端非通过controller进行跳转的菜单
 * 2.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ZhsVirtualController {
}
