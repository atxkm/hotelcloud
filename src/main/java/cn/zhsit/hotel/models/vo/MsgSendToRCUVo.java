package cn.zhsit.hotel.models.vo;


public class MsgSendToRCUVo {
	private String hostname;
    //端口
    private int port;
    /**
     * RCU指令 {@link cn.zhsit.common.enums.RCUOrderEnum}
     */
    //	    private int order;
    private int order;
    /**
     * RCU地址{@link cn.zhsit.common.enums.RCUAddressEnum}
     */
    //	    private int address;
    private int address;
    //数据（需要根据网络协议文档（网洛协议0707-2.docx）附表1  地址和数据具体含义的说明部分填写，除了机器人文字，其它全部是一个字节的数字）
    private String dataString;
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getDataString() {
		return dataString;
	}
	public void setDataString(String dataString) {
		this.dataString = dataString;
	}
	
    
    
}
