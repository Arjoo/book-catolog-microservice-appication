package com.arjoo.microservices.models;

public class Book {

	private String bookid;
	private String publisherName;
	private int price;

	public Book() {
		super();
	}

	public Book(String bookid, String publisherName, int price) {
		super();
		this.bookid = bookid;
		this.publisherName = publisherName;
		this.price = price;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
