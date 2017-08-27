package hr.optimit.service;

import java.util.List;

import hr.optimit.dto.UtProjectDTO;

/**
 * The Interface ProjectService.
 */
public interface ProjectService {

	/**
	 * Find projects for user.
	 *
	 * @return the list
	 */
	public List<UtProjectDTO> findProjectsForUser();
}
