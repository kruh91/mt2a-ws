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
			+ " and act.activityStartDate = :#{#utActivity.activityStartDate}"
			+ " or act.activityEndDate = :#{#utActivity.activityEndDate}"
			+ " or (act.activityStartDate < :#{#utActivity.activityStartDate} and act.activityEndDate > :#{#utActivity.activityStartDate})"
			+ " or (act.activityStartDate < :#{#utActivity.activityEndDate} and act.activityEndDate > :#{#utActivity.activityEndDate})")
	public List<UtActivity> findActivitiesForUserWithDateOverlap(UtActivity utActivity);
	
}
