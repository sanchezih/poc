//package com.bezkoder.springjwt.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import com.bezkoder.springjwt.security.jwt.AuthEntryPointJwt;
//import com.bezkoder.springjwt.security.jwt.AuthTokenFilter;
//import com.bezkoder.springjwt.security.services.UserDetailsServiceImpl;
//
///**
// * WebSecurityConfigurerAdapter es el la clase principal de nuestra
// * implementacion de seguridad.
// * 
// * Proporciona configuraciones de HttpSecurity para configurar cors, csrf,
// * administracion de sesiones y reglas para recursos protegidos.
// * 
// * @author ihsanch
// *
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {
//
//	private static final String[] AUTH_WHITELIST = {
//
//			// -- Swagger UI v2
//			"/v2/api-docs", //
//			"/swagger-resources", //
//			"/swagger-resources/**", //
//			"/configuration/ui", //
//			"/configuration/security", //
//			"/swagger-ui.html", //
//			"/webjars/**", //
//
//			// -- Swagger UI v3 (OpenAPI)
//			"/v3/api-docs/**", //
//			"/swagger-ui/**", //
//
//			// other public endpoints of your API may be appended to this array
//			"/api/auth/**", //
//			"/api/test/**" //
//	};
//
//	@Autowired
//	UserDetailsService userDetailsService;
//
//	@Autowired
//	private AuthEntryPointJwt unauthorizedHandler;
//
//	@Bean
//	public AuthTokenFilter authenticationJwtTokenFilter() {
//		return new AuthTokenFilter();
//	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable() //
//				.exceptionHandling()//
//				.authenticationEntryPoint(unauthorizedHandler)//
//				.and()//
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//
//				.and()//
//				.authorizeRequests()//
//				.antMatchers(AUTH_WHITELIST).permitAll() // whitelist Swagger UI resources
//				.anyRequest().authenticated();//
//		
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//	}
//
//}