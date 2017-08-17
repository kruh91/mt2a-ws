package hr.optimit.service;

import java.util.List;

import hr.optimit.dto.UtProjectDTO;

public interface ProjectService {

	public List<UtProjectDTO> findProjectsForUser();
}
