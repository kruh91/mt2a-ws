package hr.optimit.service;

import java.util.List;

import hr.optimit.dto.UtTaskDTO;

public interface TaskService {

	public List<UtTaskDTO> findTasksForCurrentUserByProjectId(Long projectId);
}
