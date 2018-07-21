package cn.zhsit;

import cn.zhsit.authority.daos.PersonAuthorityMapper;
import cn.zhsit.authority.models.po.PersonAuthority;
import cn.zhsit.hotel.daos.EquipmentSetvalMapper;
import cn.zhsit.hotel.daos.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Darren on 2017/7/11.
 */
public abstract class BaseTest implements ITest {
    @Autowired
    public PersonAuthorityMapper personAuthorityMapper;
    @Autowired
    public MessageMapper messageMapper;
    @Autowired
    public EquipmentSetvalMapper equipmentSetvalMapper;

}
