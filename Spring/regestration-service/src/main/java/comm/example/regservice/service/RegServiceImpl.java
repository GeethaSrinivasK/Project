package comm.example.regservice.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.example.regservice.Errors.NoSuchUserException;
import comm.example.regservice.data.RegRepository;
import comm.example.regservice.entity.RegEntity;
import comm.example.regservice.shared.RegDto;

@Service
public class RegServiceImpl implements RegService {
	
	private RegRepository customersRepository;
	
	@Autowired
	public RegServiceImpl(RegRepository customersRepository ) {
		super();
		this.customersRepository = customersRepository;
	}
	
	@Override
	public RegEntity RegesterUser(RegDto uDto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		RegEntity customerEntity = modelMapper.map(uDto, RegEntity.class);
		
		return customersRepository.save(customerEntity);
	}

	
	@Override
	public List<RegEntity> validate(String Email) {
		// TODO Auto-generated method stub
		return customersRepository.findByEmail(Email);
	}
	/*@Override
	public Iterable<RegEntity> GetAllCustomers() {
		return customersRepository.findAll();
	}

	@Override
	public RegDto deleteCustomer(int uId) throws NoSuchUserException{
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Optional<RegEntity> ueo = customersRepository.findById(uId);
		
		customersRepository.delete( ueo.get() );
	
		return modelMapper.map( ueo.get(), RegDto.class);
	}
	
	@Override
	public RegDto findByCustomerId(int uId) throws NoSuchUserException{
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Optional<RegEntity> ueo = customersRepository.findById( uId );
		
		return modelMapper.map( ueo.get(), RegDto.class);
	}

	@Override
	public RegDto UpdateByCustomer( RegEntity customerEntity ) throws NoSuchUserException {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		RegDto uDto = modelMapper.map(customerEntity, RegDto.class);
		customersRepository.save(customerEntity);
		return uDto;
	}
	*/

	@Override
	public List<RegEntity> check(String username) {
		// TODO Auto-generated method stub
		return customersRepository.findByUsername(username);
	}

	@Override
	public List<RegEntity> find() {
		// TODO Auto-generated method stub
		return (List<RegEntity>) customersRepository.findAll();
	}

}
