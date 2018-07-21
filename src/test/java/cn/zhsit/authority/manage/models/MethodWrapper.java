package cn.zhsit.authority.manage.models;

import cn.zhsit.authority.annotations.Authority;
import cn.zhsit.authority.annotations.Menu;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * Created by Darren on 2017/7/2.
 * 方法包装
 */
public class MethodWrapper {
    //映射路径，包含Class路径+Method路径
    public String requestMappingPath;
    public Method method;
    public Authority authority;
    public Menu menu;
    public RequestMapping requestMapping;
    //注解列表
//    public List<AnnotationWrapper> annotationWrapperList = new ArrayList<>();
}
