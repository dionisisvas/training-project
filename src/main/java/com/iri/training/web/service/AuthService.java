package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Post;
import com.iri.training.model.interfaces.IPostable;

public interface AuthService {

	boolean verifyAddRights(IPostable postable, String authHeader);

	boolean verifyDeleteRights(IPostable postable, String authHeader);

	boolean verifyEditRights(IPostable postable, String authHeader);
}
