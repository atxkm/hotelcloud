package cn.zhsit.common.models;

import cn.zhsit.common.enums.LoginStatus;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Darren on 2017/7/16.
 */

public class DtoSession {
//    //是否登录了
//    private boolean isLogin;
    @SerializedName("status")
    private LoginStatus status;

    //session的版本
    @SerializedName("version")
    private String version;
//    Status:Logined,NoLogin,Locked
//            Version


    public LoginStatus getStatus() {
        return status;
    }

    public DtoSession setStatus(LoginStatus status) {
        this.status = status;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public DtoSession setVersion(String version) {
        this.version = version;
        return this;
    }
}
