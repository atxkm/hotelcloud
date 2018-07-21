package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.RcuCommand;
import cn.zhsit.hotel.models.po.RcuCommandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RcuCommandMapper {
    long countByExample(RcuCommandExample example);

    int deleteByExample(RcuCommandExample example);

    int deleteByPrimaryKey(String id);

    int insert(RcuCommand record);

    int insertSelective(RcuCommand record);

    List<RcuCommand> selectByExample(RcuCommandExample example);

    RcuCommand selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RcuCommand record, @Param("example") RcuCommandExample example);

    int updateByExample(@Param("record") RcuCommand record, @Param("example") RcuCommandExample example);

    int updateByPrimaryKeySelective(RcuCommand record);

    int updateByPrimaryKey(RcuCommand record);
}