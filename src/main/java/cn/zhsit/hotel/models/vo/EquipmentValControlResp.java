package cn.zhsit.hotel.models.vo;

import java.util.Date;

public class EquipmentValControlResp {
    /**
     * 设置值
     */
    private int setval;
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String equipmentname;

    /**
     *
     */
    private String equBrand;

    /**
     *
     */
    private String equType;

    /**
     *
     */
    private Date buyTime;

    /**
     *
     */
    private String optid;

    /**
     *
     */
    private Date opttime;

    /**
     *
     */
    private String remark;

    /**
     *
     */
    private Integer roomid;

    public int getSetval() {
        return setval;
    }

    public void setSetval(int setval) {
        this.setval = setval;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
    }

    public String getEquBrand() {
        return equBrand;
    }

    public void setEquBrand(String equBrand) {
        this.equBrand = equBrand;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getOptid() {
        return optid;
    }

    public void setOptid(String optid) {
        this.optid = optid;
    }

    public Date getOpttime() {
        return opttime;
    }

    public void setOpttime(Date opttime) {
        this.opttime = opttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }
}
