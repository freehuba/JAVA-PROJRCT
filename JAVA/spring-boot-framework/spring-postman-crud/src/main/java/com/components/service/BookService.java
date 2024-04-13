package com.components.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.components.model.Book;

@Component
public class BookService 
{
	private static List<Book> list = new ArrayList<Book>();
	
	static 
	{
		list.add(new Book(10, "java", "xyz"));
		list.add(new Book(12, "hibernate", "xyz"));
		list.add(new Book(14, "sql", "xyz"));
		list.add(new Book(16, "python", "xyz"));
	}
	
	//get all books
	public List<Book> getAllBooks()
	{
		return list;
	}
	
	//get single book by id	
	public Book getBookById(int bid)
	{
		Book book = null;
		try {  book = list.stream().filter(e -> e.getBookId() == bid).findFirst().get(); }
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
		
	}
	
	//add book
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
	
	//delete single book by id
	public void deleteBook(int bid)
	{
		 list = list.stream().filter( e -> e.getBookId()!=bid ).collect(Collectors.toList());
	}
	
	//book update by id
	public void updateBook(Book b, int bid) 
	{
		list = list.stream().map(e -> {
			if(e.getBookId()==bid)
			{
				e.setBookName(b.getBookName());
				e.setBookAuthor(b.getBookAuthor());
			}
			return e;
		}).collect(Collectors.toList());
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
