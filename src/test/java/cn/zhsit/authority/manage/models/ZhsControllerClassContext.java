package cn.zhsit.authority.manage.models;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 2017/7/2.
 */
public enum ZhsControllerClassContext {
    instance;

    //配置
    private ConfigGlobalAuthority configGlobalAuthority=new ConfigGlobalAuthority();
    private final List<ClassWrapper> controllerClassWrapperList = new ArrayList<>();

    public ConfigGlobalAuthority getConfigGlobalAuthority() {
        return configGlobalAuthority;
    }

    public ZhsControllerClassContext setConfigGlobalAuthority(ConfigGlobalAuthority configGlobalAuthority) {
        this.configGlobalAuthority = configGlobalAuthority;
        return this;
    }

    public List<ClassWrapper> getControllerClassWrapperList() {
        return controllerClassWrapperList;
    }


    /**
     * 当类不存在时将类添加到上下文中
     * @param clazz
     */
    public ClassWrapper addControllerClassIfNotExist(Class clazz) {
        for (ClassWrapper classWrapper : controllerClassWrapperList) {
            if(classWrapper.clazz.getName().equals(clazz.getName())){
               return classWrapper;
            }
        }
        ClassWrapper classWrapper=new ClassWrapper();
        classWrapper.clazz=clazz;
        controllerClassWrapperList.add(classWrapper);
        return classWrapper;
    }

    /**
     *
     * @param clazz
     * @param rm
     */
    public void addRequestMapping(Class clazz, RequestMapping rm){
        ClassWrapper classWrapper= addControllerClassIfNotExist(clazz);
        classWrapper.requestMapping=rm;
    }
}
