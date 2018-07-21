package cn.zhsit.hotel.services;

import cn.zhsit.common.enums.LoginStatus;
import cn.zhsit.hotel.models.po.Enterup;
import cn.zhsit.hotel.models.po.EnterupExample;
import cn.zhsit.models.vo.CheckLoggedReq;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.Errors;

import java.util.List;

public interface EnterupService {
	long countByExample(EnterupExample example);


    int deleteByExample(EnterupExample example);

    int deleteByPrimaryKey(String enterid);

    int insert(Enterup record);

    int insertSelective(Enterup record);

    List<Enterup> selectByExample(EnterupExample example);

    Enterup selectByPrimaryKey(String enterid);

    int updateByExampleSelective(@Param("record") Enterup record, @Param("example") EnterupExample example);

    int updateByExample(@Param("record") Enterup record, @Param("example") EnterupExample example);

    int updateByPrimaryKeySelective(Enterup record);

    int updateByPrimaryKey(Enterup record);

    public LoginStatus checkLogged(CheckLoggedReq check, Errors errors);
    public LoginStatus checkLogged();
}
