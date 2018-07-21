package cn.zhsit.common.enums;

/**
 * Created by Darren on 2017/7/13.
 */
public enum FileType {
    //头像
    HeadPic("head"),
    //RCU升级包文件
    RCUFile("rcufile");
    ;
    private String type;
    private String descr;

    private FileType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
