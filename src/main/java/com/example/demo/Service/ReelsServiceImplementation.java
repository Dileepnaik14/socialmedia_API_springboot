package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Reels;
import com.example.demo.model.User;
import com.example.demo.repository.ReelsRepository;
@Service
public class ReelsServiceImplementation implements ReelsService {
	@Autowired
private ReelsRepository reelsRepository;
	@Autowired
private UserService userService;
	@Override
	public Reels createReels(Reels reel, User user) {
		Reels createreel= new Reels();
		createreel.setTitle(reel.getTitle());
		createreel.setVideo(reel.getVideo());
		createreel.setUser(user);
		return reelsRepository.save(createreel);
		
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findReelsByUserId(int userId) {
		
		return reelsRepository.findReelsByUserId(userId);
	}

}
