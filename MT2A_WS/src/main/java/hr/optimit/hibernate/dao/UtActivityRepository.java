package hr.optimit.hibernate.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.UtActivity;

public interface UtActivityRepository extends AbstractJpaRepository<UtActivity, Long> {
	
	public List<UtActivity> findByActivityUserUserUsernameAndActivityStartDateBetweenOrderByActivityStartDateDesc(String username, 
			@Temporal(TemporalType.TIMESTAMP) Date startDate, 
			@Temporal(TemporalType.TIMESTAMP) Date endDate);
	
	@Query("select act from UtActivity act"
			+ " where act.activityUser.userId = :#{#utActivity.activityUser.userId}"
			+ " and act.activityStartDate = :#{#utActivity.activityStartDate}"
			+ " or act.activityEndDate = :#{#utActivity.activityEndDate}"
			+ " or (act.activityStartDate < :#{#utActivity.activityStartDate} and act.activityEndDate > :#{#utActivity.activityStartDate})"
			+ " or (act.activityStartDate < :#{#utActivity.activityEndDate} and act.activityEndDate > :#{#utActivity.activityEndDate})")
	public List<UtActivity> findActivitiesForUserWithDateOverlap(@Param("utActivity") UtActivity utActivity);
	
}
