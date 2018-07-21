package cn.zhsit.authority.managers;

import cn.zhsit.authority.models.po.RoleAuthority;

import java.util.List;

/**
 * Created by Darren on 2017/7/11.
 */
public interface RoleAuthorityManager {
    List<RoleAuthority> selectRoleListByPersonId(String personId);
}
