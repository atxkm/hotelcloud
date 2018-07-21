package cn.zhsit.authority.models.po;

import java.io.Serializable;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class PersonOrgRelationAuthority implements Serializable {
    /**
     * 人员组织关系ID
     */
    private String id;

    /**
     * 人员ID
     */
    private String persoinId;

    /**
     * 组织ID
     */
    private String orgId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPersoinId() {
        return persoinId;
    }

    public void setPersoinId(String persoinId) {
        this.persoinId = persoinId == null ? null : persoinId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", persoinId=").append(persoinId);
        sb.append(", orgId=").append(orgId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}