package cn.zhsit.authority.adapters;

import cn.zhsit.authority.interceptors.AuthorityInterceptor;
import cn.zhsit.authority.interceptors.CharacterEncodingInterceptor;
import cn.zhsit.authority.interceptors.DeviceInterceptor;
import cn.zhsit.authority.interceptors.LoginInterceptor;
import cn.zhsit.common.configs.ZhsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Darren on 2017/7/7.
 */
@Configuration
public class WebAppConfigAuthority extends WebMvcConfigurerAdapter {
    @Autowired
    private CharacterEncodingInterceptor characterEncodingInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private AuthorityInterceptor authorityInterceptor;
    @Autowired
    private DeviceInterceptor deviceInterceptor;
    @Autowired
    private ZhsConfig zhsConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(characterEncodingInterceptor);
        registry.addInterceptor(deviceInterceptor);
//        registry.addInterceptor(loginInterceptor)//轮询状态的需要权限，是否需要算做一次操作？
//                .addPathPatterns("/**", "")
//                .excludePathPatterns(zhsConfig.getLoginExcludeUrl().toArray(new String[zhsConfig.getLoginExcludeUrl().size()]));
//        registry.addInterceptor(authorityInterceptor).addPathPatterns("/**", "");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/tm/**").setCachePeriod(10).addResourceLocations("classpath:/templates/");
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
 //       registry.addResourceHandler("/p/**").addResourceLocations("classpath:/pc/");
//        registry.addResourceHandler("/m/**").addResourceLocations("classpath:/mobile/");
       registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");

       // registry.addResourceHandler("/**").addResourceLocations("classpath:/pc/");

        super.addResourceHandlers(registry);
    }


}
