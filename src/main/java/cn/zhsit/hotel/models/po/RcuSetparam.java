package cn.zhsit.hotel.models.po;

import java.io.Serializable;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class RcuSetparam implements Serializable {
    /**
     * 
     */
    private String rcuid;

    /**
     * 
     */
    private String roomid;

    /**
     * 
     */
    private String roomtype;

    /**
     * 
     */
    private String ipaddr;

    /**
     * 
     */
    private String macaddr;

    /**
     * 
     */
    private String port;

    /**
     * 
     */
    private String upipaddr;

    /**
     * 
     */
    private String upport;

    /**
     * 
     */
    private String maskcode;

    /**
     * 
     */
    private String gateway;

    /**
     * 
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getRcuid() {
        return rcuid;
    }

    public void setRcuid(String rcuid) {
        this.rcuid = rcuid == null ? null : rcuid.trim();
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public String getMacaddr() {
        return macaddr;
    }

    public void setMacaddr(String macaddr) {
        this.macaddr = macaddr == null ? null : macaddr.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getUpipaddr() {
        return upipaddr;
    }

    public void setUpipaddr(String upipaddr) {
        this.upipaddr = upipaddr == null ? null : upipaddr.trim();
    }

    public String getUpport() {
        return upport;
    }

    public void setUpport(String upport) {
        this.upport = upport == null ? null : upport.trim();
    }

    public String getMaskcode() {
        return maskcode;
    }

    public void setMaskcode(String maskcode) {
        this.maskcode = maskcode == null ? null : maskcode.trim();
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway == null ? null : gateway.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rcuid=").append(rcuid);
        sb.append(", roomid=").append(roomid);
        sb.append(", roomtype=").append(roomtype);
        sb.append(", ipaddr=").append(ipaddr);
        sb.append(", macaddr=").append(macaddr);
        sb.append(", port=").append(port);
        sb.append(", upipaddr=").append(upipaddr);
        sb.append(", upport=").append(upport);
        sb.append(", maskcode=").append(maskcode);
        sb.append(", gateway=").append(gateway);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}