package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	@Query("select p from Post p where p.user.id=?1")
List<Post> findPostByUserId(int userid);
}
