package cn.zhsit.authority.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Darren on 2017/6/28.
 */
public class Person {

    /**
     * 用户ID
     */
    private String id;
    /**
     * 登录名
     */
    private String loginName;

    /**
     * 姓名
     */
    @SerializedName("Username")
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 头像url
     */
    @SerializedName("PicUrl")
    private String headPic;

    /**
     * 角色名称
     */
    @SerializedName("Rolename")
    private String roleName;

    /**
     * 人员类型（角色）
     */
    private String roleCode;

    public String getId() {
        return id;
    }

    public Person setId(String id) {
        this.id = id;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public Person setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public Person setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public String getHeadPic() {
        return headPic;
    }

    public Person setHeadPic(String headPic) {
        this.headPic = headPic;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public Person setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public Person setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }
}
