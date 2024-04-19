 package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Chat;
import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.MessageRepository;
@Service
public class MessssageServiceImplementation implements MessageService {
	@Autowired
private MessageRepository messageRepository;
	@Autowired
	private ChatService chatService;
	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public Message createMessage(User user, int chatid, Message message) throws Exception  {
		Chat chat=chatService.findChatById(chatid);
		Message newMessage=new Message();
		newMessage.setChat(chat);
		newMessage.setContent(message.getContent());
		newMessage.setImage(message.getImage());
		newMessage.setUser(user);
		newMessage.setTimestamp(LocalDateTime.now());
		
		 Message savedMessage= messageRepository.save(newMessage) ;
		 chat.getMessages().add(savedMessage);
		 chatRepository.save(chat);
		 return savedMessage;
	}

	@Override
	public List<Message> findChatsmessages(int chatId) throws Exception {
		Chat chat= chatService.findChatById(chatId);
		
		return messageRepository.findByChatId(chatId);
	}

}
