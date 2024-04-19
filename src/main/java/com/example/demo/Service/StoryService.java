package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Story;
import com.example.demo.model.User;

public interface StoryService {
public Story createStory(Story s,User user);
public List<Story> findStoryByUserid(int uid);

}
