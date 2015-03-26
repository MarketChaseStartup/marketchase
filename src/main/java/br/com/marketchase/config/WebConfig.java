package br.com.marketchase.config;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAsync
@EnableWebMvc
@ComponentScan(basePackages = "br.com.marketchase.*")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	private final String MEDIA_TYPE_XML  = "xml";
	private final String MEDIA_TYPE_JSON = "json";
	
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		HashMap<String, MediaType> mediaTypes = new HashMap<>();
		mediaTypes.put(MEDIA_TYPE_XML, MediaType.APPLICATION_XML);
		mediaTypes.put(MEDIA_TYPE_JSON, MediaType.APPLICATION_JSON);
		configurer.mediaTypes(mediaTypes)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.favorParameter(false).favorPathExtension(true);
		super.configureContentNegotiation(configurer);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
