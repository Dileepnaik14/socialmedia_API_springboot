package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Config.JwtProvider;
import com.example.demo.Service.CostomerUserDetailsService;
import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.AuthResponse;
import com.example.demo.response.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	UserService service;
	@Autowired
	UserRepository repository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	CostomerUserDetailsService costomerUserDetailsService;
	
	@PostMapping("/signup")
	public AuthResponse saveUser(@RequestBody User u) throws Exception {
		User isExist= repository.findByEmail(u.getEmail());
		if(isExist!=null) {
			throw new Exception("This email is Already Used with Another Account");
		}else {
	    User newUser= new User();
	    newUser.setFirstname(u.getFirstname());
	    newUser.setLasttname(u.getLasttname());
	    newUser.setEmail(u.getEmail());
	    newUser.setPassword(passwordEncoder.encode(u.getPassword()));
		User saveduser=repository.save(newUser);
		Authentication authentication=new UsernamePasswordAuthenticationToken(saveduser.getEmail(),saveduser.getPassword());
		String token= JwtProvider.genrateToken(authentication);
		AuthResponse response =new AuthResponse(token, "regestered Successfully");
		return response;
		}
	
	}
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginrequest ) {
		Authentication authentication= authenticate(loginrequest.getEmail(),loginrequest.getPassword());
		String token= JwtProvider.genrateToken(authentication);
		AuthResponse response =new AuthResponse(token, "Login Successfully");
		return response;
	}

	private Authentication authenticate(String email, String password) {
		UserDetails userDetails=costomerUserDetailsService.loadUserByUsername(email);
		if(userDetails==null) {
			throw new BadCredentialsException("Username Invalid");
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException(" Invalid UserName and Password");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}

}
