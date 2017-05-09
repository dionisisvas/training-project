package com.iri.training.repository;

import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.iri.training.model.User;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(Long userId) {
        System.out.println("success!!");
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\test.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static String getName() {
        return jdbcTemplate.queryForObject("select name from USERS", String.class);
    }

    public static String getSurname() {
        return jdbcTemplate.queryForObject("select surname from USERS", String.class);
    }

    public static String getUsername() {
        return jdbcTemplate.queryForObject("select usrname from USERS", String.class);
    }

    public static String getPassword() {
        return jdbcTemplate.queryForObject("select password from USERS", String.class);

    }


}
