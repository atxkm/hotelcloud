package cn.zhsit.hotel.rcu;

/**
 * Created by Administrator on 2017/10/23.
 * <p>
 * 机器人(小乔)机器人文字	数据根据文字具体意义确定
 */
public class XiaoQiao {
    //控制此机器人的RCU的ip
    private String host;
    //rcu地址220
    public final static int address = 220;
    //语句,机器人文字
    private String sentence;
    //最后更新时间(与 System.currentTimeMillis()一致)
    private long lastTime;

    public XiaoQiao(String host) {
        this.host = host;
    }

    public String getSentence() {
        return sentence;
    }

    public XiaoQiao setSentence(String sentence) {
        this.sentence = sentence;
        return this;
    }

    public long getLastTime() {
        return lastTime;
    }

    public String getHost() {
        return host;
    }

    public XiaoQiao setHost(String host) {
        this.host = host;
        return this;
    }

    public XiaoQiao setLastTime(long lastTime) {
        this.lastTime = lastTime;
        return this;
    }
}
