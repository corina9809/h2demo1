package com.thema.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/createTable", method = RequestMethod.GET)
    public void createTable(){
        String sql = "create table customerdata (ID INT , name VARCHAR(255), age VARCHAR(255))";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/putData", method = RequestMethod.GET)
    public void putData(){
        String sql = "insert into customerdata (ID , name , age ) values (1, 'Lola', '20')";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
