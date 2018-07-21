package cn.zhsit.hotel.models.dto;

/**
 * Created by Administrator on 2017/10/20.
 */
public class CloudFront {
    /**
     * @see CloudFrontTypeEnum
     */
    private byte type;
    private String host;
    private int port;
    //当发送客户指令时：Hex,包含指令、地址，字节数，数据n
    //当发送给前台人员消息时：文本（UTF-8）
    private String data;
    //192.168.1.128:1278;192.168.1.128:1278;
    private String hostPorts;

    public byte getType() {
        return type;
    }

    public CloudFront setType(byte type) {
        this.type = type;
        return this;
    }

    public String getHost() {
        return host;
    }

    public CloudFront setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public CloudFront setPort(int port) {
        this.port = port;
        return this;
    }

    public String getData() {
        return data;
    }

    public CloudFront setData(String data) {
        this.data = data;
        return this;
    }

    public String getHostPorts() {
        return hostPorts;
    }

    public CloudFront setHostPorts(String hostPorts) {
        this.hostPorts = hostPorts;
        return this;
    }
}
