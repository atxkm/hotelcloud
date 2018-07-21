package cn.zhsit.hotel.services.impl;

import cn.zhsit.common.enums.H5Code;
import cn.zhsit.common.enums.RCUAddressEnum;
import cn.zhsit.common.enums.RoomStatusEnum;
import cn.zhsit.common.utils.ZhsByteUtil;
import cn.zhsit.hotel.collections.FromFrontDeskCollection;
import cn.zhsit.hotel.rcu.RCU;
import cn.zhsit.hotel.services.RoomStatusService;
import cn.zhsit.models.vo.FangTaiReq;
import cn.zhsit.models.vo.FangTaiResp;
import cn.zhsit.models.vo.H5WSBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class RoomStatusServiceImpl implements RoomStatusService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    int i = 0;
    boolean debug = true;

    @Override
    public H5WSBody getAllStatus(FangTaiReq req) {
        i++;
        H5WSBody body = new H5WSBody().fail();
        body.setCode(H5Code.ServerResponseFangTai.getCode());
//        if (i % 10 == 2) {
//            body.message = "此用户无权限（测试环境随机生成失败场景）";
//        } else {
            body.success();
            List<FangTaiResp> fangTaiRespList = new ArrayList<>();
            body.setData(fangTaiRespList);
            int roomNum = 2301;
            int ip = 129;
            for (int i = 0; i < 80; i++) {
                String host = "192.168.1." + ip++;
                FangTaiResp fangTaiResp = new FangTaiResp();
                fangTaiResp.setRoomId("abcdefg" + i);
                fangTaiResp.setRoomNum(roomNum++ + "");
                fangTaiResp.setHeadPicUrl("/a/b/c.jpg");
                addInfoByRCU(host, fangTaiResp);
                fangTaiRespList.add(fangTaiResp);
            }
//        }
        return body;
    }

    public void addInfoByRCU(String host, FangTaiResp fangTaiResp) {
        try {
            RCU rcu = FromFrontDeskCollection.getByHost(host);
            addTemperature(fangTaiResp, rcu);
            addFangMenZhuangTai(fangTaiResp, rcu);
            addHuJiaoFuWu(fangTaiResp, rcu);
            fangTaiResp.setFangTai(RoomStatusEnum.FangTai.DaiZu);
            fangTaiResp.setJinJiHuJiao(RoomStatusEnum.JinJiHuJiao.WuRao);
            fangTaiResp.setBaoXianGui(RoomStatusEnum.BaoXianGui.Close);
        } catch (Exception e) {
//            log.error("从RCU提取信息时异常", e);
//            log.error("从RCU提取信息时异常");
        }
    }

    /**
     * 获取实际温度，临时从79号地址获取
     *
     * @param fangTaiResp
     * @param rcu
     */
    private void addTemperature(FangTaiResp fangTaiResp, RCU rcu) {
        try {

            Integer temperature = rcu.getAddressStatus(RCUAddressEnum.ShiJiWenDu79.getAddress());
            if (debug) {
                temperature = 20 + new Random().nextInt(5);
            }
            if (null == temperature) {
                return;
            }
            fangTaiResp.setTemperature(new BigDecimal(temperature));
        } catch (Exception e) {
//            log.error("从RCU提取温度信息时异常", e);
//            log.error("从RCU提取温度信息时异常");
        }
    }

    /**
     * 获取房门状态
     *
     * @param fangTaiResp
     * @param rcu
     */
    private void addFangMenZhuangTai(FangTaiResp fangTaiResp, RCU rcu) {
        Integer fangMenInteger = rcu.getAddressStatus(RCUAddressEnum.FangMenZhuangTai.getAddress());
        if (null == fangMenInteger) {
            return;
        }

        byte fangMen = ZhsByteUtil.intToByte(fangMenInteger);
        fangTaiResp.setFangMenZhuangTai(RoomStatusEnum.FangMenZhuangTai.of(fangMen));
        if (debug) {
            int k = new Random().nextInt(5) % 3;
            if (k == 0) {
                fangTaiResp.setFangMenZhuangTai(RoomStatusEnum.FangMenZhuangTai.Open);
            } else if (k==1) {
                fangTaiResp.setFangMenZhuangTai(RoomStatusEnum.FangMenZhuangTai.YiChang);
            } else {
                fangTaiResp.setFangMenZhuangTai(RoomStatusEnum.FangMenZhuangTai.Close);
            }
        }
    }

    /**
     * 获取呼叫服务信息
     *
     * @param fangTaiResp
     * @param rcu
     * @see
     */
    private void addHuJiaoFuWu(FangTaiResp fangTaiResp, RCU rcu) {
        Integer huJiaoFuWuInteger = rcu.getAddressStatus(RCUAddressEnum.HuJiaoFuWu.getAddress());
        if (null == huJiaoFuWuInteger) {
            return;
        }
        byte huJiao = ZhsByteUtil.intToByte(huJiaoFuWuInteger);
        fangTaiResp.setHuJiaoFuWu(RoomStatusEnum.HuJiaoFuWu.of(huJiao));
    }
}
