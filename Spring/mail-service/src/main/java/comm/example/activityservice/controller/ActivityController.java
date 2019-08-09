package comm.example.activityservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.example.activityservice.Errors.NoSuchActivityException;
import comm.example.activityservice.entity.MailEntity;

import comm.example.activityservice.entity.ActivityResponseEntity;
import comm.example.activityservice.model.ActivityModel;
import comm.example.activityservice.service.ActivityService;
import comm.example.activityservice.shared.ActivityDto;

@RequestMapping("/")
@RestController
public class ActivityController {

	@Autowired
	private Environment env;

	private ActivityService customerService;

	@Autowired
	public ActivityController(ActivityService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/status/check")
	public String getUsersStatus() {
		return "Customer service: up and running: port No:" + env.getProperty("local.server.port");
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public String CreateUser(@RequestBody ActivityModel customerModel) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	
		MailEntity ac= modelMapper.map(customerModel, MailEntity.class);
		 customerService.createCustomer(ac);
		
		 try {
				customerService.sendEmail(customerModel);
			} catch (MailException mailException) {
				System.out.println(mailException);
			}
		return "sucess";
	}
	@GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE},value="/{email}")
	public  List<MailEntity> GetAllUsers(@PathVariable String email) {
		
		List<ActivityResponseEntity> ure1 = new ArrayList<ActivityResponseEntity>();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		
		List<MailEntity> iter1=  customerService.GetAllPlans(email);
		
		/*System.out.println(iter1);
		for (MailEntity customerEntity : iter1) {
			ure1.add( modelMapper.map(customerEntity, ActivityResponseEntity.class) );
		}
	
		*/
		return iter1;
	}
	
}
