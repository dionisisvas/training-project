package com.iri.training.repository;

import com.iri.training.model.User;

public interface UserRepository {

	User getUserById(String userId);
	
}
