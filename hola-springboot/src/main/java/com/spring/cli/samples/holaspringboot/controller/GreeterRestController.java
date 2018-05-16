package com.spring.cli.samples.holaspringboot.controller;

import com.spring.cli.samples.holaspringboot.dto.BackendDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "greeting")
public class GreeterRestController {

    private RestTemplate template = new RestTemplate();
    private String saying;
    private String backendServiceHost;
    private int backendServicePort;

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public String getBackendServiceHost() {
        return backendServiceHost;
    }

    public void setBackendServiceHost(String backendServiceHost) {
        this.backendServiceHost = backendServiceHost;
    }

    public int getBackendServicePort() {
        return backendServicePort;
    }

    public void setBackendServicePort(int backendServicePort) {
        this.backendServicePort = backendServicePort;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/greeting", produces = "text/plain")
    public String greeting() {
        String backendServicieURL = String.format("http://%s:%d/api/backend?greeting={greeting}", backendServiceHost, backendServicePort);
        System.out.println("Sending to : " + backendServicieURL);
        BackendDTO response = template.getForObject(backendServicieURL, BackendDTO.class, saying);
        return response.getGreeting() + " at host: " + response.getIp();
    }
    
}
