package cn.zhsit.models.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2017/10/31.
 */
public class CheckLoggedReq {
    /**
     * 登录名
     */
    @JsonProperty(value = "loginName")
    @NotBlank(message="登录名不可为空")
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public CheckLoggedReq setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }
}
