package br.com.marketchase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.marketchase.models.services.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationService authenticationService;
	
	private final String ROLE_LOJISTA = "";
	private final String FILTER_URL = "";
	private final String LOGIN_PAGE = "";
	private final String URL_PROCESSING = "/acesso";
	private final String URL_SUCCESS = "";
	private final String URL_FAILURE = "";
	private final String USERNAME_PARAMETER = "usuario";
	private final String PASSWORD_PARAMETER = "senha";
	private final String LOGOUT_URL = "/sair";
	private final String LOGOUT_SUCCESS_URL = "";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(authenticationService)
			.passwordEncoder(encoder());
			
	}
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(FILTER_URL).hasRole(ROLE_LOJISTA)//urls que o spring deve filtrar para liberar ou bloquear acesso
				.anyRequest().permitAll()                     
			.and()
				.formLogin()
					.loginPage(LOGIN_PAGE)
					.loginProcessingUrl(URL_PROCESSING)
					.defaultSuccessUrl(URL_SUCCESS)
					.failureUrl(URL_FAILURE)
					.usernameParameter(USERNAME_PARAMETER)
					.passwordParameter(PASSWORD_PARAMETER)
				.and()
					.logout()
					.logoutUrl(LOGOUT_URL)
					.logoutSuccessUrl(LOGOUT_SUCCESS_URL);
			
	}*/
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
