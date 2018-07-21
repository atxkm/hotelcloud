package cn.zhsit.common.utils;

public class CommResult {
	public static final String version = "bu489dqrur331xs1hrx82n1vb";
	private String Message;
	private String Success;
	private SessionRes Session=null;
	private Object data;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getSuccess() {
		return Success;
	}
	public void setSuccess(String success) {
		Success = success;
	}
	public SessionRes getSession() {
		if(Session==null){
			Session = new SessionRes();
			Session.setStatus("Logined");
			Session.setVersion(version);
		}
		return Session;
	}
	public void setSession(SessionRes session) {
		
		Session = session;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
