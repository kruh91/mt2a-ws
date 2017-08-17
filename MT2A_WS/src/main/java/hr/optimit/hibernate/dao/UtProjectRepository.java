package hr.optimit.hibernate.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.UtProject;

public interface UtProjectRepository extends AbstractJpaRepository<UtProject, Long> {
	
	public List<UtProject> findByProjectUsersUserUsername(@Param("userUsername") String username);
}
