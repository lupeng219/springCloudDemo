package com.lupeng.customer;


import com.lupeng.customer.service.HelloService;
import com.lupeng.customer.serviceFeign.HelloServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;
    @Autowired
    HelloServiceFeign helloServiceFeign;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name)
    {
        return helloService.hiService(name);
    }

    @RequestMapping(value = "/hii")
    public  Object hii(@RequestParam String name) {
        return  helloServiceFeign.getName(name);
    }

}
