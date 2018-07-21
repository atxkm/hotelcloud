package cn.zhsit.authority.managers;

import cn.zhsit.authority.models.po.PersonAuthority;

/**
 * Created by Darren on 2017/7/11.
 */
public interface PersonAuthorityManager {


    PersonAuthority selectByKey(String id);

    /**
     * 根据登录名查询
     * @param loginName
     * @return
     */
    PersonAuthority selectByLoginName(String loginName);

    /**
     * 根据Id修改用户信息
     * @param personAuthority
     * @return
     */
    int updateByKey(PersonAuthority personAuthority);

    /**
     * 删除用户信息缓存
     * @param personId
     * @return
     */
    boolean removeCache(String personId);
}
