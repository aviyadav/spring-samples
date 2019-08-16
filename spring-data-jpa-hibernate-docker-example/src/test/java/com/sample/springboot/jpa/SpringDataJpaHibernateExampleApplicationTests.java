package com.sample.springboot.jpa;

import com.sample.springboot.jpa.resource.UserRepository;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringDataJpaHibernateExampleApplicationTests {
    
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    UserRepository userRepository;
    
    @Test
    public void contextLoads() throws Exception {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/all/").accept(MediaType.APPLICATION_JSON)).andReturn();
        
        System.out.println(mvcResult.getResponse());
        
        verify(userRepository).findAll();
    }
}
