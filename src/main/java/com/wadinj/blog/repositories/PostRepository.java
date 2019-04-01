package com.wadinj.blog.repositories;

import com.wadinj.blog.entities.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByAuthor(String author);
}
