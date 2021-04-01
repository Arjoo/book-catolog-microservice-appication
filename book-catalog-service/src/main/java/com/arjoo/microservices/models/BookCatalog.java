package com.arjoo.microservices.models;

public class BookCatalog {

	private String bookid;
	private String publisherName;
	private int price;
	private int rating;

	public BookCatalog() {
		super();
	}

	public BookCatalog(String bookid, String publisherName, int price, int rating) {
		super();
		this.bookid = bookid;
		this.publisherName = publisherName;
		this.price = price;
		this.rating = rating;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
