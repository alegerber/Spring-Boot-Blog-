package com.springbootblog.dto;

public class PostDto {
    private String text;

    public PostDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
