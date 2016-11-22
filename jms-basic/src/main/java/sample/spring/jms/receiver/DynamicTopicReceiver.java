package sample.spring.jms.receiver;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.springframework.jms.support.JmsUtils;
import sample.spring.jms.model.Notification;

public class DynamicTopicReceiver implements MessageListener {
    
    private NotificationRegistry registry;

    public DynamicTopicReceiver() {
    }

    public DynamicTopicReceiver(NotificationRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void onMessage(Message msg) {
        try {
            Notification notification = (Notification) ((ObjectMessage) msg).getObject();
            registry.registerNotification(notification);
        } catch (JMSException ex) {
            Logger.getLogger(DynamicTopicReceiver.class.getName()).log(Level.SEVERE, null, ex);
            throw JmsUtils.convertJmsAccessException(ex);
        }
    }

}
