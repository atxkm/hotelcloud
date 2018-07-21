package cn.zhsit.hotel.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.po.Warning;
import cn.zhsit.hotel.models.po.WarningExample;
import cn.zhsit.hotel.models.vo.WarningResultVo;
import cn.zhsit.hotel.models.vo.WarningVo;

public interface WarningService {
	long countByExample(WarningExample example);

    int deleteByExample(WarningExample example);

    int insert(Warning record);

    int insertSelective(Warning record);

    List<Warning> selectByExample(WarningExample example);

    int updateByExampleSelective(@Param("record") Warning record, @Param("example") WarningExample example);

    int updateByExample(@Param("record") Warning record, @Param("example") WarningExample example);


	public int updateById(Warning record);


	public WarningResultVo selectByBuilding(WarningVo warningVo);
	/*
    Warning selectById(String id);

	int deleteById(String warningid);*/
}
