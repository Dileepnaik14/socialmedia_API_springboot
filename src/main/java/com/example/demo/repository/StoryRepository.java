package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Story;

public interface StoryRepository extends JpaRepository<Story, Integer> {
public List<Story> findStoryByUserId(int userId);
}
