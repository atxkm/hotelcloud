package cn.zhsit.models.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Darren on 2017/7/16.
 */
public class LoginResp {
    /**
     * 姓名
     */
    @SerializedName("Username")
    private String name;
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

    public String getName() {
        return name;
    }

    public LoginResp setName(String name) {
        this.name = name;
        return this;
    }

    public String getHeadPic() {
        return headPic;
    }

    public LoginResp setHeadPic(String headPic) {
        this.headPic = headPic;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public LoginResp setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
