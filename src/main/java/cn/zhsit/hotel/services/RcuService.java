package cn.zhsit.hotel.services;

import java.util.List;

import cn.zhsit.models.vo.RcuReq;
import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import cn.zhsit.hotel.models.po.RoomTypeHotel;
import cn.zhsit.hotel.models.po.RoomTypeHotelExample;

public interface RcuService {
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

    int insertRcu(List<Rcu> rcus);

    List<Rcu> selectByFloorId(RcuReq rcuReq);

    long countByFloorid(RcuReq rcuReq);
}
