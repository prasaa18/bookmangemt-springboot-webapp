package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;


@DataJpaTest
@TestMethodOrder(value=OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProjectfinalApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
	@Autowired 
	private BookRepository repo;
	
	
	@Test
	@Order(1)
	 void testCreateProduct()
	{
		Book b=new Book(1,"java",60.0, 1,"good");
		Book save=repo.save(b);
	Assertions.assertNotNull(save);
	}
	
 
    @Test
    @Order(2)
      void testlist()
     {
     List<Book> b=(List<Book>)repo.findAll(); 
     for(Book book:b)
	   {
	   System.out.println(book);
	   
   }
      assertThat(b).size().isGreaterThan(5);
  }

    @Test
    @Order(3)
     void testUpdateProduct()
    {
    	String bookname="b";
    	Book b=new Book(1,bookname,60.0,1,"good");
    	b.setId(6);
    	repo.save(b);
    	
    	Book updateproduct= repo.findByBookname(bookname);
    	assertThat(updateproduct.getBookname()).isEqualTo(bookname);
    }
    @Test
    @Order(4)
     void testDeleteProduct()
    {
    	
    	int id=2;
    	boolean isExistBeforeDelete=repo.findById(id).isPresent();
    	repo.deleteById(id);
    
    	boolean isNotExistBeforeDelete=repo.findById(id).isPresent();
    	
    	Assertions.assertTrue(isExistBeforeDelete);
    	Assertions.assertFalse(isNotExistBeforeDelete);
    }
    
    



}
