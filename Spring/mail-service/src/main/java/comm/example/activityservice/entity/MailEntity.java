package comm.example.activityservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="mail")
public class MailEntity implements Serializable {
	
	private static final long serialVersionUID = 3999182169079251226L;
	
	
	
    @Id
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false , length = 50,unique=true )
	private String Day;
	
	
	

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

	private int calories;
	@Column(nullable = false , length = 50 )
	private String activity;
	
	@Column(nullable = false , length = 50,name="email_address" )
	private String emailAddress;
	
	@Column(nullable = false , length = 50 )
	private int no_of_minutes;



	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getNo_of_minutes() {
		return no_of_minutes;
	}

	public void setNo_of_minutes(int no_of_minutes) {
		this.no_of_minutes = no_of_minutes;
	}

	
	

	
	
	
}
