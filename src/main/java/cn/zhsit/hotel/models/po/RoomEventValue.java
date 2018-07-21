package cn.zhsit.hotel.models.po;

public class RoomEventValue {
	/**
	 * false:关，true：开  消息弹出
	 */
	private boolean setval;
	/**
	 * false:关，true：开  语音提示
	 */
	private boolean voiceval;
	/**
	 * 播放次数
	 */
	private Integer numbertime;

	public boolean isSetval() {
		return setval;
	}
	public void setSetval(boolean setval) {
		this.setval = setval;
	}
	public Integer getNumbertime() {
		return numbertime;
	}
	public void setNumbertime(Integer numbertime) {
		this.numbertime = numbertime;
	}

	public boolean isVoiceval() {
		return voiceval;
	}

	public void setVoiceval(boolean voiceval) {
		this.voiceval = voiceval;
	}
}
