package hr.optimit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.optimit.dto.UtConverterUtil;
import hr.optimit.dto.UtTaskDTO;
import hr.optimit.hibernate.dao.UtTaskRepository;
import hr.optimit.hibernate.model.ApnaUser;
import hr.optimit.hibernate.model.UtTask;
import hr.optimit.service.ApnaUserService;
import hr.optimit.service.TaskService;

@Transactional
@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Autowired
	private UtTaskRepository utTaskRepository;
	
	@Autowired
	private UtConverterUtil utConverterUtil;
	
	@Autowired
	private ApnaUserService apnaUserService;
	
	@Override
	public List<UtTaskDTO> findTasksForCurrentUserByProjectId(Long projectId) {
		
		ApnaUser currentUser = apnaUserService.getCurrentUser();
		List<UtTaskDTO> dtos = new ArrayList<>();
		List<UtTask> tasks = utTaskRepository.findByTaskUsersUserUsernameAndTaskUtProjectProjectId(currentUser.getUserUsername(), projectId);
		
		for(UtTask task : tasks) {
			dtos.add(utConverterUtil.convertUtTaskToDTO(task));
		}
		
		return dtos;
	}
}
