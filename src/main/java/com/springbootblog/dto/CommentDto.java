package com.springbootblog.dto;

import com.springbootblog.model.Comment;

public class CommentDto {
    private Comment comment;

    public CommentDto(Comment comment) {
        this.comment = comment;
    }
}
