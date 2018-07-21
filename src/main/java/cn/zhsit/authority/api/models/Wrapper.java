package cn.zhsit.authority.api.models;

import java.io.Serializable;

/**
 * Created by Darren on 2017/7/2.
 */
public class Wrapper<T> implements Serializable {
    private Boolean success;
    private T t;
    private Opera opera;
    //反馈的信息
    private String msg;

    public Wrapper() {
    }

    public Wrapper(Opera opera) {
        this.opera = opera;
    }

    public Wrapper(T t, Opera opera) {
        this.t = t;
        this.opera = opera;
    }


    public Wrapper setT(T t) {
        this.t = t;
        return this;
    }

    public T getT() {
        return this.t;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Wrapper setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Opera getOpera() {
        return opera;
    }

    public Wrapper setOpera(Opera opera) {
        this.opera = opera;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Wrapper setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 操作
     */
    public enum Opera {
        Add, Delete, Update, Find;
    }
}
