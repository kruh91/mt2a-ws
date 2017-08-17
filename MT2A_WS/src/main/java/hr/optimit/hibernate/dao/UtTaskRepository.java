package hr.optimit.hibernate.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.UtTask;

public interface UtTaskRepository extends AbstractJpaRepository<UtTask, Long> {

	public List<UtTask> findByTaskUsersUserUsernameAndTaskUtProjectProjectId(@Param("userUsername") String username,
			@Param("projectId") Long projectId);
}
