package com.innoclique.config;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

/**
 * @author Naveen Kumar Chintala
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	
	 private static final String[] AUTH_WHITELIST = {
	            // -- Swagger UI v2
	            "/v2/api-docs",
	            "/swagger-resources",
	            "/swagger-resources/**",
	            "/configuration/ui",
	            "/configuration/security",
	            "/swagger-ui.html",
	            "/webjars/**",
	            // -- Swagger UI v3 (OpenAPI)
	            "/v3/api-docs/**",
	            "/swagger-ui/**",
	            "/api/v1/login"
	            // other public endpoints of your API may be appended to this array
	    };

	 
    private final JwtAuthConverter jwtAuthConverter = new JwtAuthConverter();

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	 
		http.csrf(AbstractHttpConfigurer::disable).
		authorizeHttpRequests(auth ->  auth
				.requestMatchers(AUTH_WHITELIST).
				permitAll().
				anyRequest().
				authenticated());

		http.oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
				.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter)));

		http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(STATELESS));

        return http.build();
    }
}