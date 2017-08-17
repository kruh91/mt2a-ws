package hr.optimit.service;

import java.util.Date;
import java.util.List;

import hr.optimit.dto.UtActivityDTO;
import hr.optimit.hibernate.model.UtActivity;

public interface ActivityService {
	
	public void saveActivity(UtActivityDTO activityDTO) throws Exception;
	
	public List<UtActivityDTO> findActivitiesForUserByStartDateAndEndDate(Date startDate, Date endDate);
}
