package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping
public String homecntroller() {
	return "This is home controller";
}
	@GetMapping("/home")
	public String homecntroller2() {
		return "This is home controller 2";
	}
}
