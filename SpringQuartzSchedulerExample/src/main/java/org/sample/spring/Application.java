package org.sample.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("quartz-config.xml");
    }
}
