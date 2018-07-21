package cn.zhsit.hotel.models.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 * 发送给前台端的软件更新消息
 */
public class MsgSoftUpdate{
    /**
     * 文件相对路径和文件名称(含后缀)
     * 存储文件时可以借鉴或使用{@link cn.zhsit.common.utils.ZhsFileUtils#saveFile(String, String, String, byte[])}
     * 文件存在 启动目录下的zhsstore/../
     */
    private String filePathName;

    /**
     * 版本号,版本号不大于255（RCU中只用一个字节存储此数据）
     */
    private int version;

    /**
     * 将更新的RCU的host列表，(list<"192.168.1.129">)
     */
    private List<String> hosts = new ArrayList<>();
    /**
     * RCU的端口，默认是69，没特殊情况，不要修改
     */
    private int port = 69;

    public String getFilePathName() {
        return filePathName;
    }

    public MsgSoftUpdate setFilePathName(String filePathName) {
        this.filePathName = filePathName;
        return this;
    }

    public int getVersion() {
        return version;
    }

    public MsgSoftUpdate setVersion(int version) {
        this.version = version;
        return this;
    }

    public List<String> getHosts() {
        return hosts;
    }

    public MsgSoftUpdate setHosts(List<String> hosts) {
        this.hosts = hosts;
        return this;
    }

    /**
     * 批量增加host
     *
     * @param hosts
     * @return
     */
    public MsgSoftUpdate addHosts(List<String> hosts) {
        this.hosts.addAll(hosts);
        return this;
    }

    /**
     * 增加单个host
     *
     * @param host
     * @return
     */
    public MsgSoftUpdate addHost(String host) {
        this.hosts.add(host);
        return this;
    }

    public int getPort() {
        return port;
    }

    public MsgSoftUpdate setPort(int port) {
        this.port = port;
        return this;
    }

}
