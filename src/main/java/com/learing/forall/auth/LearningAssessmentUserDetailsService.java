package com.learing.forall.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LearningAssessmentUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Autowired
	public LearningAssessmentUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("User for usrname :"+username);
		User user = userRepository.findByUsername(username);
		System.out.println("User is :"+user);
		if (null==user) {
			throw new UsernameNotFoundException("Can not find username: "+username);
		}
		return new LearningAssessmentPrincipal(user);
	}

}
