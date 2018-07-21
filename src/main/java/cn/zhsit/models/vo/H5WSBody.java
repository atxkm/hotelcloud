package cn.zhsit.models.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/10/30.
 * 与H5 进行websocket交互报文
 */
public class H5WSBody<T> {
    /**
     * @see cn.zhsit.common.enums.H5Code
     */
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private T data;

    public Boolean success = null;

    public String message = null;

    public H5WSBody<T> success() {
        this.success = true;
        return this;
    }

    public H5WSBody<T> fail() {
        this.success = false;
        return this;
    }

    public int getCode() {
        return code;
    }

    public H5WSBody setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public H5WSBody setData(T data) {
        this.data = data;
        return this;
    }
}
