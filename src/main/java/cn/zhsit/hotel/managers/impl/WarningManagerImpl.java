package cn.zhsit.hotel.managers.impl;

import cn.zhsit.hotel.daos.WarningMapper;
import cn.zhsit.hotel.managers.WarningManager;
import cn.zhsit.hotel.models.po.Warning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/19.
 */
@Component
public class WarningManagerImpl implements WarningManager {
    @Autowired
    private WarningMapper warningMapper;

    @Override
    public void add(Warning po) {
        warningMapper.insert(po);
    }
}
