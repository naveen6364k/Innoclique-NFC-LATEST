package com.innoclique.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


/**
 * @author Naveen Kumar Chintala
 */
@Configuration
public class SwaggerConfig {


@Bean
OpenAPI customOpenAPI() {
	
    return new OpenAPI()
            .components(new Components())
            .info(new Info().title("Claim Scient API").description(
                    "This is Spring Boot RESTful service to manage Claim Scient API").version("V1.0"));
}

}
