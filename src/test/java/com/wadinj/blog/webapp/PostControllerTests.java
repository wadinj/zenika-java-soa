package com.wadinj.blog.webapp;

import com.wadinj.blog.entities.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTests {

	@LocalServerPort
	private int port;

	private URL baseUrl;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws MalformedURLException {
		this.baseUrl = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void whenCallingGetPost_thenReturnsAllPosts() {

		ResponseEntity<Post> response = template.getForEntity(baseUrl.toString(), Post.class);
		assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
	}
}
