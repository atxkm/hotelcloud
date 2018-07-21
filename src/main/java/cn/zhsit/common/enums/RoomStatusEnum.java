package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/11/1.
 */
public class RoomStatusEnum {
    //57 房门状态
    public enum FangMenZhuangTai {
        //        0为关，1为开，2为异常打开
        Close((byte) 0),
        Open((byte) 1),
        YiChang((byte) 2);
        private byte code;

        private FangMenZhuangTai(byte code) {
            this.code = code;
        }
        public static FangMenZhuangTai of(byte code){
            FangMenZhuangTai[] vals=FangMenZhuangTai.values();
            for (FangMenZhuangTai val : vals) {
                if((val.code-code)==0){
                    return val;
                }
            }
            return null;
        }
    }

    //73	呼叫服务	0为关，1为开，2为已受理
    public enum HuJiaoFuWu {
        Close((byte) 0),
        Open((byte) 1),
        Accepted((byte) 2);
        private byte code;

        HuJiaoFuWu(byte code) {
            this.code = code;
        }
        public static HuJiaoFuWu of(byte code){
            HuJiaoFuWu[] vals=HuJiaoFuWu.values();
            for (HuJiaoFuWu val : vals) {
                if((val.code-code)==0){
                    return val;
                }
            }
            return null;
        }
    }

    /**
     * 房态
     */
    public enum FangTai {
        //有待租、已租、预定、维修、空置和脏房
        /**
         * 待租
         */
        DaiZu((byte) 1),
        /**
         * 已租
         */
        YiZu((byte) 2),
        /**
         * 预定
         */
        YuDing((byte) 3),
        /**
         * 维修
         */
        WeiXiu((byte) 4),
        /**
         * 空置
         */
        KongZhi((byte) 5),
        /**
         * 脏房
         */
        ZangFang((byte) 6);
        private byte code;

        FangTai(byte code) {
            this.code = code;
        }
    }

    /**
     * 第五个图标：紧急呼叫图标。有勿扰、清理和退房。
     */
    public enum JinJiHuJiao {
        WuRao((byte) 1),
        QingLi((byte) 2),
        TuiFang((byte) 3);
        private byte code;

        JinJiHuJiao(byte code) {
            this.code = code;
        }

        public byte getCode() {
            return code;
        }
    }

    /**
     * 第六个图标：保险柜的状态。有开和关
     */
    public enum BaoXianGui {
        Open((byte) 1),
        Close((byte)2);
        private byte code;

        BaoXianGui(byte code) {
            this.code = code;
        }
    }

}
