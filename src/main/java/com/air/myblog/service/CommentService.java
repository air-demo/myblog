package com.air.myblog.service;

import com.air.myblog.entity.Comment;

import java.util.List;

/**
 * @author air
 * @create 2020-11-04-13:28
 */

public interface CommentService {

    //新增评论
    int saveComment(Comment comment);

    //查询评论
    List<Comment> listCommentByBlogId(Long blogId);

    //删除评论
    void deleteComment(Comment comment,Long id);
}
