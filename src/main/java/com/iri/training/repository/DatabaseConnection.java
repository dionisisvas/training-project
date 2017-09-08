package com.iri.training.repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({ "com.iri.training" })
@PropertySource("classpath:application.properties")
public class DatabaseConnection {

	@Value("${jdbc.url}")
	protected String databaseURL;
	@Value("${jdbc.driverClassName}")
	protected  String databaseDriver;

	@Bean
	public  DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.sqlite.JDBC");
		dataSource.setUrl("jdbc:sqlite:db/TrainingApp.db");
		return dataSource;
	}
}
