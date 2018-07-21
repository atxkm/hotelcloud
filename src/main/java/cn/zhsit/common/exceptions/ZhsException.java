package cn.zhsit.common.exceptions;

/**
 * Created by zhsit on 2016/8/20.
 */
public class ZhsException extends Exception {
    private String msg;

    public ZhsException(){}
    public ZhsException(String msg){
        this.msg=msg;
    }
    public String getMsg(){
        return msg;
    }
}
