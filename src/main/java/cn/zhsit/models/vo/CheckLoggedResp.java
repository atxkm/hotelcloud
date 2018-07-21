package cn.zhsit.models.vo;

import cn.zhsit.common.enums.LoginStatus;
import java.util.List;

/**
 * Created by Administrator on 2017/11/5.
 *
 */
public class CheckLoggedResp {
    private LoginStatus loginStatus;
    private List<AuthorityResp> authorityList;

    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    public CheckLoggedResp setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
        return this;
    }

    public List<AuthorityResp> getAuthorityList() {
        return authorityList;
    }

    public CheckLoggedResp setAuthorityList(List<AuthorityResp> authorityList) {
        this.authorityList = authorityList;
        return this;
    }
}
