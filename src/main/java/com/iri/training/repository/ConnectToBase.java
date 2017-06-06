package com.iri.training.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public  class ConnectToBase {


		@Bean
		public static DriverManagerDataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.sqlite.JDBC");
			dataSource.setUrl("jdbc:sqlite:db/TrainingApp.db");
			return dataSource;
		}




}



