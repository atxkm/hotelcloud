package cn.zhsit.authority.manage;

import cn.zhsit.authority.annotations.Authority;
import cn.zhsit.authority.annotations.Menu;
import cn.zhsit.authority.api.models.AuthorityModel;
import cn.zhsit.authority.api.models.MenuModel;
import cn.zhsit.authority.api.models.Wrapper;
import cn.zhsit.authority.manage.annotations.ZhsVirtualController;
import cn.zhsit.authority.manage.models.*;
import cn.zhsit.common.utils.ZhsClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Darren on 2017/7/2.
 */
//@Component
public enum AuthorityHelper {
    instance;

    private ApplicationContext context;
    private static Logger log = LoggerFactory.getLogger(AuthorityHelper.class);

    public AuthorityHelper init(ApplicationContext context) {
        this.context = context;
        return this;
    }


    public boolean collect() {
        collectController();
        collectVirtualController();
        return true;
    }

    //收集虚拟Controller相关的设置
    public boolean collectVirtualController() {
        //创建view层菜单
        collectVirtualControllerClass();
        collectVirtualControllerMethodAuthority();
        collectVirtualControllerMethodMenu();
        createVirtualControllerAuthorityModel();
        createVirtualMenuModel();
        saveVirtualAuthorityModel();
        saveVirtualMenuModel();
        return true;
    }

    //收集controller相关的设置
    public boolean collectController() {
        collectConfig();
        collectControllerClass();
        collectControllerMethodAuthority();
        collectControllerMethodMenu();
        collectControllerMethodRequestMapping();
        collectControllerUrl();
        createControllerAuthorityModel();
        createMenuModel();
        saveAuthorityModel();
        saveMenuModel();
        ZhsControllerClassContext.instance.getControllerClassWrapperList();
        return true;
    }


    /**
     * 收集controller的类及类注解
     */
    private void collectVirtualControllerClass() {
        Map<String, Object> beans = context.getBeansWithAnnotation(ZhsVirtualController.class);
        beans.forEach((key, bean) -> {
            log.info("收集的类:" + bean.getClass().getName());
            ZhsVirtualControllerClassContext.instance.addControllerClassIfNotExist(bean.getClass());
        });
    }


