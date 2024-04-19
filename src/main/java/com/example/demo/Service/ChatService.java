package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Chat;
import com.example.demo.model.User;

public interface ChatService {
public Chat createChat(User reqUser,User user2) ;
public Chat findChatById(int id) throws Exception;
//public List<Chat> findChatsByUserId(int userid);

}
