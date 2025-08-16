package com.javaGraphql.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaGraphql.com.entity.User;
import com.javaGraphql.com.repositery.OrdersRepositery;
import com.javaGraphql.com.repositery.UserRepositery;


@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserRepositery userRepositery;
	@Autowired
	private OrdersRepositery ordersRepositery;

	
	@PostMapping("/userdetails")
	public User saveUser(@RequestBody User user) {
		return userRepositery.save(user);
	}
	
	@GetMapping("/all")
	public List<User> getAll(){
		return userRepositery.findAll();
	}
	
	
	@GetMapping("/showuser/{uid}")
	public User getById(@PathVariable Integer uid) {	
		return userRepositery.findById(uid).orElseThrow(()-> new RuntimeException("User Not Found"));
	}
	
	@DeleteMapping("/delete/{uid}")
	public String deleteById(@PathVariable Integer uid) {
		User userDetails = userRepositery.findById(uid).orElseThrow(()-> new RuntimeException("User Not Found"));
		 userRepositery.delete(userDetails);
		 return "User Details has been deleted Successfully and User Id is => "+uid;
		 
	}
}
