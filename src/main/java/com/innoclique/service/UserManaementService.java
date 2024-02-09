package com.innoclique.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.innoclique.constants.AppConstants;
import com.innoclique.dto.UserDetails;

import jakarta.ws.rs.core.Response;
import lombok.extern.log4j.Log4j2;

/**
 * @author Naveen Kumar Chintala
 */

@Service
@Log4j2
public class UserManaementService {
	
	@Autowired
	Keycloak keycloak;
	
	public RealmResource getRealm() {
        return keycloak.realm(AppConstants.REALM_NAME);
    }

	public List<UserRepresentation> userInfo(User user) {
		
       return getRealm()
			   .users()
			   .searchByUsername(user.getName(), true);
	}

	public boolean createUser(UserDetails userDetails) {
		
		UserRepresentation userRepresentation = new UserRepresentation();

		userRepresentation.setUsername(userDetails.getUsername());
		userRepresentation.setFirstName(userDetails.getFirstName());
		userRepresentation.setLastName(userDetails.getLastName());
		userRepresentation.setEmail(userDetails.getEmail());
		userRepresentation.setEnabled(userDetails.getEnabled());
		userRepresentation.setEmailVerified(userDetails.getEmailVerified());

		Response response = getRealm().users().create(userRepresentation);

		log.info("User creation status : {} for user Name : {}", response.getStatus(), userDetails.getUsername());

		if(response.getStatus() == 201) {
		// Set password flow
		CredentialRepresentation passwordCred = new CredentialRepresentation();
		String userId = CreatedResponseUtil.getCreatedId(response);
		passwordCred.setTemporary(false);
		passwordCred.setType("password");
		passwordCred.setValue(userDetails.getPassword());
		UserResource userResource = getRealm().users().get(userId);
		userResource.resetPassword(passwordCred);
		
		return true;
		}else {
			log.info("User is not created for user name : {} and status : {}", userDetails.getUsername(), response.getStatus());
			return true;
		}
	}
	
	
	public boolean resetPassword(UserDetails userDetails) {
		
		 List<UserRepresentation> users = getRealm()
			      .users()
			      .searchByUsername(userDetails.getUsername(), true);
		 
			log.info("User details size : {}", users.size());

		
		//FILTERING FIRST USER FROM THE LIST
		Optional<UserRepresentation> userRepresentation = users.stream().filter(user -> user.getUsername().equalsIgnoreCase(userDetails.getUsername())).findFirst();
		
		
		if(userRepresentation.isPresent()) {
			
		log.info("User details for reset password : {}", userRepresentation.get());
		
		CredentialRepresentation passwordCred = new CredentialRepresentation();

		passwordCred.setTemporary(false);
		passwordCred.setType("password");
		passwordCred.setValue(userDetails.getPassword());
		
		try {
		
		UserResource userResource = getRealm().users().get(userRepresentation.get().getId());
		userResource.resetPassword(passwordCred);
		return true;
		} catch (Exception e) {
			log.error("Exception occurred reset password : {}", e.getMessage());
			return false;
		}
		

	}
		return false;
	
	

}

	public boolean roleMapping(UserDetails userDetails) {

		
		 List<UserRepresentation> users = getRealm()
			      .users()
			      .searchByUsername(userDetails.getUsername(), true);
		 
			log.info("User details size : {}", users.size());

			
			
		
		//FILTERIN FIRS USER FROM TE LIST
		Optional<UserRepresentation> userRepresentation = users.stream().filter(user -> user.getUsername().equals(userDetails.getUsername())).findFirst();
		
		
		if(userRepresentation.isPresent()) {
			
		log.info("User details for roleMapping : {}", userRepresentation.get());
		
		CredentialRepresentation passwordCred = new CredentialRepresentation();

		passwordCred.setTemporary(false);
		passwordCred.setType("password");
		passwordCred.setValue(userDetails.getPassword());
		
		try {
		
		UserResource userResource = getRealm().users().get(userRepresentation.get().getId());
		
		
		List<RoleRepresentation> roles = getRealm().roles().list();
		
		List<RoleRepresentation> assignedRoles = roles.stream().filter(role -> (role.getName().equals("User") || role.getName().equals("Admin"))).toList();
		userResource.roles().realmLevel().add(assignedRoles);
		
		return true;
		} catch (Exception e) {
			log.error("Exception occured in roleMapping : {}", e.getMessage());
			return false;
		}
		

	}
		return false;
	

	}
	
}
