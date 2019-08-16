package jcg.demo.batch.spring;

import jcg.demo.model.CallDetailRecord_Simple;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("batchItemReader")
public class BatchItemReader implements ItemReader<CallDetailRecord_Simple> {

    @Override
    public CallDetailRecord_Simple read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        CallDetailRecord_Simple cdr = buildDummyCDR();
        System.out.println(Thread.currentThread().getName() + "- Inside BatchItemReader..." + cdr);
        return cdr;
    }

    private CallDetailRecord_Simple buildDummyCDR() {

        Random rand = new Random();
        int value = rand.nextInt(10);

        if(value == 0) {
            return null;
        }

        CallDetailRecord_Simple cdr = new CallDetailRecord_Simple();
        cdr.setCallerId("636527222" + value);
        cdr.setCalling("314579111" + value);

        return cdr;
    }
}
