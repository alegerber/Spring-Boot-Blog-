package com.springbootblog.repository;

import com.springbootblog.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Post> getLatestPosts(int number) {
        return entityManager.createQuery(
                "SELECT p FROM Post p ORDER BY p.created DESC LIMIT ".concat(String.valueOf(number)),
                Post.class
        ).getResultList();
    }
}
