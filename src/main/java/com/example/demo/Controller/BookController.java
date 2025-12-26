package com.example.demo.Controller;

import org.springframework.ui.Model;
import com.example.demo.Models.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book)
    {
        repo.save(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model)
    {
        model.addAttribute("book",repo.findById(id).orElseThrow());
        return "edit-book";
    }

    @GetMapping("/delete/{id}")
    public  String deleteBook(@PathVariable Long id)
    {
        repo.deleteById(id);
        return "redirect:/";
    }
}