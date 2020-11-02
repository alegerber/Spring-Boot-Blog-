package com.springbootblog.command;

import com.springbootblog.factory.CommentFactory;
import com.springbootblog.factory.PostFactory;
import com.springbootblog.model.Comment;
import com.springbootblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Component
//@Profile("!test")
public class TestDataBuilder extends Command {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CommentFactory commentFactory;

    @Autowired
    PostFactory postFactory;

    public void configure(Map<String, String> config) {
        config.put("TestDataBuilder", "build test data");
    };

    public int execute(String... args){
        for (int i=0; i<10; i++) {
            Map<Integer, Comment> CommentMap = new HashMap<>();

            for (int j=0; j<3; j++) {
                CommentMap.put(j, commentFactory.create(RandomStringUtils.randomAlphabetic(20)));
            }

            Post post = postFactory.create(
                    RandomStringUtils.randomAlphabetic(10),
                    RandomStringUtils.randomAlphabetic(20),
                    CommentMap
            );

            entityManager.persist(post);
            entityManager.flush();
        }

        return SUCCESS;
    }
}
