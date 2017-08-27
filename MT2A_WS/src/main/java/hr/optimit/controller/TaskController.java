package hr.optimit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.optimit.dto.UtTaskDTO;
import hr.optimit.service.TaskService;

/**
 * The Class TaskController.
 */
@RestController
@RequestMapping("/mt2a/api/tasks")
public class TaskController {
	
	/** The task service. */
	@Autowired
	private TaskService taskService;

	/**
	 * Gets the tasks for current user by project id.
	 *
	 * @param projectId the project id
	 * @return the tasks for current user by project id
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UtTaskDTO> getTasksForCurrentUserByProjectId(@RequestParam("projectId") Long projectId) {
		return taskService.findTasksForCurrentUserByProjectId(projectId);
	}
}
