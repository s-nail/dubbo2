package com.hundsun.controller;

import com.hundsun.service.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private CityDubboConsumerService service;

    @RequestMapping("/save")
    public Object saveUser() {
        return service.saveUser();
    }
}
