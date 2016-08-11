package hr.optimit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.optimit.RestResponse;
import hr.optimit.hibernate.model.UtActivity;
import hr.optimit.service.ActivityService;
import hr.optimit.util.Constants;

@RestController
@RequestMapping("/activities")
public class ActivityController extends AbstractController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse saveActivity(@RequestBody UtActivity activity) {

		try {
			activityService.saveActivity(activity);
			return new RestResponse(Constants.RESPONSE_STATUS_OK, "Zapis uspješno spremljen");
		} catch (Exception e) {
			e.printStackTrace();
			return new RestResponse(Constants.RESPONSE_STATUS_ERR, e.getMessage());
		}

	}

}
