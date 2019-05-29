package com.lupeng.customer.serviceFeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-HI")
public interface HelloServiceFeign {

    @RequestMapping(value="/hi", method= RequestMethod.GET)
    Object home(@RequestParam("name") String name);
}
