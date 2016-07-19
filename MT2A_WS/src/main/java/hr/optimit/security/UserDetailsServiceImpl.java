package hr.optimit.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.optimit.hibernate.dao.ApnaUserRepository;
import hr.optimit.hibernate.model.ApnaUser;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private ApnaUserRepository apnaUserRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {

	    log.debug("Authenticating {}", username);
	    
	    ApnaUser userFromDatabase = apnaUserRepository.findByUserUsername(username);
	    
	    if (userFromDatabase == null) {
	        throw new UsernameNotFoundException("User " + username + " was not found in the database!");
	    }
	
	    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	//    for (Authority authority : userFromDatabase.getAuthorities()) {
	//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
	//        grantedAuthorities.add(grantedAuthority);
	//    }
	
	    return new User(userFromDatabase.getUserUsername(), userFromDatabase.getUserPassword(), grantedAuthorities);

	}
}
