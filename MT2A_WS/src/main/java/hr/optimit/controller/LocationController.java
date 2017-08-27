package hr.optimit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.optimit.dto.UtLocationDTO;
import hr.optimit.service.LocationService;

/**
 * The Class LocationController.
 */
@RestController
@RequestMapping("/mt2a/api/locations")
public class LocationController {
	
	/** The location service. */
	@Autowired
	private LocationService locationService;
	
	/**
	 * Find location by partner id.
	 *
	 * @param partnerId the partner id
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UtLocationDTO> findLocationByPartnerId(@RequestParam("partnerId") Long partnerId) {
		return locationService.findLocationByPartnerId(partnerId);
	}
}
