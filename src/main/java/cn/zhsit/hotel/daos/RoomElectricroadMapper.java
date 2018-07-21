package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.RoomElectricroad;
import cn.zhsit.hotel.models.po.RoomElectricroadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomElectricroadMapper {
    long countByExample(RoomElectricroadExample example);

    int deleteByExample(RoomElectricroadExample example);

    int deleteByPrimaryKey(String rmeleid);

    int insert(RoomElectricroad record);

    int insertSelective(RoomElectricroad record);

    List<RoomElectricroad> selectByExample(RoomElectricroadExample example);

    RoomElectricroad selectByPrimaryKey(String rmeleid);

    int updateByExampleSelective(@Param("record") RoomElectricroad record, @Param("example") RoomElectricroadExample example);

    int updateByExample(@Param("record") RoomElectricroad record, @Param("example") RoomElectricroadExample example);

    int updateByPrimaryKeySelective(RoomElectricroad record);

    int updateByPrimaryKey(RoomElectricroad record);
}