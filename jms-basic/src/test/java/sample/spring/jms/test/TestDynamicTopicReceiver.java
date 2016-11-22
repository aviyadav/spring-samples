package sample.spring.jms.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.spring.jms.model.Notification;
import sample.spring.jms.producer.Producer;
import sample.spring.jms.receiver.DynamicTopicReceiver;
import sample.spring.jms.receiver.NotificationRegistry;

@ContextConfiguration(locations = {"/spring/jms/config/jms-config.xml", "/spring/jms/config/app-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDynamicTopicReceiver {

    @Autowired
    private Producer producer;

    @Autowired
    private NotificationRegistry registry;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private Topic destination;

    @Before
    public void prepareTest() {
        registry.clear();
    }

    @Test
    public void testTopicSending() throws JMSException, InterruptedException {
        Notification notification = new Notification("3", "this is a topic");

        Connection con = connectionFactory.createConnection();
        con.start();
        createDynamicReceiver(con);
        producer.convertAndSendTopic(notification);

        Thread.sleep(2000);
        con.close();

        assertEquals(3, registry.getReceivedNotifications().size());
        assertEquals("this is a topic", registry.getReceivedNotifications().get(0).getMessage());
        assertEquals("this is a topic", registry.getReceivedNotifications().get(1).getMessage());
    }

    private void createDynamicReceiver(Connection con) throws JMSException {
        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(destination);
        MessageListener listener = new DynamicTopicReceiver(registry);
        consumer.setMessageListener(listener);
    }
}
