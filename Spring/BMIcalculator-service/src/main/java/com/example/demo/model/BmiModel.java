package com.example.demo.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class BmiModel {
	
	
	private String email;
	
	private String username;

	@NotNull(message="age can not be null")
	private int age;
	@NotNull(message="height can not be null")
	private double height;
	@NotNull(message="weight can not be null")
	private int weight;	
//	@NotNull(message="bmi can not be null")
//	private double bmi;
	@NotNull(message="weight can not be null")
	private  long mobileno;
	@NotNull(message="weight can not be null")
	private String plan;
	@NotNull(message="weight can not be null")
	private String activity;
	
	@NotNull(message="weight can not be null")
	private int calories;
	
	
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getEmail() {
		return email;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	
	


}
