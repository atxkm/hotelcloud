package cn.zhsit.authority.manage.impl;
import cn.zhsit.authority.api.models.AuthorityModel;
import cn.zhsit.authority.api.models.MenuModel;
import cn.zhsit.authority.api.models.Wrapper;
import cn.zhsit.authority.manage.ManageServiceAuthority;
import cn.zhsit.authority.managers.AuthorityAuthorityManager;
import cn.zhsit.authority.managers.MenuAuthorityManager;
import cn.zhsit.authority.models.po.AuthorityAuthority;
import cn.zhsit.authority.models.po.MenuAuthority;
import cn.zhsit.common.utils.ZhsUnique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Darren on 2017/7/1.
 */
@Service
public class ManageServiceAuthorityImpl implements ManageServiceAuthority {
    @Autowired
    private AuthorityAuthorityManager authorityAuthorityManager;
    @Autowired
    private MenuAuthorityManager menuAuthorityManager;

    @Override
    public Wrapper authorityOpera(Wrapper<List<AuthorityModel>> wrapper) {
        List<AuthorityModel> authorityModelList = wrapper.getT();
        Wrapper.Opera opera = wrapper.getOpera();
        switch (opera) {
            case Add:
                return addAuthorityModels(authorityModelList);

            default:
                return new Wrapper().setSuccess(false).setMsg("未处理");
        }
    }

    private Wrapper addAuthorityModels(List<AuthorityModel> authorityModelList) {
        Date current = new Date();
        List<AuthorityAuthority> list = new ArrayList<>();
        for (AuthorityModel m : authorityModelList) {
            AuthorityAuthority aa = new AuthorityAuthority();
            aa.setId(ZhsUnique.unique25());
            aa.setCode(m.getCode());
            aa.setRelativeUrl(m.getUrl());
            aa.setDescr(m.getDescr());
            aa.setAuthorityType(m.getAuthorityType());
            aa.setAuthorityGroup(m.getAuthorityGroup());
            aa.setCreateTime(current);
            aa.setModifyTime(current);
            list.add(aa);
        }
        //TODO 去重复
        boolean success = authorityAuthorityManager.addAuthorityAuthority(list);
        return new Wrapper().setSuccess(success);
    }


    @Override
    public Wrapper menuOpera(Wrapper<List<MenuModel>> wrapper) {
        List<MenuModel> menuModelList = wrapper.getT();
        Wrapper.Opera opera = wrapper.getOpera();
        switch (opera) {
            case Add:
                return addMenuModels(menuModelList);

            default:
                return new Wrapper().setSuccess(false);
        }
    }


    private Wrapper addMenuModels(List<MenuModel> menuModelList) {
        Date current = new Date();
        List<MenuAuthority> list = new ArrayList<>();
        for (MenuModel m : menuModelList) {
            MenuAuthority ma = new MenuAuthority();
            ma.setId(ZhsUnique.unique25());
            ma.setShowChars(m.getShowChars());
            ma.setCode(m.getAuthorityName());
            ma.setCreateTime(current);
            ma.setModifyTime(current);
            list.add(ma);
        }
        //TODO 去重复
        boolean success = menuAuthorityManager.addMenuAuthority(list);
        return new Wrapper().setSuccess(success).setMsg("未处理");
    }
}
