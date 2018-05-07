package org.sample.springboot;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    
    @JmsListener(destination = "spring-boot.queue")
    public void receiveQueue(String text) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MessageReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Message Received: " + text);
    }
}
