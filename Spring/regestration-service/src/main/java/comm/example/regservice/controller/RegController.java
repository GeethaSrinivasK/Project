package comm.example.regservice.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import comm.example.regservice.Errors.NoSuchUserException;
import comm.example.regservice.entity.RegEntity;
import comm.example.regservice.entity.RegResponseEntity;
import comm.example.regservice.model.LoginModel;
import comm.example.regservice.model.RegModel;
import comm.example.regservice.service.RegService;
import comm.example.regservice.shared.RegDto;


@RequestMapping("/")
@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegController {

	@Autowired
	private Environment env;

	private RegService customerService;

	@Autowired
	public RegController(RegService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/status/check")
	public String getUsersStatus() {
		return "Customer service: up and running: port No:" + env.getProperty("local.server.port");
	}

	/*@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public String CreateUser(@RequestBody RegModel productModel) throws JsonProcessingException, ParseException {

		ModelMapper modelMapper = new ModelMapper();
		ObjectMapper mapper=new ObjectMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		String res;
		List<RegEntity> li=customerService.validate(productModel.getEmail());
		if(li.size()>=1)
		res= "Email already exists";
		else {
			li=customerService.check(productModel.getUsername());
			if(li.size()>=1)
				res="Username already exists";
				else
				{
					String s =productModel.getDob();
					  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					  Date d = sdf.parse(s);
					  Calendar c = Calendar.getInstance();
					  c.setTime(d);
					  int year = c.get(Calendar.YEAR);
					  int month = c.get(Calendar.MONTH) + 1;
					  int date = c.get(Calendar.DATE);
					  LocalDate l1 = LocalDate.of(year, month, date);
					  LocalDate now1 = LocalDate.now();
					  Period diff1 = Period.between(l1, now1);
					  System.out.println("age:" + diff1.getYears() + "years");
					  if(diff1.getYears() <20)
						 res="Minimum age should be 20";
		    	    else {
					RegDto uDto = modelMapper.map(productModel, RegDto.class);

					//uDto.setId(UUID.randomUUID().toString());
					RegEntity dto1 =  customerService.RegesterUser(uDto);
					
					res= "Registered Successfully";
		    	    }
					
				}
		}
		
		 return (mapper.writeValueAsString(res));
		
	}
	*/
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	
	public List<RegEntity> validate() throws JsonProcessingException
	{
		
		String res;
		List<RegEntity> li=customerService.find();
		
		return li;
		
	}
	
	
	@PostMapping
	public String  check(@RequestBody RegModel productModel)
	{
		ModelMapper modelMapper = new ModelMapper();
		ObjectMapper mapper=new ObjectMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		RegDto uDto = modelMapper.map(productModel, RegDto.class);

		//uDto.setId(UUID.randomUUID().toString());
		RegEntity dto1 =  customerService.RegesterUser(uDto);
		return "success";
		
	}
}
