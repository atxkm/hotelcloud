package cn.zhsit.authority.manage.models;

import cn.zhsit.authority.api.models.AuthorityModel;
import cn.zhsit.authority.api.models.MenuModel;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2017/7/2.
 * 类包装
 */
public class ClassWrapper {
    public RequestMapping requestMapping;
    public String requestMappingPath;
    //类
    public Class clazz;
    //方法列表
    public List<MethodWrapper> methodWrapperList = new ArrayList<>();
    //属性列表
    public List<FieldWrapper> fieldWrapperList = new ArrayList<>();
    //注解列表
//    public List<AnnotationWrapper> annotationWrapperList = new ArrayList<>();

    //权限列表
    public List<AuthorityModel> authorityModelList = new ArrayList<>();

    //菜单列表
    public List<MenuModel> menuModelList = new ArrayList<>();


    public MethodWrapper addMethodIfNotExist(Method method){
        for (MethodWrapper methodWrapper : methodWrapperList) {
            if (methodWrapper.method.toString().equals(method.toString())) {
                return methodWrapper;
            }
        }
        MethodWrapper methodWrapper=new MethodWrapper();
        methodWrapper.method=method;
        methodWrapperList.add(methodWrapper);
        return methodWrapper;
    }
}
