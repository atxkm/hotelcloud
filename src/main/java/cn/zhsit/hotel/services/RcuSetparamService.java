package cn.zhsit.hotel.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zhsit.hotel.models.po.Rcu;
import cn.zhsit.hotel.models.po.RcuExample;
import cn.zhsit.hotel.models.po.RcuSetparam;
import cn.zhsit.hotel.models.po.RcuSetparamExample;
import cn.zhsit.hotel.models.po.RoomTypeHotel;
import cn.zhsit.hotel.models.po.RoomTypeHotelExample;
import cn.zhsit.models.vo.RcuSetparamReq;

public interface RcuSetparamService {
	long countByExample(RcuSetparamExample example);

    int deleteByExample(RcuSetparamExample example);

    int deleteByPrimaryKey(String rcuid);

    int insert(RcuSetparam record);

    int insertSelective(RcuSetparam record);

    List<RcuSetparam> selectByExample(RcuSetparamExample example);

    RcuSetparam selectByPrimaryKey(String rcuid);

    int updateByExampleSelective(@Param("record") RcuSetparam record, @Param("example") RcuSetparamExample example);

    int updateByExample(@Param("record") RcuSetparam record, @Param("example") RcuSetparamExample example);

    int updateByPrimaryKeySelective(RcuSetparam record);

    int updateByPrimaryKey(RcuSetparam record);

    int insertRcuSetparam(List<RcuSetparam> rcus);

	List<RcuSetparam> selectByFloorid(RcuSetparamReq rcuSetparamReq);

	long countByFloorid(RcuSetparamReq rcuSetparamReq);
}
