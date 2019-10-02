package com.eloisapaz.photoapp.api.users.service.impl;

import com.eloisapaz.photoapp.api.users.shared.UserDto;

import java.util.UUID;

import com.eloisapaz.photoapp.api.users.service.UserServie;

public class UserServiceImpl implements UserServie {

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		return null;
	}

}
