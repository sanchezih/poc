package com.github.sanchezih.market.security;
//package com.github.sanchezih.market.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {
//
//	/**
//	 * Configuring the api according to the roles.
//	 */
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity //
//				.csrf().disable() //
//				.authorizeRequests() //
//				.antMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("maestro") //
//				.antMatchers(HttpMethod.PUT, "/api/products").hasRole("maestro") //
//				.antMatchers(HttpMethod.POST, "/api/products").hasRole("maestro") //
//				.antMatchers(HttpMethod.GET, "/api/products").hasAnyRole("maestro", "aprendiz") //
//				.anyRequest().authenticated() //
//				.and() //
//				.httpBasic(); //
//	}
//
//	/**
//	 * In this method we are creating in memory user authentication details.
//	 * 
//	 * With Spring Boot, we can always configure default user and password using the
//	 * application.properties file (We can omit the
//	 * configureGlobal(AuthenticationManagerBuilder authentication)method from above
//	 * code).
//	 * 
//	 * @param authentication
//	 * @throws Exception
//	 */
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
//		authentication.inMemoryAuthentication() //
//				.withUser("obiwan") //
//				.password(passwordEncoder().encode("obiwanpasswd")) //
//				.roles("maestro") //
//				.and() //
//				.withUser("luke") //
//				.password(passwordEncoder().encode("lukepasswd")) //
//				.roles("aprendiz"); //
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}