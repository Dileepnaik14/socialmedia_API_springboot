package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select  u from User u where u.email=?1 ")
public User  findByEmail(String email);
	@Query("select u from User u where u.firstname LIKE %:input% OR u.lasttname LIKE %:input% OR u.email LIKE %:input%" )
	public List<User> searchUser(@Param("input") String input);
}
