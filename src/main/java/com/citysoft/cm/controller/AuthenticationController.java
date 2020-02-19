package com.citysoft.cm.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citysoft.cm.dto.AuthenticationRequest;
import com.citysoft.cm.dto.AuthenticationResponse;
import com.citysoft.cm.dto.PersonDto;
import com.citysoft.cm.service.IPersonService;
import com.citysoft.cm.service.impl.UserService;
import com.citysoft.cm.utils.JwtUtil;

@RestController
@RequestMapping("/api/v1/authenticate")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	
	@PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			
			final UserDetails userDetails = userService.loadUserByUsername(request.getEmail());
			final String jwt = jwtUtil.generateToken(userDetails);
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}catch(BadCredentialsException e) {
			throw new Exception("Incorect email or password", e);
		}
         
    }
	
	

}
