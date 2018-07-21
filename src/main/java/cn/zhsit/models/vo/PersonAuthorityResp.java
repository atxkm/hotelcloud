package cn.zhsit.models.vo;

import cn.zhsit.authority.models.po.PersonAuthority;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
public class PersonAuthorityResp {
    private PersonAuthority po;

    /**
     * 登录名
     */
    @SerializedName("loginName")
    private String loginName;

    /**
     * 姓名
     */
    @SerializedName("name")
    private String name;

     /**
     * 头像图片路径
     */
     @SerializedName("headPic")
    private String headPic;


    public String getLoginName() {
        return loginName;
    }

    public PersonAuthorityResp setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonAuthorityResp setName(String name) {
        this.name = name;
        return this;
    }

    public String getHeadPic() {
        return headPic;
    }

    public PersonAuthorityResp setHeadPic(String headPic) {
        this.headPic = headPic;
        return this;
    }
}
