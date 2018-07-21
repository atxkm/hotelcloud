package cn.zhsit.authority.interceptors.models;

import cn.zhsit.common.enums.DeviceType;
import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.common.enums.WebSocketWorkerEnum;
import cn.zhsit.common.utils.ZhsUnique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Darren on 2017/7/7.
 */
public class ZhsSession {
    private static Logger log = LoggerFactory.getLogger(ZhsSession.class);

    /**
     * session标记
     */
    private String sessionKey;
    /**
     * 用于给前端做版本比较，若版本不一致，则更新权限等
     */
    private String lastSessionVersion;

    /**
     * 设备
     */
    private DeviceType deviceType;
    /**
     * 登录状态
     */
    private LoginStatus loginStatus;
    /**
     * 登录有效的最后时间
     * （验证是登录状态是Logged，并且成功的最后时间）
     */
    private long checkLoggedOKLastTime = 0L;

    /**
     * 当前用的id
     */
    private String personId;
    /**
     *当前的WebSocketWorker
     */
//    private WebSocketWorkerEnum webSocketWorkerEnum;
    private final Map<WebSocketWorkerEnum, Object> webSocketWorkerEnumObjectMap = new ConcurrentHashMap<>();
    public ZhsSession() {
    }

    public ZhsSession(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public ZhsSession setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    public ZhsSession put(String key, Object object) {
        return this;
    }


    public DeviceType getDeviceType() {
        return deviceType;
    }

    public ZhsSession setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    /**
     * 设置登录状态
     *
     * @param loginStatus
     * @return
     */
    public ZhsSession setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
        if (LoginStatus.Logined == loginStatus) {
            this.checkLoggedOKLastTime = System.currentTimeMillis();
        } else {
            this.checkLoggedOKLastTime = 0L;
        }
        return this;
    }

    public LoginStatus getLoginStatus(){
        return this.loginStatus;
    }

    public String getPersonId() {
        return personId;
    }

    public ZhsSession setPersonId(String personId) {
        this.personId = personId;
        return this;
    }

    /**
     * 根据失效时间检查登录状态
     *
     * @param expirySecond 失效时间,秒
     * @return
     */
    public LoginStatus checkLoginStatus(int expirySecond) {
        long cha = System.currentTimeMillis() - checkLoggedOKLastTime;
        if (LoginStatus.Logined == loginStatus && cha < expirySecond * 1000) {
            setLoginStatus(LoginStatus.Logined);
            checkLoggedOKLastTime = System.currentTimeMillis();
            return loginStatus;
        } else {
            setLoginStatus(LoginStatus.NoLogin);
            checkLoggedOKLastTime = 0L;
            return loginStatus;
        }
    }

    public void addWorker(WebSocketWorkerEnum webSocketWorkerEnum, Object obj) {
        webSocketWorkerEnumObjectMap.clear();
        webSocketWorkerEnumObjectMap.put(webSocketWorkerEnum, obj);
    }

    public void emptyWorker() {
        webSocketWorkerEnumObjectMap.clear();
    }

    public Map<WebSocketWorkerEnum, Object> getWebSocketWorkers(){
        return webSocketWorkerEnumObjectMap;
    }

    public String getLastSessionVersion() {
        return lastSessionVersion;
    }

    public ZhsSession setLastSessionVersion() {
        this.lastSessionVersion = ZhsUnique.unique25();
        return this;
    }
}
