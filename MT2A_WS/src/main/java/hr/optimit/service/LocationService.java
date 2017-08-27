package hr.optimit.service;

import java.util.List;

import hr.optimit.dto.UtLocationDTO;

/**
 * The Interface LocationService.
 */
public interface LocationService {

	/**
	 * Find location by partner id.
	 *
	 * @param partnerId the partner id
	 * @return the list
	 */
	public List<UtLocationDTO> findLocationByPartnerId(Long partnerId);
}
