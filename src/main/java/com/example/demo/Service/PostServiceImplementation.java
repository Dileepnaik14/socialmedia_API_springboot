package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
@Service
public class PostServiceImplementation implements PostService {
	@Autowired
PostRepository postRepository;
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Override
	public Post createPost(Post post, int uesrid) throws Exception {
		User user=userService.findUserById(uesrid);
		Post newpost= new Post();
		newpost.setCaption(post.getCaption());
		newpost.setImage(post.getImage());
		newpost.setVideo(post.getVideo());
		newpost.setUser(user);
		return postRepository.save(newpost);
	}

	@Override
	public String deletePost(int pid, int uid) throws Exception {
		Post post= findPostByid(pid);
		User user=userService.findUserById(uid);
		if(post.getUser().getId()==user.getId()) {
			postRepository.delete(post);
			return "Post Deleted";
		}
		return "Post Not deleted";
	}

	@Override
	public List<Post> findPostByUserId(int userid) {

		return postRepository.findPostByUserId(userid);
	}

	@Override
	public Post findPostByid(int pid) {
		Optional<Post> p= postRepository.findById(pid);

			if(p.isPresent()) {
				return p.get();
			}


		return null;
	}

	@Override
	public List<Post> findAllPost() {

		return postRepository.findAll();
	}

	@Override
	public Post savedPost(int pid, int uid) throws Exception {
		Post post= findPostByid(pid);
		User user=userService.findUserById(uid);
		if(user.getSavedPost().contains(post)) {
			user.getSavedPost().remove(post);
		}
		user.getSavedPost().add(post);
		 userRepository.save(user);
		 return post;
	}

	@Override
	public Post likedPost(int pid, int uid) throws Exception {
		Post post= findPostByid(pid);
		User user=userService.findUserById(uid);
		if(post.getLikes().contains(user)) {
			post.getLikes().remove(user);
		}
		post.getLikes().add(user);
		return postRepository.save(post);
	}

}
