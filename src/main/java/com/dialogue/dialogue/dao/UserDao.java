package com.dialogue.dialogue.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createUserTable(){
        String query = "CREATE TABLE USER()";
        return 0;
    }
}
