package com.mhj.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Slf4j
public class DemoApplication {



    public static void main(String[] args) {

        ConfigurableApplicationContext run =
                SpringApplication.run(DemoApplication.class, args);


    }
}
