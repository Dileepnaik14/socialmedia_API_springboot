package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StoryService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Story;
import com.example.demo.model.User;

@RestController
public class StoryController {
	@Autowired
private StoryService storyService;
	@Autowired
	private UserService userService;
	@PostMapping("/api/story")
	public Story createStory(@RequestBody Story story , @RequestHeader("Authorization") String jwt) {
		User users= userService.getUserfromTocken(jwt);
		Story createdStory= storyService.createStory(story, users);
		return createdStory;
	}
	@GetMapping("/api/story/{userId}")
	public List<Story> createStory(@RequestParam int userId) {

		List<Story> stories = storyService.findStoryByUserid(userId);
		return stories;
	}
} 
