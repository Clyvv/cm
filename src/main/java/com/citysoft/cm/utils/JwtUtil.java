package com.citysoft.cm.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.citysoft.cm.config.SecurityConstants;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Component
public class JwtUtil {

	public  String  generateToken(UserDetails userDetails) {
		return JWT.create()
				.withSubject(userDetails.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.sign(HMAC512(SecurityConstants.SECRET.getBytes()));
	}
}
