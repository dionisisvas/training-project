package com.iri.training.repository;

import com.iri.training.model.User;
import java.sql.SQLException;



public interface UserRepository {

	  User getUserById(Long userId) throws SQLException;


}


