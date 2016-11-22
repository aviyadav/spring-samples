package sample.spring.jms.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.spring.jms.model.Notification;

@Component("asyncReceiver")
public class AsyncReceiver {
    
    @Autowired
    private NotificationRegistry registry;
    
    public void reveiveMessage(Notification notification) {
        registry.registerNotification(notification);
    }
}
