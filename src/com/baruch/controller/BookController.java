package com.baruch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baruch.dao.IBookDao;
import com.baruch.model.Book;

/**
 * 在接口中予以声明服务，在实现类中不再需要声明
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value="/book")
public class BookController implements IBookController{

	@Autowired
	private IBookDao bookDao;

	// 使用@Autowired注解声明之后不需要setter，也不需要在配置文件中配置
	/*public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}*/

	@RequestMapping(value="/getBooksByName", method=RequestMethod.GET, produces="application/json")
	@Override
	public String getBooksByName(@RequestParam("name") String name) {
		Book book = bookDao.getBookByName(name);
		if (null == book) {
			return "[]";
		}
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("{\"name\":\"");
		strBuilder.append(book.getName());
		strBuilder.append("\",\"isbn\":\"");
		strBuilder.append(book.getIsbn());
		strBuilder.append("\"}");
		return strBuilder.toString();
	}

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	@Override
	public String getBooks() {
		List<Book> books = bookDao.getBooks();
		if (books.isEmpty()) {
			return "[]";
		}

		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append('[');
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			strBuilder.append("{\"name\":\"");
			strBuilder.append(book.getName());
			strBuilder.append("\",\"isbn\":\"");
			strBuilder.append(book.getIsbn());
			strBuilder.append("\",\"price\":");
			strBuilder.append(book.getPrice());
			if (i + 1 >= books.size()) {
				strBuilder.append("}");
			} else {
				strBuilder.append("},");
			}
		}
		strBuilder.append(']');

		return strBuilder.toString();
	}

	@RequestMapping(value="/{isbn}", method=RequestMethod.GET, produces="application/json")
	@Override
	public String getBookByISBN(@PathVariable("isbn") String isbn) {
		Book book = bookDao.getBookByISBN(isbn);
		if (null == book) {
			return "[]";
		}
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("{\"name\":\"");
		strBuilder.append(book.getName());
		strBuilder.append("\",\"isbn\":\"");
		strBuilder.append(book.getIsbn());
		strBuilder.append("\"}");
		return strBuilder.toString();

	}
}
