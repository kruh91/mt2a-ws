package hr.optimit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.optimit.hibernate.dao.ApnaUserRepository;
import hr.optimit.hibernate.model.ApnaUser;
import hr.optimit.service.ApnaUserService;

/**
 * The Class ApnaUserServiceImpl.
 */
@Transactional
@Service("apnaUserService")
public class ApnaUserServiceImpl implements ApnaUserService {

	/** The apna user repository. */
	@Autowired
	private ApnaUserRepository apnaUserRepository;
	
	@Override
	public ApnaUser getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return apnaUserRepository.findByUserUsername(auth.getName());
	}

}
