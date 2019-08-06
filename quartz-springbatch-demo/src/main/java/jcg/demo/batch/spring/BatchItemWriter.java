package jcg.demo.batch.spring;

import jcg.demo.model.CallDetailRecord_Rich;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("batchItemWriter")
public class BatchItemWriter implements ItemWriter<CallDetailRecord_Rich> {

    @Override
    public void write(List<? extends CallDetailRecord_Rich> list) throws Exception {
        System.out.println(Thread.currentThread().getName() + "- Inside BatchItemWriter..." + list);
    }
}
