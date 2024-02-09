package com.innoclique.controller;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoclique.dto.UserDetails;
import com.innoclique.service.UserManaementService;


/**
 * @author Naveen Kumar Chintala
 */

@RestController
@RequestMapping("/api/v1/user")
@Log4j2
public class UserManagementController {

	
	@Autowired
	UserManaementService userManaementService;
	


    @GetMapping("/userInfo")
    @PreAuthorize("hasRole('Admin')")
    public List<UserRepresentation> userInfo(@RequestBody User user) {

        return userManaementService.userInfo(user);
    }
    
    
    @PostMapping("/createUser")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> createUser(@RequestBody UserDetails userDetails) {

    	log.info("create user is invoked : {}", userDetails);
    	
    	boolean userCreated = userManaementService.createUser(userDetails);
    	
    	String message  = userCreated ? "User created" : "User not created";
    	
    	if(userCreated)
    		return new ResponseEntity<String>(message, HttpStatus.CREATED);
    	else
        	return new ResponseEntity<String>(message, HttpStatus.OK);
        
    }
    
    @PostMapping("/role-mapping")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> roleMapping(@RequestBody UserDetails userDetails) {
    	
    	log.info("create user is invoked : {}", userDetails);
    	
    	boolean roleMapping = userManaementService.roleMapping(userDetails);
    	
    	String message  = roleMapping ? "Role mapped successfully" : "Role mapped failed";
    	
    	if(roleMapping)
    		return new ResponseEntity<String>(message, HttpStatus.CREATED);
    	else
        	return new ResponseEntity<String>(message, HttpStatus.OK);
        
    }
    
    @PostMapping("/resetPassword")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> resetPassword(@RequestBody UserDetails userDetails) {
    	
    	log.info("Reset password request for : {}", userDetails.getUsername());
    	
    	boolean passwordReset = userManaementService.resetPassword(userDetails);
    	
    	String message  = passwordReset ? "Password reset successful" : "Password reset failed";
    	
    	if(passwordReset)
    		return new ResponseEntity<String>(message, HttpStatus.OK);
    	else
        	return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
    @PostMapping("/selfPasswordReset")
    public ResponseEntity<?> selfPasswordReset(@RequestBody UserDetails userDetails) {
    	
    	try {
			
		
    	log.info("Reset password request for : {}", userDetails.getUsername());
    	
    	//VALIDATING USER 
    	AuthzClient authzClient = AuthzClient.create();
		
		AccessTokenResponse response = authzClient.obtainAccessToken(userDetails.getUsername(), userDetails.getPassword());
		
		if(response != null && !response.getToken().isBlank()) {
    	boolean passwordReset = userManaementService.resetPassword(userDetails);
    	
    	String message  = passwordReset ? "Password reset successful" : "Password reset failed";
    	
    	if(passwordReset)
    		return new ResponseEntity<String>(message, HttpStatus.OK);
    	else
        	return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<String>("Invalid user name or password", HttpStatus.UNAUTHORIZED);
		}
    	
    	} catch (Exception e) {
    		log.error("Exception occurred in selfPasswordReset : {} ", e.getMessage());
     		return new ResponseEntity<String>("Invalid user name or password", HttpStatus.UNAUTHORIZED);

		}
    }
}
