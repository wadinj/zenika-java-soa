package com.wadinj.blog.webapp;


import com.wadinj.blog.entities.Author;
import com.wadinj.blog.entities.Post;
import com.wadinj.blog.repositories.PostRepository;
import com.wadinj.blog.services.StatisticsService;
import com.wadinj.blog.services.StatisticsServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

public class StatisticsServiceTests {

    @Test
    public void givenDate_whenCallNumberOfPostBefore_getCorrectDate() {
        PostRepository postRepository = Mockito.mock(PostRepository.class);
        when(postRepository.findAll()).thenReturn(List.of(new Post(1L, new Author(), "", new Date(2019, 2, 2))));

        StatisticsService statisticsService = new StatisticsServiceImpl(postRepository);
        int sameDateWithOnePost = statisticsService.getNumberOfPostAfter(new Date(2019, 2, 2));
        int noPost = statisticsService.getNumberOfPostAfter(new Date(2019, 2, 3));
        int beforePost = statisticsService.getNumberOfPostAfter(new Date(2019, 1, 3));
        assert noPost == 0;
        assert sameDateWithOnePost == 1;
        assert beforePost == 1;

    }
}
