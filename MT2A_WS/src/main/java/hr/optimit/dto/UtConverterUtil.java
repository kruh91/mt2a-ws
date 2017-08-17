package hr.optimit.dto;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.optimit.hibernate.dao.UtActivityRepository;
import hr.optimit.hibernate.dao.UtLocationRepository;
import hr.optimit.hibernate.dao.UtTaskRepository;
import hr.optimit.hibernate.model.ApnaUser;
import hr.optimit.hibernate.model.UtActivity;
import hr.optimit.hibernate.model.UtLocation;
import hr.optimit.hibernate.model.UtProject;
import hr.optimit.hibernate.model.UtTask;
import hr.optimit.service.ApnaUserService;

@Component("utConverterUtil")
public class UtConverterUtil {

	@Autowired
	private UtActivityRepository utActivityRepository;

	@Autowired
	private UtLocationRepository utLocationRepository;

	@Autowired
	private UtTaskRepository utTaskRepository;

	@Autowired
	private ApnaUserService apnaUserService;

	public UtActivityDTO convertUtActivtyToDTO(UtActivity activity) {

		UtActivityDTO dto = new UtActivityDTO();
		dto.setBillable(activity.getActivityBillable());
		dto.setDescription(activity.getActivityDescription());
		dto.setEndDate(activity.getActivityEndDate());
		dto.setId(activity.getActivityId());
		dto.setModifTime(activity.getActivityModifTime());
		dto.setModifUserId(activity.getActivityModifUser().getUserId());
		dto.setRef(activity.getActivityRef());
		dto.setStartDate(activity.getActivityStartDate());
		dto.setUserId(activity.getActivityUser().getUserId());
		dto.setUtLocationId(activity.getActivityUtLocation().getLocationId());
		UtTask task = activity.getActivityUtTask();
		dto.setUtTaskId(task.getTaskId());
		dto.setUtTaskName(task.getTaskName());
		UtProject project = task.getTaskUtProject();
		dto.setUtProjectShortName(project.getProjectShortname());
		dto.setUtProjectName(project.getProjectName());
		dto.setUtProjectId(project.getProjectId());
		
		return dto;
	}

	public UtActivity convertUtActivtyDtoToUtActivity(UtActivityDTO dto) {

		UtActivity utActivity = null;
		Long id = dto.getId();
		ApnaUser currentUser = apnaUserService.getCurrentUser();
		Date modifDate = new Date();
		if (id != null) {
			utActivity = utActivityRepository.findOne(id);
		}

		if (utActivity == null) {
			utActivity = new UtActivity();
			utActivity.setActivityUser(currentUser);
		}

		utActivity.setActivityModifUser(currentUser);
		utActivity.setActivityModifTime(new Timestamp(modifDate.getTime()));
		utActivity.setActivityBillable(dto.getBillable());
		utActivity.setActivityStartDate(getDateWithMinutePrecision(dto.getStartDate()));
		utActivity.setActivityEndDate(getDateWithMinutePrecision(dto.getEndDate()));
		utActivity.setActivityDescription(dto.getDescription());
		utActivity.setActivityUtLocation(utLocationRepository.findOne(dto.getUtLocationId()));
		utActivity.setActivityUtTask(utTaskRepository.findOne(dto.getUtTaskId()));

		return utActivity;
	}

	public UtLocationDTO convertUtLocationToDTO(UtLocation location) {

		UtLocationDTO dto = new UtLocationDTO();
		dto.setId(location.getLocationId());
		dto.setLocationName(location.getLocationName());

		return dto;
	}

	public UtProjectDTO convertUtProjectToDTO(UtProject project) {

		UtProjectDTO dto = new UtProjectDTO();
		dto.setId(project.getProjectId());
		dto.setProjectName(project.getProjectName());
		dto.setProjectShortname(project.getProjectShortname());
		dto.setProjectStartDate(project.getProjectStartDate());
		dto.setProjectEndDate(project.getProjectEndDate());
		dto.setPartnerId(project.getProjectUtPartner().getPartnerId());

		return dto;
	}

	public UtTaskDTO convertUtTaskToDTO(UtTask task) {

		UtTaskDTO dto = new UtTaskDTO();
		dto.setId(task.getTaskId());
		dto.setProjectId(task.getTaskUtProject().getProjectId());
		dto.setTaskName(task.getTaskName());
		dto.setTaskStartDate(task.getTaskStartDate());
		dto.setTaskEndDate(task.getTaskEndDate());

		return dto;
	}
	
	private Date getDateWithMinutePrecision(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTime();
	}
}
