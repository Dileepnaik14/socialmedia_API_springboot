package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CommentService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Comment;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
public class CommentController {
	@Autowired
CommentService commentService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@PostMapping("/api/comments/post/{postId}")
	public Comment creatComment(@RequestBody Comment comment, @RequestHeader("Authorization") String jwt ,@PathVariable int postId) throws Exception {
		User user= userService.getUserfromTocken(jwt);
		Comment newComment= commentService.createComment(comment, 0, user.getId());
		return newComment;
	}
	@PutMapping("/api/comments/like/{CmntId}")
	public Comment likedComment( @RequestHeader("Authorization") String jwt ,@PathVariable int cmntId) throws Exception {
		User user= userService.getUserfromTocken(jwt);
		Comment likedComment= commentService.likedComment(cmntId, user.getId());
		return likedComment;
	}
}
