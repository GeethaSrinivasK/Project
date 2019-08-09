package comm.example.activityservice.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.example.activityservice.Errors.NoSuchActivityException;
import comm.example.activityservice.data.ActivityRepository;
import comm.example.activityservice.entity.ActivityEntity;
import comm.example.activityservice.shared.ActivityDto;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	private ActivityRepository  activityRepository;
	
	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository ) {
		super();
		this.activityRepository = activityRepository;
	}

	@Override
	public List<ActivityEntity> GetAllPlans(String activity) {
		// TODO Auto-generated method stub
		return activityRepository.findByActivity(activity) ;
	}
	
	/*@Override
	public ActivityDto createCustomer(ActivityDto uDto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		ActivityEntity customerEntity = modelMapper.map(uDto, ActivityEntity.class);
		customersRepository.save(customerEntity);
		return uDto;
	}
*/
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
