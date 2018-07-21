package cn.zhsit.authority.api;

import cn.zhsit.authority.api.models.AuthorityModel;
import cn.zhsit.authority.api.models.Person;
import cn.zhsit.authority.api.models.Wrapper;

/**
 * Created by Darren on 2017/6/29.
 */
public interface ApiServiceAuthority {

    /**
     * 人员相关操作
     * @param wrapper
     * @return
     */
    public Wrapper<Person> personOpera(Wrapper<Person> wrapper);

    /**
     * 根据权限编号查询是否有权限
     * @param person
     * @param authority
     * @return  Wrapper.Boolean==true表示具备此权限
     */
    public Wrapper checkAuthority(Person person, AuthorityModel authority);
    //查角色
}
