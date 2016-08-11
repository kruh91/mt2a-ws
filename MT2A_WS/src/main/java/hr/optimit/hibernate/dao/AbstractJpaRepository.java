package hr.optimit.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface AbstractJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	
	@Override
	@RestResource(exported = false)
	<S extends T> List<S> save(Iterable<S> entities);
	
	@Override
	@RestResource(exported = false)
	<S extends T> S save(S arg0);
	
	@Override
	@RestResource(exported = false)
	<S extends T> S saveAndFlush(S entity);

}
