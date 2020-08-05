package com.springbootblog.service;

import com.springbootblog.dto.PostDto;
import com.springbootblog.model.Post;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class MyFirstService {

    @PersistenceContext
    private EntityManager entityManager;

    public MyFirstService() {
        System.out.println("test");
    }

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init() {
        System.out.println("testEvent");
    }

    static int counter = 0;

    @Transactional
    public PostDto hello(String user) {
        counter++;
        String helloMessage = String.format("theses application runs %s times for %s", counter, user);
        return new PostDto(helloMessage + " "  + getVisitorList(user));
    }

    private String getVisitorList(String user) {
        Post result = entityManager.find(Post.class, 1L);

        if (null == result) {
           Post newList = new Post();
           result = newList;
           entityManager.persist(newList);
        }

        result.addVisitors(user);

        return result.getListAsString();
    }
}
