package hr.optimit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.optimit.dto.UtProjectDTO;
import hr.optimit.service.ProjectService;

@RestController
@RequestMapping("/mt2a/api/projects")
public class ProjectController extends AbstractController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UtProjectDTO> findProjectsForUser() {
		return projectService.findProjectsForUser();
	}
}
