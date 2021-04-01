package com.arjoo.microservices.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arjoo.microservices.models.AuthorBooks;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AuthorBookService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackAuthorBook")
	public AuthorBooks getAuthorBooks(String uri) {
		return restTemplate.getForObject(uri, AuthorBooks.class);
	}
	
	public AuthorBooks getFallbackAuthorBook(String uri) {
		return new AuthorBooks(new ArrayList<>());
	}
}

