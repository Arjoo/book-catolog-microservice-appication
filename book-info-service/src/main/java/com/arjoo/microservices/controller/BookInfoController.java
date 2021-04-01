package com.arjoo.microservices.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.arjoo.microservices.models.AuthorBooks;
import com.arjoo.microservices.models.Book;

@RestController
@RequestMapping(value = "/info")
public class BookInfoController {

	private static Map<String, List<Book>> db = new HashMap<>();
	
	static {
		db.put("arjoo", Arrays.asList(new Book("1", "pub_1", 100),
				new Book("2", "pub_2", 150)));
		
		db.put("anshul", Arrays.asList(new Book("3", "pub_3", 200),
				new Book("4", "pub_4", 250)));
		
		db.put("ashish", Arrays.asList(new Book("5", "pub_5", 50),
				new Book("5", "pub_6", 150)));
		
		db.put("shrawan", Arrays.asList(new Book("6", "pub_7", 70),
				new Book("6", "pub_8", 80)));
}

	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/{authorname}")
	public AuthorBooks getBookInfo(@PathVariable("authorname") String authorname) {
		
		List<Book> authorBooks = db.get(authorname);
		return new AuthorBooks(authorBooks);
		
		
	}
}

