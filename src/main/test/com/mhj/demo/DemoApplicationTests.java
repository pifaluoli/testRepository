package com.mhj.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;


    @Test
    void contextLoad() {
//        jdbcTemplate.queryForList("select * from punch_detail");
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from punch_detail", Long.class);
        log.info("数据源类型：{}",dataSource.getClass());
    }



}
