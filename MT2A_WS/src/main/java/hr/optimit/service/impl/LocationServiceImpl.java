package hr.optimit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.optimit.dto.UtConverterUtil;
import hr.optimit.dto.UtLocationDTO;
import hr.optimit.hibernate.dao.UtLocationRepository;
import hr.optimit.hibernate.model.UtLocation;
import hr.optimit.service.LocationService;

/**
 * The Class LocationServiceImpl.
 */
@Transactional
@Service("locationService")
public class LocationServiceImpl implements LocationService {
	
	/** The ut location repository. */
	@Autowired
	private UtLocationRepository utLocationRepository;
	
	/** The ut converter util. */
	@Autowired
	private UtConverterUtil utConverterUtil;

	@Override
	public List<UtLocationDTO> findLocationByPartnerId(Long partnerId) {
		
		List<UtLocationDTO> dtos = new ArrayList<>();
		List<UtLocation> locations = utLocationRepository.findByLocationUtPartnerPartnerId(partnerId);
		
		for(UtLocation location : locations) {
			dtos.add(utConverterUtil.convertUtLocationToDTO(location));
		}
		
		return dtos;
	}

}