    /**
     * 收集在方法上注解的权限点
     */
    private void collectVirtualControllerMethodAuthority() {
        List<ClassWrapper> classWrapperList = ZhsVirtualControllerClassContext.instance.getControllerClassWrapperList();
        classWrapperList.forEach(classWrapper -> {
            Class clazz = classWrapper.clazz;
            List<Method> methodList = ZhsClassUtil.getMethodWithAnnotation(clazz, Authority.class);
            methodList.forEach(method -> {
                MethodWrapper methodWrapper = classWrapper.addMethodIfNotExist(method);
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getName().equals(Authority.class.getName())) {
                        methodWrapper.authority = (Authority) annotation;
                    }
                }
            });
        });
    }


    /**
     * 收集在方法上注解的菜单
     */
    private void collectVirtualControllerMethodMenu() {
        List<ClassWrapper> classWrapperList = ZhsVirtualControllerClassContext.instance.getControllerClassWrapperList();
        classWrapperList.forEach(classWrapper -> {
            Class clazz = classWrapper.clazz;
            List<Method> methodList = ZhsClassUtil.getMethodWithAnnotation(clazz, Menu.class);
            methodList.forEach(method -> {
                MethodWrapper methodWrapper = classWrapper.addMethodIfNotExist(method);
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getName().equals(Menu.class.getName())) {
                        methodWrapper.menu = (Menu) annotation;
                    }
                }
            });
        });
    }


    /**
     * 创建权限传输对象
     */
    private void createVirtualControllerAuthorityModel() {
        List<ClassWrapper> classWrapperList = ZhsVirtualControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            if (classWrapper.methodWrapperList.size() < 1) {
                continue;
            }
            for (MethodWrapper methodWrapper : classWrapper.methodWrapperList) {
                if (null == methodWrapper.authority) {
                    continue;
                }
                AuthorityModel model = new AuthorityModel();
                model.setUrl(methodWrapper.requestMappingPath);
                model.setCode(methodWrapper.authority.code());
                model.setDescr(methodWrapper.authority.descr());
                if (methodWrapper.authority.group().length() > 0) {
                    model.setAuthorityGroup(methodWrapper.authority.group());
                }
                model.setAuthorityType((byte) 3);
                classWrapper.authorityModelList.add(model);
            }
        }
    }


    /**
     * 创建菜单传输对象
     */
    private void createVirtualMenuModel() {
        List<ClassWrapper> classWrapperList = ZhsVirtualControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            if (classWrapper.methodWrapperList.size() < 1) {
                continue;
            }
            for (MethodWrapper methodWrapper : classWrapper.methodWrapperList) {
                if (null == methodWrapper.menu) {
                    continue;
                }
                MenuModel model = new MenuModel();
                model.setShowChars(methodWrapper.menu.menuShow());
                if (null == methodWrapper.authority) {
                    throw new RuntimeException("菜单注解的方法未设置权限注解");
                }
                model.setAuthorityName(methodWrapper.authority.code());
                classWrapper.menuModelList.add(model);
            }
        }
    }

    //将权限保存到数据库中
    private void saveVirtualAuthorityModel() {
        List<AuthorityModel> list = new ArrayList<>();
        ManageServiceAuthority ms = context.getBean(ManageServiceAuthority.class);
        List<ClassWrapper> classWrapperList = ZhsVirtualControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            List<AuthorityModel> authorityModelList = classWrapper.authorityModelList;
            list.addAll(authorityModelList);
        }
        Wrapper<List<AuthorityModel>> wrapper = new Wrapper<>(list, Wrapper.Opera.Add);
        ms.authorityOpera(wrapper);
    }


    //将菜单保存到数据库中
    private void saveVirtualMenuModel() {
        List<MenuModel> list = new ArrayList<>();
        ManageServiceAuthority ms = context.getBean(ManageServiceAuthority.class);
        List<ClassWrapper> classWrapperList = ZhsVirtualControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            List<MenuModel> menuModelList = classWrapper.menuModelList;
            list.addAll(menuModelList);
        }
        Wrapper<List<MenuModel>> wrapper = new Wrapper<>(list, Wrapper.Opera.Add);
        ms.menuOpera(wrapper);
    }


    /////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建权限传输对象
     */
    private void collectControllerUrl() {
        List<ClassWrapper> classWrapperList = ZhsControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            url(classWrapper);
        }
    }

    /**
     * 创建权限传输对象
     */
    private void createControllerAuthorityModel() {
        List<ClassWrapper> classWrapperList = ZhsControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            if (classWrapper.methodWrapperList.size() < 1) {
                continue;
            }
            for (MethodWrapper methodWrapper : classWrapper.methodWrapperList) {
                if (null == methodWrapper.authority) {
                    continue;
                }
                AuthorityModel model = new AuthorityModel();
                model.setUrl(methodWrapper.requestMappingPath);
                model.setCode(methodWrapper.authority.code());
                model.setDescr(methodWrapper.authority.descr());
                if (methodWrapper.authority.group().length() > 0) {
                    model.setAuthorityGroup(methodWrapper.authority.group());
                }
                model.setAuthorityType((byte) 1);
                if (null != methodWrapper.menu) {
                    model.setAuthorityType((byte) 2);
                }
                classWrapper.authorityModelList.add(model);
            }
        }
    }


    /**
     * 创建菜单传输对象
     */
    private void createMenuModel() {
        List<ClassWrapper> classWrapperList = ZhsControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            if (classWrapper.methodWrapperList.size() < 1) {
                continue;
            }
            for (MethodWrapper methodWrapper : classWrapper.methodWrapperList) {
                if (null == methodWrapper.menu) {
                    continue;
                }
                MenuModel model = new MenuModel();
                model.setShowChars(methodWrapper.menu.menuShow());
                if (null == methodWrapper.authority) {
                    throw new RuntimeException("菜单注解的方法未设置权限注解");
                }
                model.setAuthorityName(methodWrapper.authority.code());
                classWrapper.menuModelList.add(model);
            }
        }
    }

    //获取访问路径
    private void url(ClassWrapper classWrapper) {
        String classUrl = "";
        if (null != classWrapper.requestMapping) {
            if (classWrapper.requestMapping.value().length > 0) {
                classUrl += classWrapper.requestMapping.value()[0];
                classWrapper.requestMappingPath = classUrl;
            }
        }

        List<MethodWrapper> methodWrapperList = classWrapper.methodWrapperList;
        if (methodWrapperList.size() < 1) {
            return;
        }

        for (MethodWrapper methodWrapper : methodWrapperList) {
            String methodUrl = classUrl;
            if (null != methodWrapper.requestMapping) {
                if (methodWrapper.requestMapping.value().length > 0) {
                    methodUrl += methodWrapper.requestMapping.value()[0];
                    methodWrapper.requestMappingPath = methodUrl;
                }
            }
        }
    }

    //将权限保存到数据库中
    private void saveAuthorityModel() {
        List<AuthorityModel> list = new ArrayList<>();
        ManageServiceAuthority ms = context.getBean(ManageServiceAuthority.class);
        List<ClassWrapper> classWrapperList = ZhsControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            List<AuthorityModel> authorityModelList = classWrapper.authorityModelList;
            list.addAll(authorityModelList);
        }
        Wrapper<List<AuthorityModel>> wrapper = new Wrapper<>(list, Wrapper.Opera.Add);
        ms.authorityOpera(wrapper);
    }

    //将菜单保存到数据库中
    private void saveMenuModel() {
        List<MenuModel> list = new ArrayList<>();
        ManageServiceAuthority ms = context.getBean(ManageServiceAuthority.class);
        List<ClassWrapper> classWrapperList = ZhsControllerClassContext.instance.getControllerClassWrapperList();
        for (ClassWrapper classWrapper : classWrapperList) {
            List<MenuModel> menuModelList = classWrapper.menuModelList;
            list.addAll(menuModelList);
        }
        Wrapper<List<MenuModel>> wrapper = new Wrapper<>(list, Wrapper.Opera.Add);
        ms.menuOpera(wrapper);
    }

    /**
     * 收集配置信息
     */
    private void collectConfig() {
        ConfigGlobalAuthority configGlobalAuthority = (ConfigGlobalAuthority) context.getBean(ConfigGlobalAuthority.class);
        ZhsControllerClassContext.instance.setConfigGlobalAuthority(configGlobalAuthority);
    }

    /**
     * 收集controller的类及类注解
     */
    private void collectControllerClass() {
        Map<String, Object> beans = context.getBeansWithAnnotation(Controller.class);

        beans.forEach((key, bean) -> {
            if (bean.getClass().getName().startsWith("org.spring")) {
                return;
            }
            log.info("收集的类:" + bean.getClass().getName());
            ZhsControllerClassContext.instance.addControllerClassIfNotExist(bean.getClass());
            Annotation[] ans = bean.getClass().getDeclaredAnnotations();
            for (Annotation an : ans) {
                if (an.annotationType().getName().equals(RequestMapping.class.getName())) {
                    ZhsControllerClassContext.instance.addRequestMapping(bean.getClass(), (RequestMapping) an);
                }
            }
        });
    }

    /**
     * 收集在方法上注解的权限点
     */
    private void collectControllerMethodAuthority() {
        List<ClassWrapper> classWrapperList = ZhsControllerClassContext.instance.getControllerClassWrapperList();
        classWrapperList.forEach(classWrapper -> {
            Class clazz = classWrapper.clazz;
            List<Method> methodList = ZhsClassUtil.getMethodWithAnnotation(clazz, Authority.class);
            methodList.forEach(method -> {
                MethodWrapper methodWrapper = classWrapper.addMethodIfNotExist(method);
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getName().equals(Authority.class.getName())) {
                        methodWrapper.authority = (Authority) annotation;
                    }
                }
            });
        });
    }


    /**
     * 收集在方法上注解的菜单
     */
    private void collectControllerMethodMenu() {
        List<ClassWrapper> classWrapperList = ZhsControllerClassContext.instance.getControllerClassWrapperList();
        classWrapperList.forEach(classWrapper -> {
            Class clazz = classWrapper.clazz;
            List<Method> methodList = ZhsClassUtil.getMethodWithAnnotation(clazz, Menu.class);
            methodList.forEach(method -> {
                MethodWrapper methodWrapper = classWrapper.addMethodIfNotExist(method);
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getName().equals(Menu.class.getName())) {
                        methodWrapper.menu = (Menu) annotation;
                    }
                }
            });
        });
    }

    /**
     * 收集方法的路径映射
     */
    private void collectControllerMethodRequestMapping() {
        List<ClassWrapper> classWrapperList = ZhsControllerClassContext.instance.getControllerClassWrapperList();
        classWrapperList.forEach(classWrapper -> {
            Class clazz = classWrapper.clazz;
            List<Method> methodList = ZhsClassUtil.getMethodWithAnnotation(clazz, RequestMapping.class);
            methodList.forEach(method -> {
                MethodWrapper methodWrapper = classWrapper.addMethodIfNotExist(method);
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getName().equals(RequestMapping.class.getName())) {
                        methodWrapper.requestMapping = (RequestMapping) annotation;
                    }
                }
            });
        });
    }
}
