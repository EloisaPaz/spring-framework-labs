package com.eloisapaz.photoapp.api.users.service.impl;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eloisapaz.photoapp.api.users.repository.UsersRepository;
import com.eloisapaz.photoapp.api.users.entity.UserEntity;
import com.eloisapaz.photoapp.api.users.service.UserService;
import com.eloisapaz.photoapp.api.users.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	UsersRepository usersRepository;
	
	@Autowired
	public UserServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("testing");
		usersRepository.save(userEntity);
		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
		return returnValue;
	}

}
