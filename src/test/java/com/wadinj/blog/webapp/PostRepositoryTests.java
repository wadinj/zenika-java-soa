package com.wadinj.blog.webapp;

import com.wadinj.blog.entities.Post;
import com.wadinj.blog.repositories.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    PostRepository sut;

    @Test
    public void givenPost_whenCallSave_thenRetrievePost() {
        Post post = new Post();
        post.setAuthor("Jonathan Wadin");
        post.setContent("Hello, I'm the first post of this blog");
        post.setDate(new Date());
        post = entityManager.persistAndFlush(post);

        assertEquals(sut.findById(post.getId()).get(), post);
    }
}
