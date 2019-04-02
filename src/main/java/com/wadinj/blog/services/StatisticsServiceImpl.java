package com.wadinj.blog.services;

import com.wadinj.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {


    private PostRepository postRepository;

    @Autowired
    public StatisticsServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public int getNumberOfPostAfter(Date date) {
        return postRepository.findAll().stream()
                .filter(p -> p.getDate().compareTo(date) >= 0)
                .collect(Collectors.toList()).size();
    }
}
