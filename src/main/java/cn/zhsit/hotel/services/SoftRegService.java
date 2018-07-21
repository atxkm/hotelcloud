package cn.zhsit.hotel.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.SoftReg;
import cn.zhsit.hotel.models.po.SoftRegExample;

public interface SoftRegService {
	long countByExample(SoftRegExample example);

    int deleteByExample(SoftRegExample example);

    int deleteByPrimaryKey(String id);

    int insert(SoftReg record);

    int insertSelective(SoftReg record);

    List<SoftReg> selectByExample(SoftRegExample example);

    SoftReg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SoftReg record, @Param("example") SoftRegExample example);

    int updateByExample(@Param("record") SoftReg record, @Param("example") SoftRegExample example);

    int updateByPrimaryKeySelective(SoftReg record);

    int updateByPrimaryKey(SoftReg record);
}
