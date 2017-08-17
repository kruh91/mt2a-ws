package hr.optimit.hibernate.dao;

import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.ApnaUser;

public interface ApnaUserRepository extends AbstractJpaRepository<ApnaUser, Long> {
	
	public ApnaUser findByUserUsername(@Param("username") String username);
	
}
