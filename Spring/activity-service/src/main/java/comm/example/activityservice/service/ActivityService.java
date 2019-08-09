package comm.example.activityservice.service;

import java.util.List;

import comm.example.activityservice.Errors.NoSuchActivityException;
import comm.example.activityservice.entity.ActivityEntity;
import comm.example.activityservice.shared.ActivityDto;

public interface ActivityService {
	
	//public ActivityDto createCustomer(ActivityDto uDto);
	
	public List<ActivityEntity> GetAllPlans(String activity);

	//public ActivityDto deleteCustomer(String uId) throws NoSuchActivityException;

	//public ActivityDto findByCustomerId(int id1) throws NoSuchActivityException;

	//public ActivityDto UpdateByCustomer(ActivityEntity customerEntity) throws NoSuchActivityException;
}
