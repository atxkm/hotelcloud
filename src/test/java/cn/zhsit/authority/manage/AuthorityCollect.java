package cn.zhsit.authority.manage;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Darren on 2017/7/10.
 * 遍历所有权限相关的Controller等。将菜单，权限点等权限数据入库
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class AuthorityCollect extends BaseTest {
    private static Logger log = LoggerFactory.getLogger(AuthorityCollect.class);
    @Autowired
    protected ApplicationContext context;

    /**
     * 获取所有的权限点
     */
    @Test
    public void collectionAuthority() throws Exception {
//        ApplicationContext context = SpringApplication.run(ManageApplication.class, new String[]{});
        AuthorityHelper.instance.init(context).collect();
        log.info("============ add complete ===============");
    }

    @Override
    @Test
    public void addAll() throws Exception {
        collectionAuthority();
    }
}
