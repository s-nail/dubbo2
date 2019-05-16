package com.hundsun.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hundsun.domain.City;
import com.hundsun.domain.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 城市 Dubbo 服务消费者
 */
@Component
public class CityDubboConsumerService {
    private static int i = 0;

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    @Reference(version = "1.0.0")
    UserService userService;

    public void printCity() {
        String cityName = "广州";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }


    public User saveUser() {
        User user = new User();
        user.setUsername("Jackson");
        user.setPassword("admin@" + (i++));
        int i = userService.saveUser(user);
        System.out.println("Time:" + new Date() + "，插入条数：" + i);
        List<User> list = userService.listUser();
        System.out.println(list);
        return user;
    }
}
