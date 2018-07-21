package cn.zhsit.common.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Darren on 2017/7/12.
 */
@Component
@ConfigurationProperties(prefix="zhsit")
public class ZhsConfig {
    //文件存储路径
    private String store;
    //超时时间（秒）
    private int expirySecond=1800;
    //pc登录地址
    private String pcLoginUrl;
    //移动端登录地址
    private String mobileLoginUrl;
    //无权限pc端跳转地址
    private String noAuthorityPcUrl;
    //无权限移动端跳转地址
    private String noAuthorityMobileUrl;
    //不受登录拦截的url列表
    private List<String> loginExcludeUrl;


    public String getStore() {
        return store;
    }

    public ZhsConfig setStore(String store) {
        this.store = store;
        return this;
    }

    public int getExpirySecond() {
        return expirySecond;
    }

    public ZhsConfig setExpirySecond(int expirySecond) {
        this.expirySecond = expirySecond;
        return this;
    }

    public String getPcLoginUrl() {
        return pcLoginUrl;
    }

    public ZhsConfig setPcLoginUrl(String pcLoginUrl) {
        this.pcLoginUrl = pcLoginUrl;
        return this;
    }

    public String getMobileLoginUrl() {
        return mobileLoginUrl;
    }

    public ZhsConfig setMobileLoginUrl(String mobileLoginUrl) {
        this.mobileLoginUrl = mobileLoginUrl;
        return this;
    }

    public String getNoAuthorityPcUrl() {
        return noAuthorityPcUrl;
    }

    public ZhsConfig setNoAuthorityPcUrl(String noAuthorityPcUrl) {
        this.noAuthorityPcUrl = noAuthorityPcUrl;
        return this;
    }

    public String getNoAuthorityMobileUrl() {
        return noAuthorityMobileUrl;
    }

    public ZhsConfig setNoAuthorityMobileUrl(String noAuthorityMobileUrl) {
        this.noAuthorityMobileUrl = noAuthorityMobileUrl;
        return this;
    }

    public List<String> getLoginExcludeUrl() {
        return loginExcludeUrl;
    }

    public ZhsConfig setLoginExcludeUrl(List<String> loginExcludeUrl) {
        this.loginExcludeUrl = loginExcludeUrl;
        return this;
    }

    @Override
    public String toString() {
        return "ZhsConfig{" +
                "store='" + store + '\'' +
                ", expirySecond=" + expirySecond +
                ", pcLoginUrl='" + pcLoginUrl + '\'' +
                ", mobileLoginUrl='" + mobileLoginUrl + '\'' +
                ", noAuthorityPcUrl='" + noAuthorityPcUrl + '\'' +
                ", noAuthorityMobileUrl='" + noAuthorityMobileUrl + '\'' +
                ", loginExcludeUrl=" + loginExcludeUrl +
                '}';
    }
}
