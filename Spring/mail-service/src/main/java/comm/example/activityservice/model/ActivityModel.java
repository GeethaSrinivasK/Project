package comm.example.activityservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ActivityModel {
	
	@NotNull(message = "age cannot be null")
	private String activity;

	@NotNull(message = "age cannot be null")
	private int no_of_minutes;
	@NotNull(message = "age cannot be null")
	private String emailAddress;

	@NotNull(message = "age cannot be null")
	private String Day;
	
	@NotNull(message = "age cannot be null")
	private int calories;

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getNo_of_minutes() {
		return no_of_minutes;
	}

	public void setNo_of_minutes(int no_of_minutes) {
		this.no_of_minutes = no_of_minutes;
	}

	
	
	
	
}
