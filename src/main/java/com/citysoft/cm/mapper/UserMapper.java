package com.citysoft.cm.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.citysoft.cm.dto.UserDto;
import com.citysoft.cm.model.User;

@Component
public class UserMapper {

	@Autowired
    private ModelMapper modelMapper;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserDto convertToDto(User user) {
		UserDto dto = modelMapper.map(user, UserDto.class);
		dto.setPassword(null);
		return dto;
	}
	
	public User convertToEntity(UserDto dto) {
		User user = modelMapper.map(dto, User.class);
		user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
	    return user;
	}
	public Set<UserDto> convertToDto(List<User> users) {
		
		Set<UserDto> userDto = new HashSet<>();
		for(User user: users) {
			userDto.add(convertToDto(user));
		}
	    return userDto;
	}
}
