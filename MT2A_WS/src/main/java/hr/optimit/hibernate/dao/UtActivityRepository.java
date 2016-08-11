package hr.optimit.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hr.optimit.hibernate.model.UtActivity;

@RepositoryRestResource(collectionResourceRel = "activities", path = "activities")
public interface UtActivityRepository extends AbstractJpaRepository<UtActivity, Long> {
	
	public List<UtActivity> findByActivityUserUserUsernameAndActivityStartDateBetween(@Param("username") String username, 
			@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	@Query("select act from UtActivity act"
			+ " where act.activityUser.userId = :#{#utActivity.activityUser.userId}"
			+ " and act.startDate = :#{#utActivity.startDate}"
			+ " or act.endDate = :#{#utActivity.endDate}"
			+ " or (act.startDate < :#{#utActivity.startDate} and act.endDate > :#{#utActivity.startDate})"
			+ " or (act.startDate < :#{#utActivity.endDate} and act.endDate > :#{#utActivity.endDate})")
	public List<UtActivity> findActivitiesForUserWithDateOverlap(UtActivity utActivity);
	
}
