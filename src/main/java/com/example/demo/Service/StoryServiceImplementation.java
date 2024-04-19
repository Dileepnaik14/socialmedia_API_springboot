package com.example.demo.Service;

import java.awt.Stroke;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Story;
import com.example.demo.model.User;
import com.example.demo.repository.StoryRepository;
@Service
public class StoryServiceImplementation implements StoryService {
	@Autowired
private StoryRepository storyRepository;
	@Autowired
	private UserService userService;
	@Override
	public Story createStory(Story s, User user) {
		
		Story createdStroy =new Story();
		createdStroy.setImage(s.getImage());
		createdStroy.setCaption(s.getCaption());
		createdStroy.setUser(user);
		createdStroy.setTimestamp( LocalDateTime.now());
		
		return storyRepository.save(createdStroy);
	}

	@Override
	public List<Story> findStoryByUserid(int uid) {
		
		List<Story> stories= storyRepository.findStoryByUserId(uid);
		return stories;
	}

}
