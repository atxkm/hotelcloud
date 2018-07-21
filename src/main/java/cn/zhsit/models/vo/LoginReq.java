package cn.zhsit.models.vo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by fengjt on 2017/7/16.
 */
public class LoginReq {
    /**
     * 登录名
     */
    @JsonProperty(value = "loginName")
    @NotBlank(message="登录名不可为空")
    private String loginName;
    /**
     * 密码
     */
    @JsonProperty(value = "pwd")
    @NotBlank(message="密码不可为空")
    private String pwd;

    public String getLoginName() {
        return loginName;
    }

    public LoginReq setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public LoginReq setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }
}
