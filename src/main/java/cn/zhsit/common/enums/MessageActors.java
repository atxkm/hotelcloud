package cn.zhsit.common.enums;

/**
 * Created by Administrator on 2017/11/5.
 * 消息参与者
 */
public enum MessageActors {
    /**
     * 职工
     */
//    Staff("staff"),
    Staff("酒店"),
    /**
     * 客户，住户
     */
//    Customer("customer");
    Customer("客户");
    private String code;

    MessageActors(String code) {
        this.code = code;
    }

    public static MessageActors of(String code) {
        MessageActors[] actorses=MessageActors.values();
        for (MessageActors ac : actorses) {
            if (ac.code.equals(code)) {
                return ac;
            }
        }
        return null;
    }
    public String getCode() {
        return code;
    }
}
