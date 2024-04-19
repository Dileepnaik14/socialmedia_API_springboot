package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PostService;
import com.example.demo.Service.ResponseStructure;
import com.example.demo.model.Post;



@RestController
public class PostController {
	@Autowired
	PostService postService;
	@PostMapping("/api/posts/user/{userid}")

public ResponseEntity<Post> createPost(@RequestBody Post p,@PathVariable int userid) throws Exception {
	Post createPost =postService.createPost(p, userid);
	return new ResponseEntity<>(createPost,HttpStatus.CREATED);

}
	@DeleteMapping("psts/{postid}/user/{userid}")
	public ResponseEntity<ResponseStructure> deletePost(@PathVariable int postid ,@PathVariable int userid) throws Exception {
		String deletePost= postService.deletePost(postid, userid);
		ResponseStructure structure = new ResponseStructure(deletePost, false);
		return new ResponseEntity<>(structure,HttpStatus.OK);
	}
	@GetMapping("post/{pid}")
	public ResponseEntity<Post> findPostByid(@PathVariable int pid) {
		Post recUser= postService.findPostByid(pid);
		return new ResponseEntity<>(recUser,HttpStatus.ACCEPTED);
	}
	@GetMapping("allpost/{userid}")
	public ResponseEntity<List<Post>> findPostByUserId(@PathVariable int userid){
		List<Post> posts= postService.findPostByUserId(userid);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	@GetMapping("findAllPost")
	public ResponseEntity<List<Post>> findAllPost(){
		List<Post> posts= postService.findAllPost();
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	@PutMapping("/savepost/{pid}/saveuser{uid}")
	public  ResponseEntity<Post> savedPost(@PathVariable int pid,@PathVariable int uid) throws Exception {
		Post post= postService.savedPost(pid, uid);
		return new ResponseEntity<>(post,HttpStatus.OK);
	}
	@PutMapping("/likeposts/{pid}/likeusers{uid}")
	public ResponseEntity<Post> likedPost(@PathVariable int pid,@PathVariable int uid) throws Exception {
	 Post post=postService.likedPost(pid, uid);
	 return new ResponseEntity<>(post,HttpStatus.OK);
	}
}
