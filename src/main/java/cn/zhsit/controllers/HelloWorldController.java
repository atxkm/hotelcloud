package cn.zhsit.controllers;


import cn.zhsit.authority.annotations.Authority;
import cn.zhsit.authority.daos.RoleAuthorityMapper;
import cn.zhsit.common.configs.ZhsConfig;
import cn.zhsit.hotel.daos.RoomHotelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author Darren
 * @email 61947666@qq.com
 * @description:
 */
@RestController
@RequestMapping("ff")
public class HelloWorldController {
    private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);
    @Autowired
    private ZhsConfig zhsConfig;
    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;
    @Autowired
    private RoomHotelMapper roomHotelMapper;

    @Authority(code = "ff.hello", descr = "查看Hello 无参数的权限")
    @RequestMapping("/hello1")

    public String hello1(HttpServletRequest request, HttpServletResponse response) {
        return "Hello 中国、world.pcserver";
    }

    @Authority(code = "ff.hello1-1", descr = "查看Hello 有参数的权限")
    @RequestMapping("/hello1-1")
    public String hello1(String ss) {
        return "Hello 中国、world.";
    }

    @Authority(code = "b", group = "测试组")
    @RequestMapping("/hello2")
    public List<String> hello2() {
        return Arrays.asList(new String[]{"A", "B", "C"});
    }

    @RequestMapping("/hello3")
    public String hello3(String ss) {
        log.info("ZhsConfig:{}", zhsConfig.toString());
        return "Hello 世界、world.";
    }
}
