package hr.optimit.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * The Class OAuth2Configuration.
 */
@Configuration
public class OAuth2Configuration {

	/**
	 * The Class ResourceServerConfiguration.
	 */
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

		/** The custom authentication entry point. */
		@Autowired
		private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

		/** The custom logout success handler. */
		@Autowired
		private CustomLogoutSuccessHandler customLogoutSuccessHandler;

		@Override
		public void configure(HttpSecurity http) throws Exception {

			http
				.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint)
				.and()
				.logout()
				.logoutUrl("/oauth/logout")
				.logoutSuccessHandler(customLogoutSuccessHandler)
				.and()
				.csrf()
				.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
				.disable()
				.headers()
				.frameOptions().disable()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.requiresChannel()
//				.anyRequest().requiresSecure()
				.and()
				.authorizeRequests()
				.antMatchers("/mt2a/api/**").authenticated();
		}
	}

	/**
	 * The Class AuthorizationServerConfiguration.
	 */
	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter implements EnvironmentAware {

		/** The Constant ENV_OAUTH. */
		private static final String ENV_OAUTH = "authentication.oauth.";

		/** The Constant PROP_CLIENTID. */
		private static final String PROP_CLIENTID = "clientid";

		/** The Constant PROP_SECRET. */
		private static final String PROP_SECRET = "secret";

		/** The Constant PROP_ACCESS_TOKEN_VALIDITY. */
		private static final String PROP_ACCESS_TOKEN_VALIDITY = "accessTokenValidity";
		
		/** The Constant PROP_REFRESH_TOKEN_VALIDITY. */
		private static final String PROP_REFRESH_TOKEN_VALIDITY = "refreshTokenValidity";

		/** The property resolver. */
		private RelaxedPropertyResolver propertyResolver;

		/** The data source. */
		@Autowired
		private DataSource dataSource;

		/**
		 * Token store.
		 *
		 * @return the token store
		 */
		@Bean
		public TokenStore tokenStore() {
			return new JdbcTokenStore(dataSource);
		}

		/** The authentication manager. */
		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints
					.tokenStore(tokenStore())
					.authenticationManager(authenticationManager);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

			clients
					.inMemory()
					.withClient(propertyResolver.getProperty(PROP_CLIENTID))
					.scopes("read", "write")
					.authorizedGrantTypes("password", "refresh_token")
					.secret(propertyResolver.getProperty(PROP_SECRET))
					.accessTokenValiditySeconds(
							propertyResolver.getProperty(PROP_ACCESS_TOKEN_VALIDITY, Integer.class, 1800))
					.refreshTokenValiditySeconds(
							propertyResolver.getProperty(PROP_ACCESS_TOKEN_VALIDITY, Integer.class, 604800));

		}

		@Override
		public void setEnvironment(Environment environment) {
			this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_OAUTH);
		}

	}

}
