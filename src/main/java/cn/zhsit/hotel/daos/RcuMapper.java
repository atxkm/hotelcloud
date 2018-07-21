package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import java.util.List;
import cn.zhsit.models.vo.RcuReq;
import org.apache.ibatis.annotations.Param;

public interface RcuMapper {
    long countByExample(RcuExample example);

    int deleteByExample(RcuExample example);

    int deleteByPrimaryKey(String rcuid);

    int insert(Rcu record);

    int insertSelective(Rcu record);

    List<Rcu> selectByExample(RcuExample example);

    Rcu selectByPrimaryKey(String rcuid);

    int updateByExampleSelective(@Param("record") Rcu record, @Param("example") RcuExample example);

    int updateByExample(@Param("record") Rcu record, @Param("example") RcuExample example);

    int updateByPrimaryKeySelective(Rcu record);

    int updateByPrimaryKey(Rcu record);

    List<Rcu> selectByFloorId(RcuReq rcuReq);

    Long countByFloorid(RcuReq rcuReq);
}