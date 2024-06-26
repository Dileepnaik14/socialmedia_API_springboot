package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Reels;

public interface ReelsRepository extends JpaRepository<Reels, Integer> {
	
	public List<Reels> findReelsByUserId(int userId);

}
