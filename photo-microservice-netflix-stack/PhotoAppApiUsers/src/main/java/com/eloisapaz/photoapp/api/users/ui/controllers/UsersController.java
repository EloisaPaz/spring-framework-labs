package com.eloisapaz.photoapp.api.users.ui.controllers;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eloisapaz.photoapp.api.users.service.UserService;
import com.eloisapaz.photoapp.api.users.shared.UserDto;
import com.eloisapaz.photoapp.api.users.ui.model.request.CreateUserRequestModel;
import com.eloisapaz.photoapp.api.users.ui.model.response.CreateUserResponseModel;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/status/check")
	public String status() {
		return "Working on port: " + environment.getProperty("local.server.port");
	}
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		UserDto createdUser = userService.createUser(userDto);
		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

}
