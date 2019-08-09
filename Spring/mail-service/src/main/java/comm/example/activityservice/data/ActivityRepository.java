package comm.example.activityservice.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import comm.example.activityservice.entity.MailEntity;

public interface ActivityRepository extends JpaRepository<MailEntity, Integer> {

	
	List<MailEntity> findByemailAddress(String email);
	
}
