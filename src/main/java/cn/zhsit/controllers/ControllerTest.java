package cn.zhsit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
public class ControllerTest {
    @RequestMapping("/test")
    public String toWebSocketTest(HttpServletRequest request){
        return "redirect:/test/websockettest.html";
    }
    @RequestMapping("/testlogin")
    public String testlogin(HttpServletRequest request){
        return "redirect:/test/logintest.html";
    }
}
