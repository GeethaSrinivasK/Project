package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BmiEntity;
import com.example.demo.model.BmiModel;
import com.example.demo.service.BmiService;

@RequestMapping("/users")
@RestController

public class BmiController {

		@Autowired
		private Environment env;
		private BmiService bService;
		
		private double bmi;
		
		
		@Autowired
		public BmiController(BmiService bService) {
			super();
			this.bService = bService;
		}
		
		@PostMapping
		public String createUser(@RequestBody BmiModel bModel) {
			
	       bmi =bModel.getWeight()/(bModel.getHeight()*bModel.getHeight()*0.00064516);
	     
	        
			ModelMapper modelMapper=new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		    BmiEntity bmientity=modelMapper.map(bModel,BmiEntity.class);
		    bmientity.setBmi(bmi);
		    bService.createBmi(bmientity);
		    return "user created";
		}
		
		@GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE},value="/{email}")
		public List<BmiEntity> getlist(@PathVariable String email)
		{
			
			 List<BmiEntity> li1=bService.getall(email);
			
			return li1;
		}
      
}
