package com.sample.springboot.liquibase.persistence.repositories;

import com.sample.springboot.liquibase.persistence.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
}
