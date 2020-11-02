package com.springbootblog.factory;

import com.springbootblog.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentFactory extends AbstractFactory {
    public Comment create(String content) {
        Comment comment = new Comment();
        comment.setContent(content);

        return comment;
    }
}

