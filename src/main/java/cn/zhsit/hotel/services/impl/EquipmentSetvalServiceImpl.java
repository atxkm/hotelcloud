package cn.zhsit.hotel.services.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import cn.zhsit.common.enums.RoomSetValType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhsit.common.enums.RoomEventType;
import cn.zhsit.hotel.daos.EquipmentSetvalMapper;
import cn.zhsit.hotel.models.po.EquipmentSetval;
import cn.zhsit.hotel.models.po.EquipmentSetvalExample;
import cn.zhsit.hotel.models.po.RoomEventValue;
import cn.zhsit.hotel.services.EquipmentSetvalService;
@Service
public class EquipmentSetvalServiceImpl implements EquipmentSetvalService {
	private static final String formatStr = "HH:mm";
	private static SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
	public static Map<String,List<EquipmentSetval>> equmap  = new HashMap<String, List<EquipmentSetval>>();
	@Autowired
	EquipmentSetvalMapper equipmentSetvalMapper;
	@Override
	public long countByExample(EquipmentSetvalExample example) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(EquipmentSetvalExample example) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String modelid) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.deleteByPrimaryKey(modelid);
	}

	@Override
	public int insert(List<EquipmentSetval> equipmentSetvals) {
		try{
			for(int i=0;i<equipmentSetvals.size();i++){
				EquipmentSetval aEquipmentSetval = equipmentSetvals.get(i);
				EquipmentSetval bEquipmentSetval = equipmentSetvalMapper.selectByPrimaryKey(aEquipmentSetval.getModelid());
				if(bEquipmentSetval!=null){
					equipmentSetvalMapper.updateByPrimaryKey(bEquipmentSetval);
				}else{
					equipmentSetvalMapper.insert(aEquipmentSetval);
				}
			}
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int insertSelective(EquipmentSetval record) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.insertSelective(record);
	}

	@Override
	public List<EquipmentSetval> selectByExample(EquipmentSetvalExample example) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.selectByExample(example);
	}

	@Override
	public EquipmentSetval selectByPrimaryKey(String modelid) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.selectByPrimaryKey(modelid);
	}

	@Override
	public int updateByExampleSelective(List<EquipmentSetval> records, EquipmentSetvalExample example) {
		// TODO Auto-generated method stub
		int res = 0;
		try{
			for(int i=0;i<records.size();i++){
				EquipmentSetval equipmentSetval = records.get(i);
				if(equipmentSetval.getModelid()!=null&&!equipmentSetval.getModelid().isEmpty()){
		    		res = equipmentSetvalMapper.updateByPrimaryKey(equipmentSetval);
		    	}
			}
			return res;
		}catch(Exception e){
			return res;
		}
	}

	@Override
	public int updateByExample(EquipmentSetval record, EquipmentSetvalExample example) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(EquipmentSetval record) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(EquipmentSetval record) {
		// TODO Auto-generated method stub
		return equipmentSetvalMapper.updateByPrimaryKey(record);
	}
	
	/**
	 * 消息是否需要提醒或显示
	 * val:需要判断的值
	 */
	@Override
	public RoomEventValue checkMsgIfShow(RoomEventType eventtype,String val) {
		// TODO Auto-generated method stub
		RoomEventValue aRoomEventValue = new RoomEventValue();
		EquipmentSetvalExample example = new EquipmentSetvalExample();
		//example.createCriteria().andParamtypeEqualTo(record.getParamtype());
		if(equmap.size()==0){
			List<EquipmentSetval> equiplst = equipmentSetvalMapper.selectByExample(example);
			for(EquipmentSetval aEquipmentSetval:equiplst){
				if(equmap.get(aEquipmentSetval.getParamtype())!=null){
					List<EquipmentSetval> lst = equmap.get(aEquipmentSetval.getParamtype());
					lst.add(aEquipmentSetval);
				}else{
					List<EquipmentSetval> lst = new ArrayList<EquipmentSetval>();
					equmap.put(aEquipmentSetval.getParamtype(), lst);
				}
			}
		}
		List<EquipmentSetval> setval = equmap.get(eventtype.code());
		aRoomEventValue.setSetval(false);
		aRoomEventValue.setNumbertime(0);
		if(setval.size()>0){
			for(int i=0;i<setval.size();i++) {
				EquipmentSetval t0 = setval.get(i);
				if (t0.getSetval().equals("1") && t0.getSetvaltype().equals(RoomSetValType.DONGHUAXIANSHI.code())) {
					aRoomEventValue.setSetval(true);
				}
				if (t0.getSetval().equals("1") && t0.getSetvaltype().equals(RoomSetValType.XIAOXITANCHU.code())) {
					aRoomEventValue.setVoiceval(true);
				}
				if (t0.getSetvaltype().equals(RoomSetValType.BOFANGCISHU.code())) {
					aRoomEventValue.setNumbertime(3);
				}
				/**显示时段*/
				if (t0.getSetvaltype().equals(RoomSetValType.YOUXIAOSHIDUANG.code())) {
					String splittime = t0.getSetval();
					String [] arr = splittime.split("-");
					if(isInZone(getLong(arr[0]),getLong(arr[1]),getCurrentTime())){
						aRoomEventValue.setSetval(true);
					}
				}
				/**夏季高温*/
				if (t0.getSetvaltype().equals(RoomSetValType.XIAJIGAOWEN.code())) {
					if(val!="" && !val.isEmpty()){
						String cval = t0.getSetval();
						if(Double.parseDouble(cval)<Double.parseDouble(val)){
							aRoomEventValue.setSetval(true);
						}
					}
				}
				/**冬季高温*/
				if (t0.getSetvaltype().equals(RoomSetValType.DONGJIGAOWEN.code())) {
					if(val!="" && !val.isEmpty()){
						String cval = t0.getSetval();
						if(Double.parseDouble(cval)<Double.parseDouble(val)){
							aRoomEventValue.setSetval(true);
						}
					}
				}
				/**消防温度*/
				if (t0.getSetvaltype().equals(RoomSetValType.XIAOFANGGAOWEN.code())) {
					if(val!="" && !val.isEmpty()){
						String cval = t0.getSetval();
						if(Double.parseDouble(cval)<Double.parseDouble(val)){
							aRoomEventValue.setSetval(true);
						}
					}
				}
			}
		}

		return aRoomEventValue;
	}

	private boolean isInZone(long tStart,long tEnd,long t) {
		return tStart <= t && t <= tEnd;
	}

	private long getLong(String timeStr) {
		try {
			return sdf.parse(timeStr).getTime();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	private long getCurrentTime()  {
		return getLong(sdf.format(new Date()));
	}

}
