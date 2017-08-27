package hr.optimit.hibernate.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.UtProject;

/**
 * The Interface UtProjectRepository.
 */
public interface UtProjectRepository extends AbstractJpaRepository<UtProject, Long> {
	
	/**
	 * Find by project users user username.
	 *
	 * @param username the username
	 * @return the list
	 */
	public List<UtProject> findByProjectUsersUserUsername(@Param("userUsername") String username);
}
