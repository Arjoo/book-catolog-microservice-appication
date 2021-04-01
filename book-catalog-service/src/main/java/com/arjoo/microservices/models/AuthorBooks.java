package com.arjoo.microservices.models;

import java.util.List;

public class AuthorBooks {

	private List<Book> lists;

	public AuthorBooks() {
		super();
	}

	public AuthorBooks(List<Book> lists) {
		super();
		this.lists = lists;
	}

	public List<Book> getLists() {
		return lists;
	}

	public void setLists(List<Book> lists) {
		this.lists = lists;
	}

}
