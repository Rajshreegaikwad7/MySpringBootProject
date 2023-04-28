package com.example.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;
@Service
public  class BookServiceimpl implements BookService {
	@Autowired
	private BookRepository bookRepository;




	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book book, int id) {
		// TODO Auto-generated method stub
		Book _book = bookRepository.findById(id).get();
		_book.setB_Name(book.getB_Name());
	    return bookRepository.save(_book);
	}

	@Override
	public String deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
		return "the book with id " + id + " has been deleted...";
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public Book findByBookId(int bookId) {
		// TODO Auto-generated method stub
		return bookRepository.findById(bookId).get();
	}

	


	
	
}