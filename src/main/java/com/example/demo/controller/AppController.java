package com.example.demo.controller;

import java.util.List;





import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDTO;
import com.example.demo.service.BookServiceImp;
import com.example.demo.service.UserServiceImp;




@Controller

public class AppController {

  static Logger log =org.apache.logging.log4j.LogManager.getLogger(AppController .class);
  
  @Autowired
	private BookServiceImp bookServiceImp;
	
	@Autowired
	private UserServiceImp userServiceImp;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	   
	public static final String URLADDRESS ="redirect:/listbooks";
	
	
    @GetMapping(value="/")    
    public String index() {    
         log.info("error happened in index method");
        return "index1.jsp";  
    }    
    @RequestMapping(value="/login")    
    public String login(Model m) {  
    	 log.error("error happened in login method");
            m.addAttribute("user", new User());
        return "login.jsp";    
    }    
   
    @RequestMapping("/submit")
	public ModelAndView submitForm() {
    	 log.error("error happened in submitform method");
    	 return new ModelAndView(URLADDRESS);
	}

	@RequestMapping("/listbooks")
 public String getAll(Model m) {
		 log.error("error happened in listbook method");
	 List<Book> book=bookServiceImp.getAllBooks();
	 m.addAttribute("booklist",book);
	 return "bookview.jsp";
	 
 }
  @RequestMapping("/deletetebyid")
	public ModelAndView delete(@RequestParam("hid") int id)
	{ 
	  
	  log.error("error happened in delete method");
		bookServiceImp.deleteBook(id);
		return new ModelAndView(URLADDRESS);
		
	}

  
	@GetMapping(value="/save")
public ModelAndView saveBook(@ModelAttribute BookDTO book)
{
		
		log.info("save book method");
	 bookServiceImp.saveOrUpdate(book);
	 return new ModelAndView(URLADDRESS);
}

	@RequestMapping("/saveuser")
public ModelAndView saveBook(@ModelAttribute UserDTO user)
{
		
		log.info("saveuser method");
	 userServiceImp.saveData(user);
	 return new ModelAndView("redirect:/login");
}
  @GetMapping("/updatebyid")
  //@ResponseBody
	public ModelAndView updateStudent(@RequestParam("fid")int cid)
	{
	  log.info("update");
	  Book b  =bookServiceImp.getBookById(cid);
	 
	  return new ModelAndView("updateform1.jsp","product", b );
		
		
		
	}
	@RequestMapping("/addnew")
  public String addnewrow()
  
  {
		log.error("error happened in addnewrow method");
	  return "addform.jsp";
  }



}
