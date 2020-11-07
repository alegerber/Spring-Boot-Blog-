package com.springbootblog.service;

import com.springbootblog.dto.HomeDto;
import com.springbootblog.model.Post;
import com.springbootblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public HomeDto home() {
        return new HomeDto(getLatestPosts(5));
    }

    public List<Post> getLatestPosts(int number) {
        return entityManager.createQuery(
                "FROM post ORDER BY created DESC",
                Post.class
        ).setMaxResults(number).getResultList();
    }
}
