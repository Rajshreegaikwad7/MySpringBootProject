package com.example.service;

import java.util.List;




import com.example.entity.Book;

public interface BookService {
	public Book saveBook(Book book);
    
    public Book findByBookId(int bookId);
    
    List<Book> getAllBooks();

	String deleteBook(int id);
	
	Book updateBook(Book book, int id);
}
