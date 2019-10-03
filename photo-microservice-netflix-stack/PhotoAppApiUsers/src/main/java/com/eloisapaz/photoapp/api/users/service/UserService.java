package com.eloisapaz.photoapp.api.users.service;

import com.eloisapaz.photoapp.api.users.shared.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDetails);
}
