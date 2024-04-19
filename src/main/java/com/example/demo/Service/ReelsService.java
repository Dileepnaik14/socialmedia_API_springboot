package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Reels;
import com.example.demo.model.User;

public interface ReelsService {
public Reels createReels(Reels reel,User user); 
public List<Reels> findAllReels();
public List<Reels> findReelsByUserId(int userId);
}
