package springboot.apikey.example.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${app.http.auth-token-header-name}")
	private String principalRequestHeader;

	@Autowired
	private DataSource dataSource;

	/**
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		ApiKeyAuthFilter filter = new ApiKeyAuthFilter(principalRequestHeader);
		filter.setAuthenticationManager(new ApiKeyAuthManager(dataSource));

		http.antMatcher("/api/v1/secure").csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().addFilter(filter).authorizeRequests()
				.anyRequest().authenticated();
	}

	/**
	 * Para eliminar el usuario predeterminado, se debe configurar el
	 * aAuthentication Manager sin usuarios.
	 * 
	 * De esta manera se eliminara el mensaje de usuario y password predeterminada
	 * porque en ese caso se esta configurando InMemoryAuthentication y no se esta
	 * especificando ningún usuario.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
		authentication.inMemoryAuthentication();
	}
}