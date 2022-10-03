package springboot.apikey.example.auth;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * Filtro responsable de obtener la api key de las requests entrantes que deben
 * ser autorizadas.
 */
public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

	private static final Logger LOG = LoggerFactory.getLogger(ApiKeyAuthFilter.class);
	private final String headerName;

	/*----------------------------------------------------------------------------*/

	public ApiKeyAuthFilter(final String headerName) {
		this.headerName = headerName;
	}

	/*----------------------------------------------------------------------------*/

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		return request.getHeader(headerName);
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		// No creds when using API key
		return "N/A";
	}
}