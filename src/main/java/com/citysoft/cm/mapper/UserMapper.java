package com.citysoft.cm.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citysoft.cm.dto.UserDto;
import com.citysoft.cm.model.User;

@Component
public class UserMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	public UserDto convertToDto(User user) {
		return modelMapper.map(user, UserDto.class);
		
	}
	
	public User convertToEntity(UserDto dto) {
	    return modelMapper.map(dto, User.class);
	}
	public Set<UserDto> convertToDto(List<User> users) {
		
		Set<UserDto> userDto = new HashSet<>();
		for(User user: users) {
			userDto.add(convertToDto(user));
		}
	    return userDto;
	}
}
