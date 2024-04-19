package com.example.demo.Service;

import com.example.demo.model.Comment;

public interface CommentService {
public Comment createComment(Comment comment, int pid,int uid) throws Exception;
public Comment likedComment(int cid,int uid) throws Exception;
public Comment findCommentById(int cid) throws Exception;
}
