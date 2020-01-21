package org.sample.spring.data.couchbase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sample.spring.data.couchbase.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {
    
    @Autowired
    protected BuildingRepository repository;
    
    @Before
    public void deleteAll() {
        repository.deleteAll();
    }
    
    @Test
    public void contextLoads() {
        
    }

}
