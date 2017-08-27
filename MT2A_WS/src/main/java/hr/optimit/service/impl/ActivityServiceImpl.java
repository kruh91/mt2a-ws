package hr.optimit.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.optimit.dto.UtActivityDTO;
import hr.optimit.dto.UtConverterUtil;
import hr.optimit.hibernate.dao.UtActivityRepository;
import hr.optimit.hibernate.model.ApnaUser;
import hr.optimit.hibernate.model.UtActivity;
import hr.optimit.service.ActivityService;
import hr.optimit.service.ApnaUserService;

/**
 * The Class ActivityServiceImpl.
 */
@Transactional
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

	/** The ut activity repository. */
	@Autowired
	private UtActivityRepository utActivityRepository;

	/** The ut converter util. */
	@Autowired
	private UtConverterUtil utConverterUtil;

	/** The apna user service. */
	@Autowired
	private ApnaUserService apnaUserService;

	@Override
	public void saveActivity(UtActivityDTO activityDTO) throws Exception {

		UtActivity activity = utConverterUtil.convertUtActivtyDtoToUtActivity(activityDTO);

		List<UtActivity> activityList = utActivityRepository.findActivitiesForUserWithDateOverlap(activity);

		if (!activityList.isEmpty()
				&& (activityList.size() > 1 || !activityList.get(0).getActivityId().equals(activity.getActivityId()))) {

			throw new Exception("Vremena se preklapaju s drugom aktivnosti!");
		}

		utActivityRepository.save(activity);
	}

	@Override
	public List<UtActivityDTO> findActivitiesForUserByStartDateAndEndDate(Date startDate, Date endDate) {

		ApnaUser currentUser = apnaUserService.getCurrentUser();
		List<UtActivity> activities = new ArrayList<>();
		activities.addAll(utActivityRepository
				.findByActivityUserUserUsernameAndActivityStartDateBetweenOrderByActivityStartDateDesc(
						currentUser.getUserUsername(), startDate, endDate));
		List<UtActivityDTO> dtos = new ArrayList<>();

		for (UtActivity activity : activities) {
			dtos.add(utConverterUtil.convertUtActivtyToDTO(activity));
		}

		return dtos;
	}
}
