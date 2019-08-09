package comm.example.activityservice.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



import comm.example.activityservice.Errors.NoSuchActivityException;
import comm.example.activityservice.data.ActivityRepository;
import comm.example.activityservice.entity.MailEntity;
import comm.example.activityservice.model.ActivityModel;
import comm.example.activityservice.shared.ActivityDto;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	private ActivityRepository  activityRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository ) {
		super();
		this.activityRepository = activityRepository;
	}
public void sendEmail(ActivityModel ac) throws MailException {

		
		
		

		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(ac.getEmailAddress());
		mail.setSubject("FITNESS REPORT");
		mail.setText("Hi,U have done this activity"+" "+ac.getActivity()+" "+"this many minutes"+" "+ac.getNo_of_minutes()+" ; Thanks Ur fitness team");

		
		javaMailSender.send(mail);
		
	}
	@Override
	public List<MailEntity> GetAllPlans(String email) {
		// TODO Auto-generated method stub
		return activityRepository.findByemailAddress(email) ;
	}
	
@Override
	public void createCustomer(MailEntity ac) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		
		activityRepository.save(ac);
		
	}

	/*@Override
	public Iterable<ActivityEntity> GetAllActivities() {
		return customersRepository.findAll();
	}
*/
/*	@Override
	public ActivityDto deleteCustomer(String uId) throws NoSuchActivityException{
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Optional<ActivityEntity> ueo = customersRepository.findById( Integer.parseInt(uId) );
		
		customersRepository.delete( ueo.get() );
	
		return modelMapper.map( ueo.get(), ActivityDto.class);
	}
	
	@Override
	public ActivityDto findByCustomerId(int uId) throws NoSuchActivityException{
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Optional<ActivityEntity> ueo = customersRepository.findById( uId );
		
		return modelMapper.map( ueo.get(), ActivityDto.class);
	}

	@Override
	public ActivityDto UpdateByCustomer( ActivityEntity customerEntity ) throws NoSuchActivityException {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		ActivityDto uDto = modelMapper.map(customerEntity, ActivityDto.class);
		customersRepository.save(customerEntity);
		return uDto;
	}
*/
}
