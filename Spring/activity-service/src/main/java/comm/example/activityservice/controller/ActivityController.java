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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.example.activityservice.Errors.NoSuchActivityException;
import comm.example.activityservice.entity.ActivityEntity;
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

	/*@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} , produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CustomerResponseEntity> CreateUser(@RequestBody CustomerModel customerModel) {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		CustomerDto uDto = modelMapper.map(customerModel, CustomerDto.class);

		uDto.setcId(UUID.randomUUID().toString());
		CustomerDto dto1 =  customerService.createCustomer(uDto);
		
		CustomerResponseEntity ore  = modelMapper.map(dto1, CustomerResponseEntity.class);
		
		return new ResponseEntity<CustomerResponseEntity>(ore, HttpStatus.CREATED);
	}
	
	@GetMapping( produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} , value = "/{id1}")
	public ResponseEntity<CustomerResponseEntity> GetUserById(@PathVariable int id1) throws NoSuchCustomerException {
			
			CustomerDto dto1 ;
			
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			
			try {
				dto1 = customerService.findByCustomerId(id1);
			} catch (Exception e) {
				throw new NoSuchCustomerException("No such Customer found with id:"+id1);
			}
			CustomerResponseEntity ore  = modelMapper.map(dto1, CustomerResponseEntity.class);
			return new ResponseEntity<CustomerResponseEntity>(ore, HttpStatus.OK);

	}
*/
	@GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE},value="/{activity}")
	public  List<ActivityResponseEntity> GetAllUsers(@PathVariable String activity) {
		
		List<ActivityResponseEntity> ure1 = new ArrayList<ActivityResponseEntity>();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println(activity);
		
		List<ActivityEntity> iter1=  customerService.GetAllPlans(activity);
		
		
		System.out.println(iter1);
		for (ActivityEntity customerEntity : iter1) {
			ure1.add( modelMapper.map(customerEntity, ActivityResponseEntity.class) );
		}
		
		return ure1;
	}
	
	
}
