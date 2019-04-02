package com.wadinj.blog.controllers;

import com.wadinj.blog.entities.Post;
import com.wadinj.blog.repositories.PostRepository;
import com.wadinj.blog.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/")
    public List<Post> get() {
        return postRepository.findAll();
    }

    @RequestMapping("/statistics/{date}")
    public int getStatistics(@PathVariable("date") @DateTimeFormat(pattern = "ddMMyyyy") Date date) {
        return statisticsService.getNumberOfPostAfter(date);
    }
}
