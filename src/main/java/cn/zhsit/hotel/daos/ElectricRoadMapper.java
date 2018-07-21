package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.ElectricRoad;
import cn.zhsit.hotel.models.po.ElectricRoadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectricRoadMapper {
    long countByExample(ElectricRoadExample example);

    int deleteByExample(ElectricRoadExample example);

    int deleteByPrimaryKey(String id);

    int insert(ElectricRoad record);

    int insertSelective(ElectricRoad record);

    List<ElectricRoad> selectByExample(ElectricRoadExample example);

    ElectricRoad selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ElectricRoad record, @Param("example") ElectricRoadExample example);

    int updateByExample(@Param("record") ElectricRoad record, @Param("example") ElectricRoadExample example);

    int updateByPrimaryKeySelective(ElectricRoad record);

    int updateByPrimaryKey(ElectricRoad record);
}