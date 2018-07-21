package cn.zhsit.model.vo;

import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.models.vo.LoginReq;
import org.junit.Test;

/**
 * Created by Darren on 2017/7/16.
 */
public class LoginReqTest {

    @Test
    public void req(){
        LoginReq req=new LoginReq();
        req.setLoginName("1");
        req.setPwd("1");
        System.out.println(ZhsJsonUtil.toJson(req));
    }
}
