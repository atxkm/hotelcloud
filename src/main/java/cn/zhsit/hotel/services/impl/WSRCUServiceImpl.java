package cn.zhsit.hotel.services.impl;
import cn.zhsit.hotel.models.vo.HostPort;
import cn.zhsit.hotel.services.WSRCUService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

@Service
public class WSRCUServiceImpl implements WSRCUService {


    @Override
    public List<HostPort> findAllHostPort() {
        List<HostPort> hostPortList = new ArrayList<>();
        HostPort hostPort = new HostPort("192.168.1.129",1278);
        hostPortList.add(hostPort);
        return hostPortList;
    }
}
