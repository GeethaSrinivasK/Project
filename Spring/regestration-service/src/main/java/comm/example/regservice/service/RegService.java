package comm.example.regservice.service;

import java.util.List;

import comm.example.regservice.Errors.NoSuchUserException;
import comm.example.regservice.entity.RegEntity;
import comm.example.regservice.entity.RegResponseEntity;
import comm.example.regservice.model.RegModel;
import comm.example.regservice.shared.RegDto;

public interface RegService {
	
	public RegEntity RegesterUser(RegDto uDto);

	List<RegEntity> validate(String Email);

	public List<RegEntity> check(String username);

	public List<RegEntity> find();
	
	/*public Iterable<RegEntity> GetAllCustomers();

	public RegDto deleteCustomer(int uId) throws NoSuchUserException;

	public RegDto findByCustomerId(int id1) throws NoSuchUserException;

	public RegDto UpdateByCustomer(RegEntity customerEntity) throws NoSuchUserException;
	*/
}
