package com.baruch.model;

public class Book {
	private String name;
	private String isbn;
	private double price;

	private String author;

	private String press;

	public Book() {

	}

	public Book(String name, String isbn, String author, String press, double price) {
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.press = press;
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Book [name=");
		strBuilder.append(name);
		strBuilder.append(", isbn=");
		strBuilder.append(isbn);
		strBuilder.append(", price=");
		strBuilder.append(price);
		strBuilder.append("]");

		return strBuilder.toString();
	}

}
