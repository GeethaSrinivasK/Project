package comm.example.activityservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="actvity")
public class ActivityEntity implements Serializable {
	
	private static final long serialVersionUID = 3999182169079251226L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false , length = 50 )
	private String activity;
	
	@Column(nullable = false , length = 120)
	private String plan;
	
	private String time;
	
	private int calories;
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

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

	public ActivityEntity() {
		super();
	}

	
	
	
}
