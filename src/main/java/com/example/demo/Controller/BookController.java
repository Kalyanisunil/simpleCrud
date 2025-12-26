package com.example.demo.Controller;

import org.springframework.ui.Model;
import com.example.demo.Models.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public  class BookController
{

//doing constructor injection declaring as final so it is immutable and safe
    private final BookRepository repo;


    public BookController(BookRepository repo) {
        this.repo = repo;
    }



    @GetMapping("/")
    public String listBooks (Model model)
    {
        model.addAttribute("books",repo.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addBook(Model model)
    {
        model.addAttribute("book",new Book());
        return "add-book";

    }
}