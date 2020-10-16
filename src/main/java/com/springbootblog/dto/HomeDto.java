package com.springbootblog.dto;

import com.springbootblog.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeDto {
    List<Post> posts;

    public HomeDto(List<Post> posts) {
        this.posts = posts;
    }

    public List<PostDto> getPostDtos() {
        List<PostDto> postDtos = new ArrayList<>();

        for (Post post: this.posts) {
            postDtos.add(new PostDto(post));
        }

        return postDtos;
    }
}
