package com.sample.springboot.jpa.resource;

import com.sample.springboot.jpa.resource.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    
}
