package com.sample.springboot.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sample.springboot.jpa.resource")
@Configuration
public class Config {

}
