package com.arjoo.microservices.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rating")
public class BookRatingController {

	private static Map<String, Integer> ratings = new HashMap<>();
	
	static {
		ratings.put("1", 10);
		ratings.put("2", 25);
		ratings.put("3", 32);
		ratings.put("4", 45);
		ratings.put("5", 56);
		ratings.put("6", 67);
	}
	
	
	@RequestMapping(value = "/{bookid}")
	public Integer getBookRating(@PathVariable("bookid") String bookid) {
		return ratings.get(bookid);
	}
}
