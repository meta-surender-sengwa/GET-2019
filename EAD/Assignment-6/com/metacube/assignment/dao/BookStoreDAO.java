package com.metacube.assignment.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.assignment.dto.Book;
import com.metacube.assignment.dto.UpdateBook;
import com.metacube.assignment.factory.ConnectionFactory;
import com.metacube.assignment.factory.DatabaseQueryFactory;

/**
 * This is dao class for book store
 * @author Surender
 *
 */
public class BookStoreDAO {

	private static BookStoreDAO bookStoreDAO;

	/**
	 * This method return object of BookStoreDAO
	 * @return object of BookStoreDAO
	 */
	public static BookStoreDAO getInstance() {

		if(bookStoreDAO == null) {
			bookStoreDAO = new BookStoreDAO();
		}
		return bookStoreDAO;
	}

	/**
	 * This method find and return book using title
	 * @param title String value represent book title
	 * @return object of Book containing details of book
	 * @throws Exception exception related database,other general exception
	 */
	public Book getBookByTitle(String title) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQueryFactory.GET_BOOK_BY_TITLE);
			callStmt.setString(1, title);
			ResultSet result = callStmt.executeQuery();
			Book book = new Book();
			
			while(result.next()) {
				book.setId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setWriter(result.getString(3));
				book.setPublisher(result.getString(4));
				book.setPublishedYear(result.getInt(5));
			}
			return book;
			
		} catch(SQLException e){
			e.printStackTrace();
			throw e;
			
		} catch(Exception e){
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				conn.close();
				callStmt.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	/**
	 * This method return all books details
	 * @return List of all books
	 * @throws Exception exception related to database, other general exception
	 */
	public List<Book> getAllBooks() throws Exception{

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQueryFactory.GET_ALL_BOOKS);
			ResultSet result = callStmt.executeQuery();
			List<Book> books = new ArrayList<Book>();
			
			while(result.next()){
				Book book = new Book();
				book.setId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setWriter(result.getString(3));
				book.setPublisher(result.getString(4));
				book.setPublishedYear(result.getInt(5));
				books.add(book);
			}
			return books;
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				conn.close();
				callStmt.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	/**
	 * This method add new book
	 * @param book object of Book containing details of Book
	 * @return true if successfully added else false
	 * @throws Exception exception related to database, other general exception
	 */
	public boolean addBook(Book book) throws Exception {

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQueryFactory.ADD_BOOK);
			callStmt.setString(1, book.getTitle());
			callStmt.setString(2, book.getWriter());
			callStmt.setString(3, book.getPublisher());
			callStmt.setInt(4, book.getPublishedYear());
			int result = callStmt.executeUpdate();
			
			if(result > 0) {
				return true;
				
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			
			try {
				conn.close();
				callStmt.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	/**
	 * This method delete book by id
	 * @param id integer id of book
	 * @return true if successfully deleted else false
	 * @throws Exception exception related to database, other general exception
	 */
	public boolean deleteBookById(int id) throws Exception{

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQueryFactory.DELETE_BOOK_BY_ID);
			callStmt.setInt(1, id);
			int result = callStmt.executeUpdate();
			
			if(result > 0) {
				return true;
				
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				conn.close();
				callStmt.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	/**
	 * This method delete all books
	 * @return true if all books deleted else false
	 * @throws Exception exception related to database, other general exception
	 */
	public boolean deleteAllBook() throws Exception{

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQueryFactory.DELETE_ALL_BOOK);
			int result = callStmt.executeUpdate();
			
			if(result > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				conn.close();
				callStmt.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	/**
	 * This method update book
	 * @param updateBook object of UpdateBook contain details of book to be updated 
	 * @return true if book updated else false
	 * @throws Exception exception related to database, other general exception
	 */
	public boolean updateBook(UpdateBook updateBook) throws Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQueryFactory.UPDATE_BOOK);
			callStmt.setInt(1, updateBook.getId());
			callStmt.setString(2, updateBook.getPublisher());
			int result = callStmt.executeUpdate();
			
			if(result > 0){
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			try {
				conn.close();
				callStmt.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
}
