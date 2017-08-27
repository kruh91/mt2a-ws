package hr.optimit.service;

import java.util.List;

import hr.optimit.dto.UtTaskDTO;

/**
 * The Interface TaskService.
 */
public interface TaskService {

	/**
	 * Find tasks for current user by project id.
	 *
	 * @param projectId the project id
	 * @return the list
	 */
	public List<UtTaskDTO> findTasksForCurrentUserByProjectId(Long projectId);
}
