package cn.zhsit.authority.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class AuthorityAuthority implements Serializable {
    /**
     * 权限ID
     */
    private String id;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 菜单相对url是不含系统url的部分
     */
    private String relativeUrl;

    /**
     * 描述
     */
    private String descr;

    /**
     * 权限组:系统设置权限组等等，通过枚举类统一定义
     */
    private String authorityGroup;

    /**
     * 权限类型:1.纯权限点;2后端菜（点击菜单通过controller控制)；3前端菜单(前后分离时view层定义菜单,无相对url,点击菜单不受controller控制，前端js自行控制)；
     */
    private Byte authorityType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getRelativeUrl() {
        return relativeUrl;
    }

    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl == null ? null : relativeUrl.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getAuthorityGroup() {
        return authorityGroup;
    }

    public void setAuthorityGroup(String authorityGroup) {
        this.authorityGroup = authorityGroup == null ? null : authorityGroup.trim();
    }

    public Byte getAuthorityType() {
        return authorityType;
    }

    public void setAuthorityType(Byte authorityType) {
        this.authorityType = authorityType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", relativeUrl=").append(relativeUrl);
        sb.append(", descr=").append(descr);
        sb.append(", authorityGroup=").append(authorityGroup);
        sb.append(", authorityType=").append(authorityType);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}