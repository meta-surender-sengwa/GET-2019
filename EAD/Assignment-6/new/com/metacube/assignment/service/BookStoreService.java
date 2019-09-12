package com.metacube.assignment.service;

import java.util.List;
import com.metacube.assignment.dao.BookStoreDAO;
import com.metacube.assignment.dto.Book;
import com.metacube.assignment.dto.UpdateBook;

/**
 * This is service class for book store
 * @author Surender
 */
public class BookStoreService {

	private static BookStoreService bookStoreService;
	
	/**
	 * This method return object of BookStoreService class
	 * @return object of BookStoreService class
	 */
	public static BookStoreService getInstance() {
		
		if(bookStoreService == null) {
			bookStoreService = new BookStoreService();
		}
		return bookStoreService;
	}
	
	/**
	 * This method find and return book using title
	 * @param title String value represent book title
	 * @return object of Book containing details of book
	 * @throws Exception exception related database,other general exception
	 */
	public Book getBookByTitle(String title) throws Exception{
		
		BookStoreDAO bookStoreDAO = BookStoreDAO.getInstance();
		
		try {
			return bookStoreDAO.getBookByTitle(title);
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * This method return all books details
	 * @return List of all books
	 * @throws Exception exception related to database, other general exception
	 */
	public List<Book> getAllBooks() throws Exception {
		
		BookStoreDAO bookStoreDAO = BookStoreDAO.getInstance();
		
		try {
			return bookStoreDAO.getAllBooks();
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * This method add new book
	 * @param book object of Book containing details of Book
	 * @return true if successfully added else false
	 * @throws Exception exception related to database, other general exception
	 */
	public boolean addBook(Book book) throws Exception {
		
		BookStoreDAO bookStoreDAO = BookStoreDAO.getInstance();
		
		try {
			return bookStoreDAO.addBook(book);
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * This method delete book by id
	 * @param id integer id of book
	 * @return true if successfully deleted else false
	 * @throws Exception exception related to database, other general exception
	 */
	public boolean deleteBookById(int id) throws Exception{
		
		BookStoreDAO bookStoreDAO = BookStoreDAO.getInstance();
		
		try {
			return bookStoreDAO.deleteBookById(id);
		
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * This method delete all books
	 * @return true if all books deleted else false
	 * @throws Exception exception related to database, other general exception
	 */
	public boolean deleteAllBooks() throws Exception {
		
		BookStoreDAO bookStoreDAO = BookStoreDAO.getInstance();
		
		try {
			return bookStoreDAO.deleteAllBook();
		
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * This method updateS book
	 * @param updateBook object of UpdateBook containing details of book to be updated
	 * @return true if book updated else false
	 * @throws Exception exception related to database, other general exception
	 */
	public boolean updateBook(UpdateBook updateBook) throws Exception {
		
		BookStoreDAO bookStoreDAO = BookStoreDAO.getInstance();
		
		try {
			return bookStoreDAO.updateBook(updateBook);
			
		} catch(Exception e) {
			throw e;
		}
	}
}
