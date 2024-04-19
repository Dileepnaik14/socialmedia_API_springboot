package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
@Service
public class CommentServiceImplementation implements CommentService {
	@Autowired
	CommentRepository commentRepository;
	@Autowired
PostService postService;
	@Autowired
UserService userService;
	PostRepository postRepository;
	@Override
	public Comment createComment(Comment comment, int pid, int uid) throws Exception {
		User user= userService.findUserById(uid);
		Post post= postService.findPostByid(pid);
		if(post==null) {
		throw new Exception("Post is not Present");
		}
		else {
			comment.setUser(user);
			comment.setContent(comment.getContent());
			comment.setCreatedAt(LocalDateTime.now());
			Comment savedComment= commentRepository.save(comment);
			post.getComments().add(savedComment);
			postRepository.save(post);
			
			return savedComment;
		}
	}

	@Override
	public Comment likedComment(int cid, int uid) throws Exception {
		Comment comments= findCommentById(cid);
		User user= userService.findUserById(uid);
		if(! comments.getLiked().contains(user)) {
			comments.getLiked().add(user);
			 return commentRepository.save(comments);
		}else {
			comments.getLiked().remove(user);
		   return commentRepository.save(comments);
		}
	}

	@Override
	public Comment findCommentById(int cid) throws Exception {
		Optional<Comment> comment=commentRepository.findById(cid);
		if(comment.isEmpty()) {
        throw new Exception("No comments for this Id");
		}
		
		return comment.get();
	}

}
