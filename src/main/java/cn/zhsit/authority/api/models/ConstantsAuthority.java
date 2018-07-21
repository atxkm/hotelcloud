package cn.zhsit.authority.api.models;

/**
 * Created by Darren on 2017/7/7.
 */
public class ConstantsAuthority {

    public static final class CacheKey{
        //session所在的缓存块名称
        public static final String SessionCacheName = "ZhsSession";
        //人员，角色缓存模块名称，通过key区分：key= #id + 'person'+'list'
        public static final String ZhsPersonRoleAuthorityOrgCacheName = "ZhsPersonRoleAuthorityOrg";

        //房间缓存块名称
        public static final String RoomCacheName = "Room";

        ///////////////////////////////
        public static final String PersonAuthority = "PersonAuthority";
        public static final String RoleAuthorityList = "RoleAuthorityList";
    }

//    //人员所在缓存块名称
//    public static final String ZhsPersonCacheName = "ZhsPerson";
//    //角色权限缓存块名称
//    public static final String ZhsRoleCacheName = "ZhsRole";
//    //权限缓存块名称
//    public static final String ZhsAuthorityCacheName = "ZhsAuthority";
    //角色组织权限缓存块名称
//    public static final String ZhsRoleAuthorityOrgCacheName = "ZhsRoleAuthorityOrg";
    //
//    public static final String ZhsRoleListCacheName="ZhsRoleListKeyPersonId";
//    public static final String personId="personId";
    public static final String ZhsLoginCookieName = "zhslogincookie";

}
