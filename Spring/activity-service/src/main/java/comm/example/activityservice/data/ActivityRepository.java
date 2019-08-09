package comm.example.activityservice.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import comm.example.activityservice.entity.ActivityEntity;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Integer> {

	List<ActivityEntity> findByActivity(String activity);
	
}
