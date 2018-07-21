package cn.zhsit.authority.api.models;

/**
 * Created by Darren on 2017/7/1.
 */

/**
 * 权限项
 */
public class AuthorityModel {
    //访问相对路径
    private String url;
    //权限码
    private String code;
    //描述
    private String descr;
    // 权限类型:1.纯权限点;2菜单
    private Byte authorityType;

    /**
     * 权限组:系统设置权限组等等，通过枚举类统一定义
     */
    private String authorityGroup;
    public String getCode() {
        return code;
    }

    public AuthorityModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public AuthorityModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public Byte getAuthorityType() {
        return authorityType;
    }

    public AuthorityModel setAuthorityType(Byte authorityType) {
        this.authorityType = authorityType;
        return this;
    }

    public String getDescr() {
        return descr;
    }

    public AuthorityModel setDescr(String descr) {
        this.descr = descr;
        return this;
    }

    public String getAuthorityGroup() {
        return authorityGroup;
    }

    public AuthorityModel setAuthorityGroup(String authorityGroup) {
        this.authorityGroup = authorityGroup;
        return this;
    }
}
