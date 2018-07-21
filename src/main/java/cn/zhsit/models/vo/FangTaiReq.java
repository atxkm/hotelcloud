package cn.zhsit.models.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public class FangTaiReq {
    @SerializedName("buildingId")
    private String buildingId;
    @SerializedName("floors")
    private List<Integer> floors;

    public String getBuildingId() {
        return buildingId;
    }

    public FangTaiReq setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public List<Integer> getFloors() {
        return floors;
    }

    public FangTaiReq setFloors(List<Integer> floors) {
        this.floors = floors;
        return this;
    }
}
