package sample.spring.jms.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.spring.jms.model.Notification;
import sample.spring.jms.producer.Producer;
import sample.spring.jms.receiver.NotificationRegistry;

@ContextConfiguration(locations = {"/spring/jms/config/jms-iter-config.xml", "/spring/jms/config/app-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIterateToTopic {

    @Autowired
    private Producer producer;

    @Autowired
    private NotificationRegistry registry;

    @Before
    public void prepareTest() {
        registry.clear();
    }

    @Test
    public void testTopicSending() throws InterruptedException {
        Notification notification = null;

        for (int i = 1; i < 11; i++) {
            notification = new Notification(String.valueOf(i), "this is a topic");
            producer.convertAndSendTopic(notification);
        }

        Thread.sleep(2000);
        assertEquals(10, registry.getReceivedNotifications().size());
    }
}
