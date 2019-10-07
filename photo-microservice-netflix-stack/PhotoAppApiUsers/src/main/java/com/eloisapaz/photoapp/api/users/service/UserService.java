package com.eloisapaz.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.eloisapaz.photoapp.api.users.shared.UserDto;

public interface UserService extends UserDetailsService{
	
	UserDto createUser(UserDto userDetails);
}
