package hr.optimit.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hr.optimit.hibernate.model.UtActivity;

@RepositoryRestResource(collectionResourceRel = "activity", path = "activity")
public interface UtActivityRepository extends JpaRepository<UtActivity, Long> {
	
	public List<UtActivity> findByActivityUserUserUsernameAndActivityStartDateBetween(@Param("username") String username, 
			@Param("startDate") String startDate, @Param("endDate") String endDate);
	
}
