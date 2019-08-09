package comm.example.activityservice.service;

import java.util.List;

import comm.example.activityservice.Errors.NoSuchActivityException;
import comm.example.activityservice.entity.MailEntity;
import comm.example.activityservice.model.ActivityModel;
import comm.example.activityservice.shared.ActivityDto;

public interface ActivityService {
	
	public void createCustomer(MailEntity ac);
	
	public List<MailEntity> GetAllPlans(String email);

	public void sendEmail(ActivityModel customerModel);

	//public ActivityDto deleteCustomer(String uId) throws NoSuchActivityException;

	//public ActivityDto findByCustomerId(int id1) throws NoSuchActivityException;

	//public ActivityDto UpdateByCustomer(ActivityEntity customerEntity) throws NoSuchActivityException;
}
