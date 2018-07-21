package cn.zhsit.controllers.pc;

import cn.zhsit.authority.helpers.CacheHelper;
import cn.zhsit.common.configs.ZhsConfig;
import cn.zhsit.hotel.models.vo.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Darren on 2017/8/20.
 */
@RestController
@RequestMapping("p")
public class PcSystemController {
    private static Logger log = LoggerFactory.getLogger(PcSystemController.class);
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private ZhsConfig zhsConfig;

//
//    @RequestMapping("/index")
////    @Login
//    public String toIndex(Model model){
//        return "redirect:/app/index.html";
////        return "forward:/app/index.html";
//    }

    public ResultBody get(){
        return new ResultBody();
    }
}
