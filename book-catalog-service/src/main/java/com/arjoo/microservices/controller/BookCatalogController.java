package com.arjoo.microservices.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arjoo.microservices.models.AuthorBooks;
import com.arjoo.microservices.models.Book;
import com.arjoo.microservices.models.BookCatalog;
import com.arjoo.microservices.service.AuthorBookService;
import com.arjoo.microservices.service.BookRatingService;

@RestController
@RequestMapping(value = "/catalog")
public class BookCatalogController {
	
	@Autowired
	private AuthorBookService authorBookService;
	
	@Autowired
	private BookRatingService bookRatingService;
	
	@RequestMapping(value = "/{authorname}")
	public List<BookCatalog> bookCatalog(@PathVariable("authorname") String authorname) {
		return getBookCatalog(authorBookService.getAuthorBooks(getBookInfoURI(authorname)));
	}

	private List<BookCatalog> getBookCatalog(AuthorBooks authorBooks) {
		String uri = getBookRatingURI();
		return authorBooks.getLists().stream().map(book-> {
			return getCatalog(book, bookRatingService.getBookRating(uri, book));
		}).collect(Collectors.toList());
	}

	private BookCatalog getCatalog(Book book, int rating) {
		return new BookCatalog(book.getBookid(), book.getPublisherName(), book.getPrice(), rating);
	}

	private String getBookRatingURI() {
		return "http://book-rating-service:8083/rating/";
	}

	private String getBookInfoURI(String authorname) {
		return "http://book-info-service:8082/info/" + authorname;
	}
}
