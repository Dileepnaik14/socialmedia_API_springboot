package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	private String image;
	private String caption;
	private LocalDateTime timestamp;
	@ManyToOne
	private User user;
}
