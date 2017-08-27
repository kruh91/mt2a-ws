package hr.optimit.hibernate.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hr.optimit.hibernate.model.UtLocation;

/**
 * The Interface UtLocationRepository.
 */
public interface UtLocationRepository extends AbstractJpaRepository<UtLocation, Long> {
	
	/**
	 * Find by location ut partner partner id.
	 *
	 * @param partnerId the partner id
	 * @return the list
	 */
	public List<UtLocation> findByLocationUtPartnerPartnerId(@Param("partnerId") Long partnerId);
}
