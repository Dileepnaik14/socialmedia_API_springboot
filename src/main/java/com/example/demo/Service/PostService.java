package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Post;

public interface PostService {


public Post createPost(Post post,int uesrid) throws Exception;
public String deletePost(int pid,int uid) throws Exception;
public List<Post> findPostByUserId(int userid);
public Post findPostByid(int pid);
public List<Post> findAllPost();
public Post savedPost(int pid,int uid) throws Exception;
public Post likedPost(int pid,int uid) throws Exception;

}
