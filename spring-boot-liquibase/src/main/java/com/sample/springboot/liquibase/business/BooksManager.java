package com.sample.springboot.liquibase.business;

import com.sample.springboot.liquibase.persistence.entities.Book;
import com.sample.springboot.liquibase.persistence.repositories.BookRepository;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooksManager {

    private BookRepository bookRepository;

    @Autowired
    public BooksManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Stream<Book> getAllBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), true);
    }
}
