package comm.example.activityservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ActivityModel {
	
	@NotNull(message = "age cannot be null")
	private String activity;
	
	@NotNull(message = "height cannot be null")
	
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
