package com.wadinj.blog;

import com.wadinj.blog.entities.Author;
import com.wadinj.blog.entities.Post;
import com.wadinj.blog.repositories.AuthorRepository;
import com.wadinj.blog.repositories.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(PostRepository postRepository, AuthorRepository authorRepository) {
		return args -> {
			Post post = new Post();
			Author author = new Author();
			author.setDescription("A geek born next to the 21st century");
			author.setLastName("Wadin");
			author.setFirstName("Jonathan");
			authorRepository.save(author);
			post.setAuthor(author);
			post.setContent("I'm the first post wrote in the startup");
			post.setDate(new Date());
			postRepository.save(post);
		};
	}

}
