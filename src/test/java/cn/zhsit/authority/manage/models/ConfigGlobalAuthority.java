package cn.zhsit.authority.manage.models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Darren on 2017/7/3.
 */
@Component
@ConfigurationProperties(prefix="zhsit.authority")
public class ConfigGlobalAuthority {
//    private String systemName;
//
//    public String getSystemName() {
//        return systemName;
//    }
//
//    public ConfigGlobalAuthority setSystemName(String systemName) {
//        this.systemName = systemName;
//        return this;
//    }
}
