package com.github.sanchezih.market.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig1 extends WebSecurityConfigurerAdapter {

	/**
	 * Configuring the api according to the roles.
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf().disable() // Disable the CSRF feature.
				.authorizeRequests().anyRequest().authenticated()// All requests to our application requires
				.and().httpBasic(); // Allow users to use HTTP basic authentication.
	}

	/**
	 * In this method we are creating in memory user authentication details.
	 * 
	 * With Spring Boot, we can always configure default user and password using the
	 * application.properties file (We can omit the
	 * configureGlobal(AuthenticationManagerBuilder authentication)method from above
	 * code).
	 * 
	 * @param authentication
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
		authentication.inMemoryAuthentication() //
				.withUser("admin") //
				.password(passwordEncoder().encode("nimda"))//
				.authorities("ROLE_USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}