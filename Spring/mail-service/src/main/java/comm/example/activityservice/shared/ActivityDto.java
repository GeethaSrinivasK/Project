package comm.example.activityservice.shared;

import java.io.Serializable;

public class ActivityDto implements Serializable {

	private static final long serialVersionUID = 2148301679678484834L;

	private String activity;
	
	private String plan;

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	

	
}
