package comm.example.regservice.Errors;

import java.sql.Timestamp;

public class RunTime_Errors {
	
	private Timestamp timestamp;
	private String message;
	private int status;
	
	public RunTime_Errors() {
		super();
	}
	public RunTime_Errors(Timestamp timestamp, String message, int status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "RunTime_Errors [timestamp=" + timestamp + ", message=" + message + ", status=" + status + "]";
	}
	
	
}
