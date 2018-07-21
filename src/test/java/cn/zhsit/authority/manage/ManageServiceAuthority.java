package cn.zhsit.authority.manage;

import cn.zhsit.authority.api.models.AuthorityModel;
import cn.zhsit.authority.api.models.MenuModel;
import cn.zhsit.authority.api.models.Wrapper;

import java.util.List;

/**
 * Created by Darren on 2017/7/1.
 * 管理服务
 */
public interface ManageServiceAuthority {

    /**
     * 权限相关操作
     *
     * @param wrapper
     */
    public Wrapper authorityOpera(Wrapper<List<AuthorityModel>> wrapper);

    /**
     * 菜单相关操作
     * @param wrapper
     * @return
     */
    public Wrapper menuOpera(Wrapper<List<MenuModel>> wrapper);
}
