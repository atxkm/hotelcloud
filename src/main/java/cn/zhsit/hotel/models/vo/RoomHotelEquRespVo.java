package cn.zhsit.hotel.models.vo;

import java.util.Date;
import java.util.Map;

public class RoomHotelEquRespVo {

    private String host;
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
    /**
     * 设备序号，１，２，３.．．
     */
    private int serialno;

    private static final long serialVersionUID = 1L;

    /**
     * 设备对应的值
     */
    private Map<String,String> equMapValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public Map<String, String> getEquMapValue() {
        return equMapValue;
    }

    public void setEquMapValue(Map<String, String> equMapValue) {
        this.equMapValue = equMapValue;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname == null ? null : equipmentname.trim();
    }

    public String getEquBrand() {
        return equBrand;
    }

    public void setEquBrand(String equBrand) {
        this.equBrand = equBrand == null ? null : equBrand.trim();
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType == null ? null : equType.trim();
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
        this.optid = optid == null ? null : optid.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getSerialno() {
        return serialno;
    }

    public void setSerialno(int serialno) {
        this.serialno = serialno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", equipmentname=").append(equipmentname);
        sb.append(", equBrand=").append(equBrand);
        sb.append(", equType=").append(equType);
        sb.append(", buyTime=").append(buyTime);
        sb.append(", optid=").append(optid);
        sb.append(", opttime=").append(opttime);
        sb.append(", remark=").append(remark);
        sb.append(", roomid=").append(roomid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
