package comm.example.regservice.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comm.example.regservice.entity.RegEntity;

public interface RegRepository extends CrudRepository<RegEntity, Integer> {

	List<RegEntity> findByEmail(String email);

	List<RegEntity> findByUsername(String username);

	//List<RegEntity> findByemailContainsAndPasswordContains(String email, String password);
	
}
