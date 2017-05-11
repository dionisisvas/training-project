package com.iri.training.repository;

import java.sql.SQLException;



public interface UserRepository {

	  String getUserById(Long userId) throws SQLException;


}


