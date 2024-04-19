package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String caption;
 private String image;
 private String video;
 @ManyToOne
 private User user;
 private LocalDateTime createdAt;
 @OneToMany
 private List<User> likes=new ArrayList<>();
 @OneToMany
 private List<Comment> comments = new ArrayList<>();


 public Post() {

 }

public Post(int id, String caption, String image, String video, User user, LocalDateTime createdAt, List<User> likes) {
	super();
	this.id = id;
	this.caption = caption;
	this.image = image;
	this.video = video;
	this.user = user;
	this.createdAt = createdAt;
	this.likes = likes;
}




}
