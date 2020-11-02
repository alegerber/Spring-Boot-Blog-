package com.springbootblog.factory;

import com.springbootblog.AbstractTest;
import com.springbootblog.model.Comment;
import com.springbootblog.model.Post;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostFactoryTest  extends AbstractTest {

    @Test
    public void createTest()
    {
        CommentFactory commentFactory = new CommentFactory();

        Comment comment = commentFactory.create(RandomStringUtils.randomAlphabetic(20));

        PostFactory postFactory          = new PostFactory();
        Map<Integer, Comment> CommentMap = new HashMap<>();

        CommentMap.put(0, comment);

        Post post = postFactory.create(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(20),
                CommentMap
        );

        assertThat(post.getTitle())
                .isNotNull()
                .hasSize(10);

        assertThat(post.getContent())
                .isNotNull()
                .hasSize(20);

        Object[] CommentOutArray = post.getComments().toArray();

        for(Object commentOut: CommentOutArray)
        {
            assertThat(commentOut).isInstanceOf(Comment.class);
        }

        assertEquals(1, CommentOutArray.length);
    }
}
