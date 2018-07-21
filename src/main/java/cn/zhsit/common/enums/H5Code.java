package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/10/28.
 * H5请求相应代号
 */
public enum H5Code {
    /**
     * H5向服务器请求房态信息
     */
    H5RequestFangTai(1),
    /**
     *服务器端向H5发送房态
     */
    ServerResponseFangTai(2),
    /**
     * H5向服务器请求房间的聊天消息
     */
    H5RequestRoomMessage(3),
    /**
     * 服务器向H5返回房间的聊天消息
     */
    ServerResponseRoomMessage(4),
    ;
    /**
     * 编号
     */
    private int code;

    private H5Code(int code) {
        this.code = code;
    }

    public static H5Code of(int code) {
        H5Code[] codes = H5Code.values();
        for (H5Code hcode : codes) {
            if ((hcode.code - code) == 0) {
                return hcode;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
