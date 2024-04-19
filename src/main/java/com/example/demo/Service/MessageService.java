package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Chat;
import com.example.demo.model.Message;
import com.example.demo.model.User;


public interface MessageService {
public Message createMessage(User user,int chatid,Message message) throws Exception   ;
public List<Message>findChatsmessages(int chatId) throws Exception;
}
