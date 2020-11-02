package com.springbootblog.factory;

import com.springbootblog.model.Comment;
import com.springbootblog.model.Post;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PostFactory extends AbstractFactory {
    public Post create(String title, String content, Map<Integer, Comment> CommentMap) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        CommentMap.forEach((index, Comment) -> {
            post.addComment(Comment);
        });

        return post;
    }
}
