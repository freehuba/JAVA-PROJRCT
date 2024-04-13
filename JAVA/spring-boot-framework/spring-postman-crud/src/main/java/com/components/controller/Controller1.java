package com.components.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.components.model.Book;
import com.components.service.BookService;

@RestController
public class Controller1 
{
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> books = this.bookService.getAllBooks();
		
		if(books.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
		{
			return ResponseEntity.of(Optional.of(books));
		}
	}
	
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> getBooks(@PathVariable("bookId") int bid)
	{
		Book book = this.bookService.getBookById(bid);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(book));
	}
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book b)
	{
		Book book = this.bookService.addBook(b);
		return book;
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("bookId") int bid)
	{
		try { 
			this.bookService.deleteBook(bid); 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook( @RequestBody Book book, @PathVariable("bookId") int bid)
	{
		this.bookService.updateBook(book, bid);
		return book;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
