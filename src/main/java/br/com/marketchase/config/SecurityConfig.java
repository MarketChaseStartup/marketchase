package br.com.marketchase.config;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import br.com.marketchase.models.services.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String FILTER_URL_LOJAS    = "/lojas/**";
	private static final String FILTER_URL_ENDERECO = "/enderecos/**";
	private static final String FILTER_URL_CONTATO = "/contatos/**";
	private static final String FILTER_URL_ANUNCIO = "/anuncio/**";
	private static final String ROLE_LOJISTA        = "LOJISTA";
	
	@Autowired
	private AuthenticationService authenticationService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(authenticationService)
			.passwordEncoder(encoder());
	}
	
	@Bean
	public DelegatingAuthenticationEntryPoint noAuthorizedEntryPoint(){
		LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> entryPoints = new LinkedHashMap<>();

			AuthenticationEntryPoint wsEntryPoint = (request, response, exception) -> 
			response.sendError(401, "No permission!");
		
		entryPoints.put(new AntPathRequestMatcher("/**"), wsEntryPoint);
		
		DelegatingAuthenticationEntryPoint noAuthorizedEntryPoint = new DelegatingAuthenticationEntryPoint(entryPoints);
		noAuthorizedEntryPoint.setDefaultEntryPoint(wsEntryPoint);
		return noAuthorizedEntryPoint;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.DELETE, FILTER_URL_LOJAS)   .hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.PUT,    FILTER_URL_LOJAS)   .hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.DELETE, FILTER_URL_ENDERECO).hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.POST,   FILTER_URL_ENDERECO).hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.PUT,    FILTER_URL_ENDERECO).hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.DELETE, FILTER_URL_CONTATO) .hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.POST,   FILTER_URL_CONTATO) .hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.PUT,    FILTER_URL_CONTATO) .hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.PUT,    FILTER_URL_ANUNCIO) .hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.DELETE, FILTER_URL_ANUNCIO) .hasRole(ROLE_LOJISTA)
				.antMatchers(HttpMethod.POST,   FILTER_URL_ANUNCIO) .hasRole(ROLE_LOJISTA)
				.anyRequest().permitAll()
				.and()
					.httpBasic().authenticationEntryPoint(noAuthorizedEntryPoint())
				.and()
					.csrf().disable();		
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	/*public static void main(String [] args){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}*/
	
}
