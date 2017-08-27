package hr.optimit.service;

import java.util.Date;
import java.util.List;

import hr.optimit.dto.UtActivityDTO;
import hr.optimit.hibernate.model.UtActivity;

/**
 * The Interface ActivityService.
 */
public interface ActivityService {
	
	/**
	 * Save activity.
	 *
	 * @param activityDTO the activity DTO
	 * @throws Exception the exception
	 */
	public void saveActivity(UtActivityDTO activityDTO) throws Exception;
	
	/**
	 * Find activities for user by start date and end date.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the list
	 */
	public List<UtActivityDTO> findActivitiesForUserByStartDateAndEndDate(Date startDate, Date endDate);
}
