package com.iri.training.repository;

import org.springframework.stereotype.Repository;

import com.iri.training.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUserById(Long userId) {
		
		//implement DB connection and fetch user
		return null;
	}
	
}
