package org.sample.spring.scheduler;

import java.util.Calendar;

public class SendEmailTask {
    
    public void sendEmail() {
        System.out.println("Sending email at " + Calendar.getInstance().getTime());
    }
}
