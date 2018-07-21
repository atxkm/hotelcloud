package cn.zhsit.models.vo;

import cn.zhsit.common.enums.RoomStatusEnum;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/1.
 * 每个房间的房态
 */

public class FangTaiResp {
    //房间id
    private String roomId;
    //房间编号
    private String roomNum;
    //温度
    private BigDecimal temperature;
    //第一个图标：门开，门关的状态。如果发现门开了2分钟以上，则有房门没有关好的房间的报警信息和语音提示。
    private RoomStatusEnum.FangMenZhuangTai fangMenZhuangTai;
    //    第二个图标：头像图片,客房服务员身份显示。有客人、领班、服务员、其他人员、客房经理、总经理和维修人员。（协议55上的显示比较少，上面显示比较多，看看需不需要上面的那么多：1 用户，2 服务员,3 值班经理,4 维修人员）
    private String headPicUrl;
    //    第三个图标：呼叫服务图标。
    private RoomStatusEnum.HuJiaoFuWu huJiaoFuWu;
    //    第四个图标：房态图标。有待租、已租、预定、维修、空置和脏房。
    private RoomStatusEnum.FangTai fangTai;
    //    第五个图标：紧急呼叫图标。有勿扰、清理和退房。
    private RoomStatusEnum.JinJiHuJiao jinJiHuJiao;
    //    第六个图标：保险柜的状态。有开和关。
    private RoomStatusEnum.BaoXianGui baoXianGui;

    public String getRoomId() {
        return roomId;
    }

    public FangTaiResp setRoomId(String roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public FangTaiResp setRoomNum(String roomNum) {
        this.roomNum = roomNum;
        return this;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public FangTaiResp setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
        return this;
    }

    public RoomStatusEnum.FangMenZhuangTai getFangMenZhuangTai() {
        return fangMenZhuangTai;
    }

    public FangTaiResp setFangMenZhuangTai(RoomStatusEnum.FangMenZhuangTai fangMenZhuangTai) {
        this.fangMenZhuangTai = fangMenZhuangTai;
        return this;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public FangTaiResp setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
        return this;
    }

    public RoomStatusEnum.HuJiaoFuWu getHuJiaoFuWu() {
        return huJiaoFuWu;
    }

    public FangTaiResp setHuJiaoFuWu(RoomStatusEnum.HuJiaoFuWu huJiaoFuWu) {
        this.huJiaoFuWu = huJiaoFuWu;
        return this;
    }

    public RoomStatusEnum.FangTai getFangTai() {
        return fangTai;
    }

    public FangTaiResp setFangTai(RoomStatusEnum.FangTai fangTai) {
        this.fangTai = fangTai;
        return this;
    }

    public RoomStatusEnum.JinJiHuJiao getJinJiHuJiao() {
        return jinJiHuJiao;
    }

    public FangTaiResp setJinJiHuJiao(RoomStatusEnum.JinJiHuJiao jinJiHuJiao) {
        this.jinJiHuJiao = jinJiHuJiao;
        return this;
    }

    public RoomStatusEnum.BaoXianGui getBaoXianGui() {
        return baoXianGui;
    }

    public FangTaiResp setBaoXianGui(RoomStatusEnum.BaoXianGui baoXianGui) {
        this.baoXianGui = baoXianGui;
        return this;
    }
}
