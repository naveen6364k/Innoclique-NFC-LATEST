package com.innoclique.config;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author Naveen Kumar Chintala
 */
@Configuration
public class KeyCloakConfig {

	    @Bean
	    Keycloak keycloak() {
	    return  KeycloakBuilder.builder()
	            .serverUrl("http://localhost:8080")
	            .realm("master")
	            .username("admin")
	            .password("admin")
	            .clientId("admin-cli")
	            .resteasyClient(new ResteasyClientBuilderImpl().connectionPoolSize(10).build())
	            .build();
	    }
}
