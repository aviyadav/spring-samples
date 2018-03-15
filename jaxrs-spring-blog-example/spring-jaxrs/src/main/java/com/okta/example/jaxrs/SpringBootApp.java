package com.okta.example.jaxrs;

import com.okta.example.common.dao.DefaultStormtrooperDao;
import com.okta.example.common.dao.StormtrooperDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApp {

    @Bean
    protected StormtrooperDao stormtrooperDao() {
        return new DefaultStormtrooperDao();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

}
