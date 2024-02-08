package com.innoclique.controller;

import com.innoclique.dto.UserDetails;
import lombok.extern.log4j.Log4j2;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Log4j2
public class LoginController {
	
	 

	@PostMapping("/login")
	public ResponseEntity<?> loginWithCredentials(@RequestBody UserDetails user){


		log.info("Authentication invoked for user  : {}", user.getUsername());
		
		try {
			
		 AuthzClient authzClient = AuthzClient.create();
			
		AccessTokenResponse response = authzClient.obtainAccessToken(user.getUsername(), user.getPassword());
			
		return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

		}

	}
}
