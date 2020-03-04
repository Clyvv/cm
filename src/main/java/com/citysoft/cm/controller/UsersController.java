package com.citysoft.cm.controller;

import com.citysoft.cm.dto.UserDto;
import com.citysoft.cm.mapper.UserMapper;
import com.citysoft.cm.model.User;
import com.citysoft.cm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

	@PostMapping("/sign-up")
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
	    User user = userMapper.convertToEntity(userDto);
	    userRepository.save(user);
	    return ResponseEntity.accepted().body(null);
    }
}
