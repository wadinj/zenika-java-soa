package com.wadinj.blog.repositories;

import com.wadinj.blog.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
