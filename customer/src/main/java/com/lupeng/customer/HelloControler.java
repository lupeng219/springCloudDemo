package com.lupeng.customer;


import com.lupeng.customer.service.HelloService;
import com.lupeng.customer.serviceFeign.HelloServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RefreshScope
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;
    @Autowired
    HelloServiceFeign helloServiceFeign;

//    @RequestMapping(value = "/hi")
//    public String hi(@RequestParam String name)
//    {
//        return helloService.hiService(name);
//    }
    @Value("${hello}")
    private String hello;

    @RequestMapping("hello")
    public String hello() {
        return hello;
    }

    @RequestMapping(value = "/hii")
    @HystrixCommand(fallbackMethod = "hiError")
    @ResponseBody
    public  Object hii(@RequestParam String name) {
        return  helloServiceFeign.home(name);
    }

    public String hiError(String name){
        return  "hey "+ name + ", there is some problem with hi page";
    }
}
