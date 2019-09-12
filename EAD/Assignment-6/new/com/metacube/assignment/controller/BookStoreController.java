package com.metacube.assignment.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.assignment.dto.Book;
import com.metacube.assignment.dto.UpdateBook;
import com.metacube.assignment.service.BookStoreService;

/**
 * This is controller class for book store. This class contain all rest methods
 * @author Surender
 */
@Path("/book")
public class BookStoreController {
	
	/**
	 * This REST method find and return book for given title
	 * @param title is the title of book
	 * @return object of book as JSON
	 */
	@GET
	@Path("/get/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookByTitle(@PathParam("title") String title){
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		
		try {
			Book book = bookStoreService.getBookByTitle(title);
			
			if(book.getId() > 0 ) {
				return Response.status(200).entity(book).build();
			} else {
				return Response.status(404).build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	/**
	 * This REST method returns all books
	 * @return List of books as JSON
	 */
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks(){
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		
		try {
			List<Book> books =  bookStoreService.getAllBooks();
			
			if(books.size() != 0) {
				return Response.status(200).entity(books).build();
			} else {
				return Response.status(404).build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	/**
	 * This REST method add book
	 * @param book object of book which need to be added
	 * @return true if added else false
	 */
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(Book book){
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		
		try {
			
			if(book.getWriter().matches("[a-zA-Z]+)") && book.getPublisher().matches("[a-zA-Z]+") && ( book.getPublishedYear() > 0 ) ){
				return Response.status(200).entity(bookStoreService.addBook(book)).build();
			} else {
				return Response.status(400).build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	/**
	 * This REST method delete book by id
	 * @param id id of book
	 * @return true if book deleted else false
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBookById(@PathParam("id") int id){
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		
		try {
			
			if(id > 0) {
				return Response.status(200).entity(bookStoreService.deleteBookById(id)).build();
			} else {
				return Response.status(400).build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	/**
	 * This REST method delete all books
	 * @return true if all books deleted else false
	 */
	@DELETE
	@Path("/deleteall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAllBooks(){
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		
		try {
			return Response.status(200).entity(bookStoreService.deleteAllBooks()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	/**
	 * This REST method update book
	 * @param id id of book to be updated
	 * @param updateBook object of updateBook contain details to be updated
	 * @return true if book updated else false
	 */
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBook(@PathParam("id") int id,UpdateBook updateBook){
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		updateBook.setId(id);
		
		try {
			if(updateBook.getId() > 0 && updateBook.getPublisher().matches("[a-zA-Z ]+")){
				return Response.status(200).entity(bookStoreService.updateBook(updateBook)).build();
			} else {
				return Response.status(400).build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
}