package sample.spring.jms.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.spring.jms.model.Notification;
import sample.spring.jms.producer.Producer;
import sample.spring.jms.receiver.NotificationRegistry;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {"/spring/jms/config/jms-config.xml", "/spring/jms/config/app-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAsyncMessaging {

    @Autowired
    private Producer producer;
    
    @Autowired
    private NotificationRegistry registry;
    
    @Before
    public void prepareTest() {
        registry.clear();
    }
    
    @Test
    public void testAsynchronizedReceiving() throws InterruptedException {
        Notification notification = new Notification("2", "this is another message");
        producer.convertAndSendMessage("test.async.queue", notification);
        
        Thread.sleep(2000);
        
        assertEquals(1, registry.getReceivedNotifications().size());
        assertEquals("this is another message", registry.getReceivedNotifications().get(0).getMessage()); 
    }
}
