package sample.spring.jms.test;

import java.rmi.RemoteException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.spring.jms.model.Notification;
import sample.spring.jms.producer.Producer;
import sample.spring.jms.receiver.SyncReceiver;

@ContextConfiguration(locations = {"/spring/jms/config/jms-config.xml", "/spring/jms/config/app-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSyncMessaging {

    @Autowired
    private Producer producer;

    @Autowired
    private SyncReceiver syncReceiver;

    @Test
    public void testSynchronizedReceiving() throws InterruptedException, RemoteException {
        Notification notification = new Notification("1", "this is a message");
        //Sends the message to the jmsTemplate's default destination
        producer.convertAndSendMessage(notification);

        Thread.sleep(2000);

        Notification receivedNotification = syncReceiver.receive();
        assertNotNull(receivedNotification);
        assertEquals("this is a message", receivedNotification.getMessage());
    }
}
