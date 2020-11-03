package com.xsh.service;

import com.xsh.pojo.Comment;

import java.util.List;


public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
