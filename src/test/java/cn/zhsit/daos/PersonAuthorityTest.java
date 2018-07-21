package cn.zhsit.daos;

import cn.zhsit.BaseTest;
import cn.zhsit.ServerApplication;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.authority.models.po.PersonAuthorityExample;
import cn.zhsit.common.utils.ZhsMD5;
import cn.zhsit.common.utils.ZhsUnique;
import cn.zhsit.common.utils.page.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
@Component
public class PersonAuthorityTest extends BaseTest {

    @Test
    public void addDevPerson1() {
        PersonAuthority personAuthority = new PersonAuthority();
        personAuthority.setId(ZhsUnique.unique25());
        personAuthority.setLoginName("1");
        personAuthority.setPwd(ZhsMD5.pwd("1"));
        personAuthority.setName("开发测试员");
        personAuthority.setHeadPic("/a/b/c.jpg");
        personAuthority.setCreateTime(current);
        personAuthority.setModifyTime(current);
        personAuthorityMapper.insert(personAuthority);
    }

    //分页demo
    @Test
    public void findByPage() {
//        当前页
        int page = 2;
//        每页数据数
        int rows=2;
        PersonAuthorityExample querySql = new PersonAuthorityExample();
//        添加查询条件
//        querySql.createCriteria().and
        querySql.setOrderByClause("login_name");
        querySql.setPage(new Page().setPage(page).setRows(rows));

        //查询出的当前页的数据列表
        List<PersonAuthority> poFromDB = personAuthorityMapper.selectByExample(querySql);
        for (PersonAuthority personAuthority : poFromDB) {
            System.out.println(personAuthority.getLoginName());
        }
        //符合条件的总数
        long total = personAuthorityMapper.countByExample(querySql);

        System.out.println("总数为:"+total);
    }

    @Override
    @Test
    public void addAll() throws Exception {

    }

    @Override
    @Test
    public void addDevAll() throws Exception {
        addDevPerson1();
    }
}
