package cn.zhsit.hotel.daos;

import cn.zhsit.hotel.models.po.RcuSetparam;
import cn.zhsit.hotel.models.po.RcuSetparamExample;
import cn.zhsit.models.vo.RcuSetparamReq;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RcuSetparamMapper {
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
    
    List<RcuSetparam> selectByFloorid(RcuSetparamReq rcuSetparamReq);

	Long countByFloorid(RcuSetparamReq rcuSetparamReq);
}