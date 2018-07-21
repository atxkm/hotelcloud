package cn.zhsit.common.configs;

/**
 * Created by Darren on 2017/7/13.
 */
public enum FileType {
    HeadPic("headpic", "头像"),;
    private String type;
    private String descr;

    private FileType(String type, String descr) {
        this.type = type;
        this.descr = descr;
    }

    public String getType() {
        return type;
    }
}
