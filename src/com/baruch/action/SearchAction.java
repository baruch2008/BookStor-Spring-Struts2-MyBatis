package com.baruch.action;

import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.springframework.beans.factory.annotation.Autowired;

import com.baruch.dao.IBookDao;
import com.baruch.model.Book;
import com.opensymphony.xwork2.ActionSupport;

@AllowedMethods
public class SearchAction extends ActionSupport {

	private static final long serialVersionUID = 4286067144307265228L;

	// 分页查询条件
	private int pageNum = 1;
	private int pageSize = 10;
	private int totalPageNum = 1;

	// 过滤查询条件
	private int queryType = 0; // '1':'ISBN','2':'名称','3':'作者'
	private String queryValue = "";

	private IBookDao bookDao;

	public int getQueryType() {
		return queryType;
	}

	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	private List<Book> books;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public String view() {
		int startPosition = (pageNum - 1) * pageSize;
		List<Book> books = bookDao.queryBooks2(startPosition, pageSize, queryType, queryValue);
		if (books.size() < pageSize) {
			setTotalPageNum(pageNum);
		} else {
			// TODO
		}

		setBooks(books);
		
		//ActionContext ctx = ActionContext.getContext();
		
		//ctx.put("Test", "test");
		//ctx.getValueStack().push("Hello");
		//User user = new User();
		//user.setName("Hello");
		//user.setPwd("Hello1");
		//ctx.getValueStack().push(user);
		
		return "success";
	}

	@Autowired
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}
}
