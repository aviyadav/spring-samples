package jcg.demo.batch.spring;

import jcg.demo.model.CallDetailRecord_Rich;
import jcg.demo.model.CallDetailRecord_Simple;
import jcg.demo.service.CallDetailRecordService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("batchItemProcesser")
public class BatchItemProcessor implements ItemProcessor<CallDetailRecord_Simple, CallDetailRecord_Rich> {

    @Autowired
    private CallDetailRecordService cdrService;

    @Override
    public CallDetailRecord_Rich process(CallDetailRecord_Simple cdr) throws Exception {
        System.out.println(Thread.currentThread().getName() + "- Inside BatchItemProcessor..." + cdr);

        return cdrService.enrich(cdr);
    }

}