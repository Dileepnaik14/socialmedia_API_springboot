package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Chat;
import com.example.demo.model.User;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

@Query("select c from Chat c where :user Member of c.users And :reqUser Member of c.users ")
public Chat findChatByUserId(@Param ("user")User user,@Param("reqUser") User reqUser);
//public List<Chat> findChatByUid(int userid);


}
