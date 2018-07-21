package cn.zhsit.controllers.mobile;

import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.common.configs.ZhsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Darren on 2017/8/20.
 */
@Controller
@RequestMapping("m")
public class MobileSystemController {
    private static Logger log = LoggerFactory.getLogger(MobileSystemController.class);
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private ZhsConfig zhsConfig;


//    @RequestMapping("/index")
////    @Login
//    public String toIndex(Model model){
////        return "app/mobile";
//        return "redirect:/mobile/index.html";
//    }
}
