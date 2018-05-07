package org.sample.springboot;

import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageCreator implements CommandLineRunner {
    
    @Autowired
    private JmsMessagingTemplate jmsTemplate;
    
    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        
        for (int i = 0; i < 10; i++) {
            jmsTemplate.convertAndSend(queue, "Some Message - TEST {" + i + "}");
        }
        System.out.println("Message has been put to queue by sender");
    }
}
