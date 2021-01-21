package com.mhj.demo.controller;

import com.mhj.demo.domain.Car;
import com.mhj.demo.domain.Person;
import com.mhj.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

@RestController
@Slf4j
public class UserController {

    @Autowired
    Car car;

    @Autowired
    User user;

    @Autowired
    Person person;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/car",method = RequestMethod.GET)
    public Car car(){return car;}

    @RequestMapping("/user")
    public User user(){return user;}

    @RequestMapping("/api")
    public String login(){
        log.info("用户登录了");
        return "logining...";
    }

    @RequestMapping("/person")
    public Person person(){
        log.warn("缺人");
        return person;
    }

    @RequestMapping("/hi/hello")
    public String hello(){
        log.error("出现错误");
        return "hello...";
    }

    @GetMapping("query")
    public String query(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from punch_detail", Long.class);
        System.out.println(aLong);
        log.info(String.valueOf(aLong));
        return "query.....";
    }



}
