package com.springbootblog.factory;

import com.springbootblog.AbstractTest;
import com.springbootblog.model.Comment;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommentFactoryTest extends AbstractTest {

    @Test
    public void createTest()
    {
        CommentFactory commentFactory = new CommentFactory();

        Comment comment = commentFactory.create(RandomStringUtils.randomAlphabetic(20));

        assertThat(comment.getContent())
                .isNotNull()
                .hasSize(20);
    }
}
