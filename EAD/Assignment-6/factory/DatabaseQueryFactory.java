package com.metacube.assignment.factory;

/**
 * This is database query factory class
 * @author Surender
 */
public class DatabaseQueryFactory {

	public static final String GET_BOOK_BY_TITLE = "{CALL getBookByTitle(?)}";
	
	public static final String GET_ALL_BOOKS = "{CALL getAllBooks()}";
	
	public static final String ADD_BOOK = "{CALL addBook(?,?,?,?)}";

	public static final String DELETE_BOOK_BY_ID = "{CALL deleteBook(?)}";

	public static final String DELETE_ALL_BOOK = "{CALL deleteAllBook()}";

	public static final String UPDATE_BOOK = "{CALL updateBook(?,?)}";
}
