package com.springbootblog.dto;

import com.springbootblog.model.Comment;
import com.springbootblog.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PostDto {
    private Post post;

    public PostDto(Post post) {
        this.post = post;
    }

    public String getTitle() {
        return this.post.getTitle();
    }

    public String getContent() {
        return this.post.getContent();
    }

    public LocalDateTime getUpdated() {
        return this.post.getUpdated();
    }

    public LocalDateTime getCreated() {
        return this.post.getCreated();
    }

    public ArrayList<CommentDto> getComments() {
        ArrayList<Comment> comments       = this.post.getComments();
        ArrayList<CommentDto> commentDtos = new ArrayList<>();

        for (Comment comment: comments) {
            commentDtos.add(new CommentDto(comment));
        }

        return commentDtos;
    }
}
