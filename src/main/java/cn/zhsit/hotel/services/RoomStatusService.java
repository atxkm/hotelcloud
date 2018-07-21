package cn.zhsit.hotel.services;

import cn.zhsit.models.vo.FangTaiReq;
import cn.zhsit.models.vo.H5WSBody;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface RoomStatusService {

    H5WSBody getAllStatus(FangTaiReq req);
}
