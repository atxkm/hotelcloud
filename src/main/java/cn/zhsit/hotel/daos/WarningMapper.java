package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.po.Warning;
import cn.zhsit.hotel.models.po.WarningExample;
import cn.zhsit.hotel.models.vo.WarningVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarningMapper {
	long countByExample(WarningExample example);

    int deleteByExample(WarningExample example);

    int insert(Warning record);

    int insertSelective(Warning record);

    List<Warning> selectByExample(WarningExample example);

    int updateByExampleSelective(@Param("record") Warning record, @Param("example") WarningExample example);

    int updateByExample(@Param("record") Warning record,@Param("example") WarningExample example);

	int updateById(Warning record);

	List<WarningVo> selectByBuilding(WarningVo warningVo);
	int countByBuilding(WarningVo warningVo);
   /** Warning selectById(String id);

	int deleteById(String warningid);*/

	
}