package cn.zhsit.model.vo;

import cn.zhsit.common.enums.H5Code;
import cn.zhsit.common.utils.ZhsJsonUtil;
import cn.zhsit.models.vo.FangTaiReq;
import cn.zhsit.models.vo.H5WSBody;
import cn.zhsit.models.vo.MessageReq;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/30.
 */
public class H5WSBodyTest {
    @Test
    public void H5WSBodyToJson() {
        H5WSBody<FangTaiReq> body = new H5WSBody();
        body.setCode(H5Code.H5RequestFangTai.getCode());
        FangTaiReq request = new FangTaiReq();
        request.setBuildingId("ada5egeu968qrk9nk1wyaqfnl");
        request.setFloors(Arrays.asList(1, 2, 5));
        body.setData(request);
        System.out.println(ZhsJsonUtil.toJson(body));
    }

    @Test
    public void testMessage(){
        H5WSBody<MessageReq> body = new H5WSBody();
        body.setCode(H5Code.H5RequestRoomMessage.getCode());

        MessageReq req=new MessageReq();
        req.setRoomId("fnu5ufk3xq0j0wcisc0l8rdt");
        req.setContent("请来前台吧");
        body.setData(req);
        System.out.println(ZhsJsonUtil.toJson(body));
    }

//
//    public static class FangTaiReq{
//        @SerializedName("BuildingId")
//        private String buildingId;
//        @SerializedName("Floors")
//        private List<Integer> floors;
//
//        public String getBuildingId() {
//            return buildingId;
//        }
//
//        public FangTaiReq setBuildingId(String buildingId) {
//            this.buildingId = buildingId;
//            return this;
//        }
//
//        public List<Integer> getFloors() {
//            return floors;
//        }
//
//        public FangTaiReq setFloors(List<Integer> floors) {
//            this.floors = floors;
//            return this;
//        }
//    }
}
