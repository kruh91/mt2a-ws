package hr.optimit.hibernate.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.UtTask;

/**
 * The Interface UtTaskRepository.
 */
public interface UtTaskRepository extends AbstractJpaRepository<UtTask, Long> {

	/**
	 * Find by task users user username and task ut project project id.
	 *
	 * @param username the username
	 * @param projectId the project id
	 * @return the list
	 */
	public List<UtTask> findByTaskUsersUserUsernameAndTaskUtProjectProjectId(@Param("userUsername") String username,
			@Param("projectId") Long projectId);
}
