package jcg.demo.service;
 
import org.springframework.stereotype.Service;
 
import jcg.demo.model.CallDetailRecord_Rich;
import jcg.demo.model.CallDetailRecord_Simple;
 
@Service
public class CallDetailRecordService {
    public CallDetailRecord_Rich enrich(CallDetailRecord_Simple simpleCDR) {
        System.out.println("\tCallDetailRecordService enrich()");
        CallDetailRecord_Rich richCdr = new CallDetailRecord_Rich();
 
        richCdr.setCallerId(simpleCDR.getCallerId());
        richCdr.setCalling(simpleCDR.getCalling());
        richCdr.setBillingAccount("BTN" + simpleCDR.getCallerId());
 
        return richCdr;
    }
 
    public void save(CallDetailRecord_Rich richCdr) {
        System.out.println("\tCallDetailRecordService save()");
    }
 
}