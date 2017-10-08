package com.baruch.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.baruch.dao.IBookDao;
import com.baruch.model.Book;
import com.baruch.util.DBOperationUtil;

public class BookDaoImpl implements IBookDao {
	private Log logger = LogFactory.getLog(BookDaoImpl.class);

	private SqlSessionFactory sessionFactory;

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Book> queryBooks1(int startPosition, int pageSize, int queryType, String queryValue) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("startPosition", startPosition);
			parameters.put("pageSize", pageSize);
			parameters.put("queryType", queryType);
			parameters.put("queryValue", queryValue);
			return session.selectList("com.baruch.dao.IBookDao.queryBooks", parameters);
		} catch (Exception e) {
			logger.error("Getting books failed.", e);
		} finally {
			DBOperationUtil.closeSession(session);
		}
		return new ArrayList<Book>();
	}

	@Override
	public List<Book> queryBooks2(int startPosition, int pageSize, int queryType, String queryValue) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			IBookDao bookDaoMapper = session.getMapper(IBookDao.class); 
			return bookDaoMapper.queryBooks2(startPosition, pageSize, queryType, queryValue);
		} catch (Exception e) {
			logger.error("Getting books failed.", e);
		} finally {
			DBOperationUtil.closeSession(session);
		}
		return new ArrayList<Book>();
	}

	@Override
	public List<Book> getBooks() {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			List<Book> results = session.selectList("com.baruch.dao.IBookDao.getBooks");
			return results;
		} catch (Exception e) {
			logger.error("Getting books failed.", e);
		} finally {
			DBOperationUtil.closeSession(session);
		}
		return new ArrayList<Book>();
	}

	@Override
	public Book getBookByISBN(String isbn) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();

			IBookDao bookDao = session.getMapper(IBookDao.class);
			return bookDao.getBookByISBN(isbn);
		} catch (Exception e) {
			logger.error("Getting books failed.", e);
		} finally {
			DBOperationUtil.closeSession(session);
		}
		return null;
	}

	@Override
	public Book getBookByName(String name) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();

			IBookDao bookDao = session.getMapper(IBookDao.class);
			return bookDao.getBookByName(name);
		} catch (Exception e) {
			logger.error("Getting books failed.", e);
		} finally {
			DBOperationUtil.closeSession(session);
		}
		return null;
	}

	@Override
	public void addBook(Book book) {

	}

	@Override
	public void modifyBook(Book book) {

	}

	@Override
	public void deleteBookByISBN(String isbn) {

	}
}
