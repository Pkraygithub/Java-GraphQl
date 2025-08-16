package com.javaGraphql.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaGraphql.com.entity.User;
import com.javaGraphql.com.exception.UserNotFoundException;
import com.javaGraphql.com.repositery.UserRepositery;

@RestController
public class UserGraphqlController {

	@Autowired
	private UserRepositery userrepo;

	@MutationMapping
	public User createUser(@Argument String username, @Argument String uemailid, @Argument String contact) {

		User user = new User();
		user.setUsername(username);
		user.setUemailid(uemailid);
		user.setContact(contact);
		User CreateDetails = userrepo.save(user);
		return CreateDetails;
	}

	@QueryMapping
	public List<User> getUserDetails() {
		return userrepo.findAll();
	}

	@QueryMapping
	public User getUserbyid(@Argument Integer uid) {

		return userrepo.findById(uid).orElseThrow(()-> new UserNotFoundException("User Not Found"));
	}

	@MutationMapping
	public String deleteUser(@Argument Integer uid) {
		User userDelete = userrepo.findById(uid).orElseThrow(()-> new UserNotFoundException("User Not Found"));
		userrepo.delete(userDelete);
		return "User Id "+uid+" is deleted Successfully.";
	}
}
