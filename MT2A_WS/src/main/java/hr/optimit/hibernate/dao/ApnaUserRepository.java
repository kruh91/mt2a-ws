package hr.optimit.hibernate.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hr.optimit.hibernate.model.ApnaUser;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface ApnaUserRepository extends AbstractJpaRepository<ApnaUser, Long> {
	
	public ApnaUser findByUserUsername(@Param("username") String username);
	
}
