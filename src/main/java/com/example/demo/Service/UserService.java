package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
public User registerUser(User u);

public User findUserById(int id) throws Exception;
public User updateUser(User u ,int id) throws Exception;
public User findUserByEmail(String email);
public List<User> findAll();
public User followUser(int id1,int id2) throws Exception;
public List<User> searchUsers(String qry);
public User getUserfromTocken(String jwt);

}
