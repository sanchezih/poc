package com.bezkoder.spring.security.postgresql.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 public static final String AUTHORIZATION_HEADER = "Authorization";

	  @Bean
	  public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .apiInfo(getApiInfo())
	        .securityContexts(Arrays.asList(securityContext()))
	        .securitySchemes(Arrays.asList(apiKey()))
	        .select()
	        .apis(RequestHandlerSelectors.any())
	        .paths(PathSelectors.any())
	        .build();
	  }

	private ApiInfo getApiInfo() {
		return new ApiInfo("POC JWT API", "POC JWT API Description", "1.0.0", "http://pocjwt.com.ar",
				new Contact("Questionados", "https://questionados.com", "info@questionados.com"), "LICENSE",
				"LICENSE URL", Collections.emptyList()

		);
	}
	
	
	
	  private ApiKey apiKey() {
		    return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
		  }

		  private SecurityContext securityContext() {
		    return SecurityContext.builder()
		        .securityReferences(defaultAuth())
		        .build();
		  }

		  List<SecurityReference> defaultAuth() {
		    AuthorizationScope authorizationScope
		        = new AuthorizationScope("global", "accessEverything");
		    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		    authorizationScopes[0] = authorizationScope;
		    return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
		  }
}