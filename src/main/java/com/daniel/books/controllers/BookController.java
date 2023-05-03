package com.daniel.books.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniel.books.models.Book;
import com.daniel.books.services.BookService;

@Controller
public class BookController {
	
		@Autowired
		BookService bookService;

		@RequestMapping("/book/{bookId}")
		public String index(Model model,@PathVariable ("bookId") Long bookId) {
			System.out.println(bookId);
			Book book = bookService.findBook(bookId);
			System.out.println(book);
			model.addAttribute("book", book);
			
			return "index.jsp";
		}
		
		@RequestMapping("/books")
	    public String index(Model model) {
	        ArrayList<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "books.jsp";
	    }

}
