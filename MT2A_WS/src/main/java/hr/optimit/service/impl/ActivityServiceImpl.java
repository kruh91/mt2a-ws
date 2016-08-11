package hr.optimit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.optimit.hibernate.dao.UtActivityRepository;
import hr.optimit.hibernate.model.UtActivity;
import hr.optimit.service.ActivityService;

@ComponentScan
@Transactional
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private UtActivityRepository utActivityRepository;

	@Override
	public void saveActivity(UtActivity activity) throws Exception {
	
		List<UtActivity> activityList = utActivityRepository.findActivitiesForUserWithDateOverlap(activity);
		
		if(activityList.isEmpty() 
			|| (activityList.size() == 1 
				&& activityList.get(0).getActivityId().equals(activity.getActivityId())
				)
			){
			
			utActivityRepository.save(activity);
			
		} else {
			throw new Exception("Vremena se preklapaju s drugom aktivnosti!");
		}
		
	}

}
