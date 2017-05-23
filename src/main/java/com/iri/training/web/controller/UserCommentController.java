
package com.iri.training.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.UserComment;
import com.iri.training.web.service.UserCommentService;

import static java.lang.Integer.*;

@RestController
@RequestMapping("/userComment")
public class UserCommentController{

	@Autowired
	UserCommentService userCommentService;
	@RequestMapping(value = "create/{userComment}", method = RequestMethod.GET)
	public void CreateUserComment(final HttpServletRequest request, @PathVariable("description,comdate,commID,userID")  String description,String comdate,int commID,int useID)throws SQLException{
		UserComment usercomment=new UserComment();
		usercomment.description=request.getParameter("description");
		usercomment.comdate=request.getParameter("comdate");
		usercomment.commID= parseInt(request.getParameter("commID"));
		usercomment.userID= parseInt(request.getParameter("userID"));
		
	}


	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public UserComment getUserCommentById(final HttpServletRequest requ, @PathVariable final Long userId) throws SQLException {

		UserComment userComment = userCommentService.getUserCommentById(userId);

		return userComment;
	}

}