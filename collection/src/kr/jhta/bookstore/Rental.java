package kr.jhta.bookstore;

import java.util.Date;

public class Rental {
	
	private Customer customer;
	private Book book;
	private Date rentalDate;
	private Boolean isBack;
	
	public Rental() {}

	public Rental(Customer customer, Book book, Date rentalDate, Boolean isBack) {
		super();
		this.customer = customer;
		this.book = book;
		this.rentalDate = rentalDate;
		this.isBack = isBack;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Boolean getIsBack() {
		return isBack;
	}

	public void setIsBack(Boolean isBack) {
		this.isBack = isBack;
	}
}
