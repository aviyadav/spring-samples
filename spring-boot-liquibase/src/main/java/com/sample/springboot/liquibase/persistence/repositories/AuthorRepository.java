package com.sample.springboot.liquibase.persistence.repositories;

import com.sample.springboot.liquibase.persistence.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer>{
}
