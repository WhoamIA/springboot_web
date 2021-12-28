package com.example.springboot_web.controller;

import com.example.springboot_web.bean.Car;
import com.example.springboot_web.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConroller {
    @RequestMapping("/hello")
    public String hello() {
        return "hello,springboot2.0!";
    }

    @Autowired
    Car car;
    @RequestMapping("/car")
    @ResponseBody
    public Car getCar(){
        return car;
    }

}
