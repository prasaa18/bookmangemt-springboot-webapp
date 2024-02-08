package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookDTO;
import com.example.demo.repository.BookRepository;
@Service
public class BookServiceImp implements BookInterfaceService {

	@Autowired
	private BookRepository rep;
	@Override
	public List<Book> getAllBooks() {
		
		return rep.findAll();
	}

	@Override
	public void deleteBook(int id) {
		rep.deleteById(id);
	}

	@Override
	public void saveOrUpdate(BookDTO book) {
	 
	Book b =new Book();
	b.setBookname(book.getBookname());
	b.setId(book.getId());
	b.setDiscription(book.getDiscription());
	b.setQuantity(book.getQuantity());
	b.setBookprice(book.getBookprice());
	rep.save(b);

	}

	@Override
	public Book getBookById(int id) {
		Optional<Book> list=rep.findById(id);
		Book b=null;
		
		 if(list.isPresent()) {
			 b=list.get();
	        }else {
	        
	            throw new UsernameNotFoundException("User not found for id::" + id);
	        }
	       
		return b;
	}

}
