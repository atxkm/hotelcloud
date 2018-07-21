package cn.zhsit.hotel.models.vo;

/**
 * Created by Administrator on 2017/10/20.
 */
public class HostPort {
    private String host;
    private int port;

    public HostPort() {
    }

    public HostPort(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public HostPort setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public HostPort setPort(int port) {
        this.port = port;
        return this;
    }

    @Override
    public String toString() {
        return "HostPort{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
