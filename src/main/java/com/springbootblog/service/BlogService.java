package com.springbootblog.service;

import com.springbootblog.dto.HomeDto;
import com.springbootblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BlogService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public HomeDto home() {
        return new HomeDto(postRepository.getLatestPosts(5));
    }
}
