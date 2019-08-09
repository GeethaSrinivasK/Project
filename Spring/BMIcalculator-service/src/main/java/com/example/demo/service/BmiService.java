package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.BmiEntity;

public interface BmiService {
	public BmiEntity createBmi(BmiEntity bentity);

	public List<BmiEntity> getall(String email);
}
