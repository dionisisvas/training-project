package com.iri.training.repository;

import java.sql.SQLException;
import com.iri.training.model.User;


public interface UserRepository {

	  User getUserById(Long userId) throws SQLException;

	  User createUser(User user) throws SQLException;

}


