package hr.optimit.service;

import hr.optimit.hibernate.model.ApnaUser;

/**
 * The Interface ApnaUserService.
 */
public interface ApnaUserService {
	
	/**
	 * Gets the current user.
	 *
	 * @return the current user
	 */
	public ApnaUser getCurrentUser();
}
