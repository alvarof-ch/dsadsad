package com.example.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import org.springdoc.core.models.GroupedOpenApi;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@SecurityScheme
@SecurityScheme(type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.DEFAULT, name = "JWT", scheme = "bearer")
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi apiClave() {
		return GroupedOpenApi.builder().group("/api/v1-clave").pathsToMatch("/clave/**").build();
	}

	@Bean
	public GroupedOpenApi apiClaveedificacion() {
		return GroupedOpenApi.builder().group("/api/v1-clave-edificacion").pathsToMatch("/clave-edificacion/**")
				.build();
	}

	@Bean
	public GroupedOpenApi apiAuth() {
		return GroupedOpenApi.builder().group("auth").pathsToMatch("/api/auth/**").build();
	}

	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI().info(new Info().title("Documentación Proyecto 1")
				.description("Descripción de la documentación del Proyecto 1").version("1.0.0"));
	}
}