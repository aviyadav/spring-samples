package jcg.demo.scheduler.quartz2;

import java.time.LocalDateTime;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import jcg.demo.model.CallDetailRecord_Rich;
import jcg.demo.model.CallDetailRecord_Simple;
import jcg.demo.service.CallDetailRecordService;

public class QuartzJob implements Job {

    private CallDetailRecordService cdrService = new CallDetailRecordService();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LocalDateTime localTime = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName() + ": Run QuartzJob at " + localTime.toString());

        CallDetailRecord_Simple simpleCDR = dummySimpleCDR();
        CallDetailRecord_Rich richCDR = cdrService.enrich(simpleCDR);
        cdrService.save(richCDR);
    }
    
    private CallDetailRecord_Simple dummySimpleCDR() {

        CallDetailRecord_Simple cdr = new CallDetailRecord_Simple();
        cdr.setCallerId("3145791111");
        cdr.setCalling("6365272222");
        return cdr;
    }

}