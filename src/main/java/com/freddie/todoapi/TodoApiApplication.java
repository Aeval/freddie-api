package com.freddie.todoapi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class TodoApiApplication {

	@Bean
	public FilterRegistrationBean<CorsFilter> customCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedOrigin("http://localhost:8080");
		config.setAllowedMethods(List.of("*"));
		config.setAllowedHeaders(List.of("*"));
		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;

	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}

}
