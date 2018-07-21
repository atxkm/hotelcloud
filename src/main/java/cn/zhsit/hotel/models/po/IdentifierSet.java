package cn.zhsit.hotel.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class IdentifierSet implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String onoffType;

    /**
     * 
     */
    private String cardType;

    /**
     * 
     */
    private String typeName;

    /**
     * 
     */
    private String img;

    /**
     * 
     */
    private String iddetail;

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

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOnoffType() {
        return onoffType;
    }

    public void setOnoffType(String onoffType) {
        this.onoffType = onoffType == null ? null : onoffType.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getIddetail() {
        return iddetail;
    }

    public void setIddetail(String iddetail) {
        this.iddetail = iddetail == null ? null : iddetail.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", onoffType=").append(onoffType);
        sb.append(", cardType=").append(cardType);
        sb.append(", typeName=").append(typeName);
        sb.append(", img=").append(img);
        sb.append(", iddetail=").append(iddetail);
        sb.append(", optid=").append(optid);
        sb.append(", opttime=").append(opttime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}