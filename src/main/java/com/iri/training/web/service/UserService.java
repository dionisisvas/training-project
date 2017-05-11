package com.iri.training.web.service;
import com.iri.training.model.User;


import java.sql.SQLException;


public interface UserService {


	User getUserById( Long userId) throws SQLException;




}