package cn.zhsit.hotel.models.vo;

public class RoomControlReq {
    private String host;
    private String setval;
    private String equtype;
    public String getSetval() {
        return setval;
    }

    public String getEqutype() {
        return equtype;
    }

    public void setEqutype(String equtype) {
        this.equtype = equtype;
    }

    public void setSetval(String setval) {
        this.setval = setval;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
