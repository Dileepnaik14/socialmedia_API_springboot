package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Chat;
import com.example.demo.model.User;
import com.example.demo.repository.ChatRepository;
@Service
public class ChatServiceImplementation implements ChatService {
	@Autowired
private ChatRepository chatRepository;
	@Autowired
	private UserService service;
	@Override
	public Chat createChat(User reqUser, User user2) {
		Chat isExist=chatRepository.findChatByUserId(user2, reqUser);
		if(isExist!=null) {
			return isExist;
		}else {
			Chat newChat=new Chat();
			newChat.getUsers().add(user2);
			newChat.getUsers().add(reqUser);
			return chatRepository.save(newChat);
		}
		
		
	}

	@Override
	public Chat findChatById(int id) throws Exception {
		Optional<Chat> chats=chatRepository.findById(id);
		if(chats.isEmpty()) {
			throw new Exception("Chat not found with the Id "+" "+id);
		}else
			return chats.get();
	}

//	@Override
//	public List<Chat> findChatsByUserId(int userid) {
//		
//		return chatRepository.findChatByUid(userid);
//	}

}
