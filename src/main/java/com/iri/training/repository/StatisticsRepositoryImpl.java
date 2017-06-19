package com.iri.training.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.iri.training.model.Statistics;

public class StatisticsRepositoryImpl implements StatisticsRepository{
	Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	private JdbcTemplate jdbcTemplate;
	private ConnectToBase dbConnection = new ConnectToBase();
	private DataSource dataSource = dbConnection .getDataSource();
	private FileInputStream fis = new FileInputStream("File/app_sql.properties");
	private PropertyResourceBundle property = new java.util.PropertyResourceBundle(fis);

	public StatisticsRepositoryImpl() throws IOException {}

	@Override
	public Statistics getUsersAge() throws SQLException {



		return null;
	}
}
