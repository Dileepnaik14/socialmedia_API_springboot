package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;

@RestController
public class UserController {
	@Autowired
   UserService service;
	@GetMapping("/users/{userid}")
public User getUser(@PathVariable("userid") int id) {

	return null;
	}

@GetMapping("api/create/{id}")
public User findById(@PathVariable int id) throws Exception {
	return service.findUserById(id);
}
@GetMapping("/email/{email}")
public User findByEmail(@PathVariable String email) {
	return service.findUserByEmail(email);
}
@GetMapping("/users")
public List<User> findAll(){
	return service.findAll();
}
@PutMapping("/api/users")
public User updateUser(@RequestHeader("Authorization")String jwt ,@RequestBody User u) throws Exception {
	User reqUser= service.getUserfromTocken(jwt);
	User userUpdate=service.updateUser(u,reqUser.getId() );
	return userUpdate;
}
@PutMapping("follow/{id1}/{id2}")
public User followUser(@RequestHeader("Authorization")String jwt,@PathVariable int id2) throws Exception {
	User reqUser= service.getUserfromTocken(jwt);
	
	User user= service.followUser(reqUser.getId(), id2);
	return user;
}
@GetMapping("/search/{input}")
public List<User> searchUser(@PathVariable String input) {
	List<User> u =service.searchUsers(input);
	return u;
}
@GetMapping("/api/users/profile")
public User getUserByTocken(@RequestHeader("Authorization")String jwt) {
	User user= service.getUserfromTocken(jwt);
	user.setPassword(null);
	return user;
}
}
