package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MessageService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Message;
import com.example.demo.model.User;

@RestController
public class MessageController {
	@Autowired
private MessageService messageService;
	@Autowired
private UserService userService;
	@PostMapping("/api/message/chat/{chatid}")
	public Message createMessage(@RequestBody Message msg,@RequestHeader("Authorization")String jwt,@PathVariable int chatid) throws Exception {
		User user=userService.getUserfromTocken(jwt);
		Message message=messageService.createMessage(user, chatid, msg);
		return message;
	}
	@GetMapping("/api/message/chat/{chatid}")
	public List<Message> findChatsMessages(@RequestHeader("Authorization")String jwt,@PathVariable int chatid) throws Exception{
		User user=userService.getUserfromTocken(jwt);
		List<Message> messages=messageService.findChatsmessages(chatid);
		return messages;
	}
}
