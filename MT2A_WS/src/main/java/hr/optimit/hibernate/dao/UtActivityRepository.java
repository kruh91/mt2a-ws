package hr.optimit.hibernate.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.UtActivity;

/**
 * The Interface UtActivityRepository.
 */
public interface UtActivityRepository extends AbstractJpaRepository<UtActivity, Long> {
	
	/**
	 * Find by activity user user username and activity start date between order by activity start date desc.
	 *
	 * @param username the username
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the list
	 */
	public List<UtActivity> findByActivityUserUserUsernameAndActivityStartDateBetweenOrderByActivityStartDateDesc(String username, 
			@Temporal(TemporalType.TIMESTAMP) Date startDate, 
			@Temporal(TemporalType.TIMESTAMP) Date endDate);
	
	/**
	 * Find activities for user with date overlap.
	 *
	 * @param utActivity the ut activity
	 * @return the list
	 */
	@Query("select act from UtActivity act"
			+ " where act.activityUser.userId = :#{#utActivity.activityUser.userId}"
			+ " and act.activityStartDate = :#{#utActivity.activityStartDate}"
			+ " or act.activityEndDate = :#{#utActivity.activityEndDate}"
			+ " or (act.activityStartDate < :#{#utActivity.activityStartDate} and act.activityEndDate > :#{#utActivity.activityStartDate})"
			+ " or (act.activityStartDate < :#{#utActivity.activityEndDate} and act.activityEndDate > :#{#utActivity.activityEndDate})")
	public List<UtActivity> findActivitiesForUserWithDateOverlap(@Param("utActivity") UtActivity utActivity);
	
}
