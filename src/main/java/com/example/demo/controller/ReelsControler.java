package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ReelsService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Reels;
import com.example.demo.model.User;

@RestController
public class ReelsControler {
	@Autowired
private ReelsService reelsService;
	@Autowired
	private UserService userService;
	@PostMapping("/api/createreels")
	public Reels createRells(@RequestBody Reels reels ,@RequestHeader("Authorization")String jwt) {
		User reqUser=userService.getUserfromTocken(jwt);
		Reels createdReels=reelsService.createReels(reels, reqUser);
		return createdReels;
	}
	@GetMapping("/api/reels")
	public List<Reels>  findAllRells() {

		List<Reels> reels=reelsService.findAllReels();
		return reels;
	}
	@GetMapping("/api/reels/user/{uid}")
	public List<Reels> findReelsByUserId(int uid){
		List<Reels> reels=reelsService.findReelsByUserId(uid);
		return reels;
	}
}
