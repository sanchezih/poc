package com.github.sanchezih.market.security;
//package com.github.sanchezih.market.security;
//
//import javax.sql.DataSource;
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
//public class WebSecurityConfig3 extends WebSecurityConfigurerAdapter {
//
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
//		authBuilder.jdbcAuthentication() //
//				.dataSource(dataSource) //
//				.passwordEncoder(new BCryptPasswordEncoder()) //
//				.usersByUsernameQuery("select username, password, enabled from users where username=?") //
//				.authoritiesByUsernameQuery("select username, role from users where username=?"); //
//	}
//	
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity //
//				.csrf().disable() //
//				.authorizeRequests() //
//				.antMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN") //
//				.antMatchers(HttpMethod.PUT, "/api/products").hasRole("ADMIN") //
//				.antMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN") //
//				.antMatchers(HttpMethod.GET, "/api/products").hasAnyRole("ADMIN", "USER") //
//				.anyRequest().authenticated() //
//				.and() //
//				.httpBasic(); //
//	}
//
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
////		authentication.inMemoryAuthentication() //
////				.withUser("obiwan") //
////				.password(passwordEncoder().encode("obiwanpasswd")) //
////				.roles("maestro") //
////				.and() //
////				.withUser("luke") //
////				.password(passwordEncoder().encode("lukepasswd")) //
////				.roles("aprendiz"); //
////	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}