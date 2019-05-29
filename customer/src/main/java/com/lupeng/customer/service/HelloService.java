package com.lupeng.customer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
//当无法调用hiService时，自动调用hiError
//    @HystrixCommand(fallbackMethod = "hiError")
//    public String hiService(String name)
//    {
//       Object forEntity = restTemplate.getForEntity("http://SERVICE-HI/hi?name=" + name, Object.class);
//        return forEntity.toString();
//    }
//    public String hiError(String name){
//
//        return  "hey "+ name + ", there is some problem with hi page";
//    }

}
