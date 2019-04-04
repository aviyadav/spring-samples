package com.sample.spring.boot.rest.customerservice.repository;

import com.sample.spring.boot.rest.customerservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
