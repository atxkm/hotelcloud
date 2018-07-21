package cn.zhsit.hotel.services.impl;

import cn.zhsit.common.enums.FloorStatus;
import cn.zhsit.hotel.daos.FloorHotelMapper;
import cn.zhsit.hotel.models.po.FloorHotel;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.vo.FloorHotelVo;
import cn.zhsit.hotel.models.vo.FloorlVo;
import cn.zhsit.hotel.services.FloorHotelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FloorHotelServiceImpl implements FloorHotelService {
    @Autowired
    private FloorHotelMapper floorHotelMapper;

    @Override
    public long countByExample(FloorHotelExample example) {
        // TODO Auto-generated method stub
        return floorHotelMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FloorHotelExample example) {
        // TODO Auto-generated method stub
        return floorHotelMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return floorHotelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FloorHotel record) {
        // TODO Auto-generated method stub
        return floorHotelMapper.insert(record);
    }

    @Override
    public int insertSelective(FloorHotel record) {
        // TODO Auto-generated method stub
        return floorHotelMapper.insertSelective(record);
    }

    @Override
    public List<FloorHotel> selectByExample(FloorHotelExample example) {
        // TODO Auto-generated method stub
        return floorHotelMapper.selectByExample(example);
    }

    @Override
    public FloorHotel selectByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return floorHotelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(FloorHotel record, FloorHotelExample example) {
        // TODO Auto-generated method stub
        return floorHotelMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(FloorHotel record, FloorHotelExample example) {
        // TODO Auto-generated method stub
        return floorHotelMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(FloorHotel record) {
        // TODO Auto-generated method stub
        return floorHotelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FloorHotel record) {
        // TODO Auto-generated method stub
        return floorHotelMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FloorHotelVo> selectFloorHotelList(String buildingId) {
        // TODO Auto-generated method stub
        return floorHotelMapper.selectFloorHotelList(buildingId);
    }

    @Override
    public List<FloorlVo> findAllFloors() {
        FloorHotelExample query = new FloorHotelExample();
        query.createCriteria()
                .andFloorstatusEqualTo(FloorStatus.CunZai.getCode());
        query.setOrderByClause("floor");
        List<FloorHotel> poList = floorHotelMapper.selectByExample(query);
        List<FloorlVo> voList = new ArrayList<>();
        for (FloorHotel po : poList) {
            FloorlVo vo = new FloorlVo();
            BeanUtils.copyProperties(po, vo);
            voList.add(vo);
        }
        return voList;
    }

}
