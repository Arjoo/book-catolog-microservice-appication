package com.arjoo.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arjoo.microservices.models.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookRatingService {

	@Autowired
	private RestTemplate restTemplate;
 	
	@HystrixCommand(fallbackMethod = "getFallbackBookRating")
	public Integer getBookRating(String uri, Book book) {
		return restTemplate.getForObject(uri+book.getBookid(), Integer.class);
	}
	
	public Integer getFallbackBookRating(String uri, Book book) {
		return 0;
	}
}
