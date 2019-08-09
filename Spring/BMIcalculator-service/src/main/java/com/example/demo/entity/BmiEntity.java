package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Entity
@Table(name="bmi")
public class BmiEntity {
	
	
	@Id
	@Column(nullable = false , length = 50 )
	private String email;
	@Column(nullable = false , length = 50 )
	private double bmi;
	
	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	@Column(nullable = false)
	private String activity;
	
	@Column(nullable = false )
	public String plan;
	@Column(nullable = false , length = 50 )
	private String username;
	
	@Column(nullable = false , length = 50 ,name="phonenumber")
	private long mobileno;
	@Column(nullable = false , length = 50 )
	private int age;
	@Column(nullable = false , length = 50 )
	private double height;
	@Column(nullable = false , length = 50 )
	private double weight;

	@Column(nullable = false , length = 50 )
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

	public void setEmail(String email) {
		this.email = email;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	

}
