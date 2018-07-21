package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.RcuSettime;
import cn.zhsit.hotel.models.po.RcuSettimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RcuSettimeMapper {
    long countByExample(RcuSettimeExample example);

    int deleteByExample(RcuSettimeExample example);

    int deleteByPrimaryKey(String rcuid);

    int insert(RcuSettime record);

    int insertSelective(RcuSettime record);

    List<RcuSettime> selectByExample(RcuSettimeExample example);

    RcuSettime selectByPrimaryKey(String rcuid);

    int updateByExampleSelective(@Param("record") RcuSettime record, @Param("example") RcuSettimeExample example);

    int updateByExample(@Param("record") RcuSettime record, @Param("example") RcuSettimeExample example);

    int updateByPrimaryKeySelective(RcuSettime record);

    int updateByPrimaryKey(RcuSettime record);
}