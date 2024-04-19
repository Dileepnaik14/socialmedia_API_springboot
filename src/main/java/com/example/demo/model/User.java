package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String firstname;
private String lasttname;
private String email;
private String password;
private String gender;

private List<Integer> following= new ArrayList<>();
private List<Integer> followers =new ArrayList<>();
@OneToMany
private List<Post> savedPost=new ArrayList<>();

public User(){

}

public User(int id, String firstname, String lasttname, String email, String password, String gender,
		List<Integer> following, List<Integer> followers) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lasttname = lasttname;
	this.email = email;
	this.password = password;
	this.gender = gender;
	this.following = following;
	this.followers = followers;
}


}