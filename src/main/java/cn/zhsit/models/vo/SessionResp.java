package cn.zhsit.models.vo;

import cn.zhsit.common.enums.LoginStatus;

/**
 * Created by Administrator on 2017/11/5.
 */
public class SessionResp {
    /**
     * {@link LoginStatus#name()}
     */
    private String status;
    /**
     * {@link cn.zhsit.authority.interceptors.models.ZhsSession}
     */
    private String version;

    public String getStatus() {
        return status;
    }

    public SessionResp setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public SessionResp setVersion(String version) {
        this.version = version;
        return this;
    }
}
