package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
