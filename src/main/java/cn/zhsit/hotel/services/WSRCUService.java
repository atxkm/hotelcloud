package cn.zhsit.hotel.services;

import cn.zhsit.hotel.models.vo.HostPort;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */
public interface WSRCUService {
    /**
     * 获取所有的RCU的host和端口
     * @return
     */
    List<HostPort> findAllHostPort();
}
