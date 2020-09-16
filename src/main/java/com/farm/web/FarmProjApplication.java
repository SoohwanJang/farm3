package com.farm.web;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class FarmProjApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(FarmProjApplication.class);
		application.run(args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FarmProjApplication.class);
	}


}
