package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookDTO;

public interface BookInterfaceService {

	
	public List<Book> getAllBooks();
	public void deleteBook(int id);
	
	public Book getBookById(int id);
	public void saveOrUpdate(BookDTO book);
}
