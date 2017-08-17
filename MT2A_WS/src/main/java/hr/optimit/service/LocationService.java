package hr.optimit.service;

import java.util.List;

import hr.optimit.dto.UtLocationDTO;

public interface LocationService {

	public List<UtLocationDTO> findLocationByPartnerId(Long partnerId);
}
