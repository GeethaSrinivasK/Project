package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.BmiRepository;
import com.example.demo.entity.BmiEntity;
@Service
public class BmiServiceImpl implements BmiService {
	
	private BmiRepository bmiRepository;
	
	@Autowired
	public BmiServiceImpl(BmiRepository bmiRepository) {
		super();
		this.bmiRepository = bmiRepository;
	}




	@Override
	public BmiEntity createBmi(BmiEntity bentity) {
		// TODO Auto-generated method stub
//		ModelMapper modelMapper=new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		bmiRepository.save(bentity);
		return null;
	}




	@Override
	public List<BmiEntity> getall(String email) {
		// TODO Auto-generated method stub
		return bmiRepository.findByEmail(email);
	}

}
