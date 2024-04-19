package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ChatService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Chat;
import com.example.demo.model.User;
import com.example.demo.requestr.CreateChatRequest;

@RestController
public class ChatController {
	@Autowired
private ChatService chatService;
	@Autowired
	private UserService userService;
	@PostMapping("/api/chat")
	public Chat createChat(@RequestBody CreateChatRequest chatRequest,@RequestHeader("Authorization")String jwt) throws Exception {
		User reqUser= userService.getUserfromTocken(jwt);
		User user2= userService.findUserById(chatRequest.getUserId());
		Chat chat= chatService.createChat(reqUser, user2);
		return chat;
	}
//	@GetMapping("/api/chat")
//	public List<Chat> findChatById(@RequestHeader ("Authorization")String jwt) {
//		User user= userService.getUserfromTocken(jwt);
//		List<Chat> chat= chatService.findChatsByUserId(user.getId());
//		return chat;
//	}
}
