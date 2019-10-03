package com.eloisapaz.photoapp.api.users.service;

import com.eloisapaz.photoapp.api.users.ui.model.response.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDetails);
}
