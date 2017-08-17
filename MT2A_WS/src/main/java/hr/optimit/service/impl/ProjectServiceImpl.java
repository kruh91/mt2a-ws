package hr.optimit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.optimit.dto.UtConverterUtil;
import hr.optimit.dto.UtProjectDTO;
import hr.optimit.hibernate.dao.UtProjectRepository;
import hr.optimit.hibernate.model.ApnaUser;
import hr.optimit.hibernate.model.UtProject;
import hr.optimit.service.ApnaUserService;
import hr.optimit.service.ProjectService;

@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private UtProjectRepository utProjectRepository;
	
	@Autowired
	private UtConverterUtil utConverterUtil;
	
	@Autowired
	private ApnaUserService apnaUserService;
	
	@Override
	public List<UtProjectDTO> findProjectsForUser() {
		
		ApnaUser currentUser = apnaUserService.getCurrentUser();
		List<UtProjectDTO> dtos = new ArrayList<>();
		List<UtProject> projects = utProjectRepository.findByProjectUsersUserUsername(currentUser.getUserUsername());
		
		for(UtProject project : projects) {
			dtos.add(utConverterUtil.convertUtProjectToDTO(project));
		}
		
		return dtos;
	}

}
