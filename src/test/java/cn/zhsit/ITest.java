package cn.zhsit;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface ITest {

    Date current = new Date();

    /**
     * 添加生产数据
     * @throws Exception
     */
    public void addAll() throws Exception;

    /**
     * 添加开发环境数据
     * @throws Exception
     */
    default void addDevAll()throws Exception{

    }
}
