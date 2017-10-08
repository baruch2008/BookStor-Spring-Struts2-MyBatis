package com.baruch.controller;

public interface IBookController {
	
	String getBooksByName(String name);
	
	String getBooks();
	
	String getBookByISBN(String isbn);
}
