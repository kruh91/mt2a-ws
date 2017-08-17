package hr.optimit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.optimit.RestResponse;
import hr.optimit.dto.UtActivityDTO;
import hr.optimit.hibernate.model.UtActivity;
import hr.optimit.service.ActivityService;
import hr.optimit.util.Constants;

@RestController
@RequestMapping("/mt2a/api/activities")
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse saveActivity(@RequestBody UtActivityDTO activityDTO) {

		try {
			activityService.saveActivity(activityDTO);
			return new RestResponse(Constants.RESPONSE_STATUS_OK, "Zapis uspješno spremljen");
		} catch (Exception e) {
			e.printStackTrace();
			return new RestResponse(Constants.RESPONSE_STATUS_ERR, e.getMessage());
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UtActivityDTO> findActivitiesForUserByStartDateAndEndDate(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {

		return activityService.findActivitiesForUserByStartDateAndEndDate(startDate, endDate);
	}
}
