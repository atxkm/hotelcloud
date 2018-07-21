package cn.zhsit.hotel.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.common.utils.page.ComplexPage;
import cn.zhsit.hotel.daos.WarningMapper;
import cn.zhsit.hotel.models.po.FloorHotelExample;
import cn.zhsit.hotel.models.po.Warning;
import cn.zhsit.hotel.models.po.WarningExample;
import cn.zhsit.hotel.models.vo.WarningResultVo;
import cn.zhsit.hotel.models.vo.WarningVo;
import cn.zhsit.hotel.services.WarningService;
@Service
public class WarningServiceImpl implements WarningService {
	@Autowired
    private WarningMapper warningMapper;
	@Override
	public long countByExample(WarningExample example) {
		// TODO Auto-generated method stub
		return warningMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(WarningExample example) {
		// TODO Auto-generated method stub
		return warningMapper.deleteByExample(example);
	}

	@Override
	public int insert(Warning record) {
		// TODO Auto-generated method stub
		return warningMapper.insert(record);
	}

	@Override
	public int insertSelective(Warning record) {
		// TODO Auto-generated method stub
		return warningMapper.insertSelective(record);
	}

	@Override
	public List<Warning> selectByExample(WarningExample example) {
		// TODO Auto-generated method stub
		return warningMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Warning record, WarningExample example) {
		// TODO Auto-generated method stub
		return warningMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Warning record, WarningExample example) {
		// TODO Auto-generated method stub
		return warningMapper.updateByExample(record, example);
	}


	@Override
	public int updateById(Warning record) {
		// TODO Auto-generated method stub
		return warningMapper.updateById(record);
	}
	@Override
	public WarningResultVo selectByBuilding(WarningVo warningVo){
		int total = warningMapper.countByBuilding(warningVo);
		WarningResultVo vo = new WarningResultVo();
		List<WarningVo> lst = warningMapper.selectByBuilding(warningVo);
		vo.setResultlst(lst);
		ComplexPage page = new ComplexPage();
		page.setTotal((long)total);
		page.setPage(warningVo.getPage().getPage().intValue());
		page.setRows((int)warningVo.getPage().getRows());
		vo.setPage(page);
		return vo;
	}
	/*@Override
	public Warning selectById(String id) {
		// TODO Auto-generated method stub
		return warningMapper.selectById(id);
	}

	@Override
	public int deleteById(String warningid) {
		// TODO Auto-generated method stub
		return warningMapper.deleteById(warningid);
	}*/

}
