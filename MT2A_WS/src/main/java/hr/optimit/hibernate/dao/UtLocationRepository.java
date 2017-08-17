package hr.optimit.hibernate.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.UtLocation;

public interface UtLocationRepository extends AbstractJpaRepository<UtLocation, Long> {
	
	public List<UtLocation> findByLocationUtPartnerPartnerId(@Param("partnerId") Long partnerId);
}
