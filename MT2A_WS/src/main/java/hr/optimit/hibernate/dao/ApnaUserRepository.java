package hr.optimit.hibernate.dao;

import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.ApnaUser;

/**
 * The Interface ApnaUserRepository.
 */
public interface ApnaUserRepository extends AbstractJpaRepository<ApnaUser, Long> {
	
	/**
	 * Find by user username.
	 *
	 * @param username the username
	 * @return the apna user
	 */
	public ApnaUser findByUserUsername(@Param("username") String username);
	
}
