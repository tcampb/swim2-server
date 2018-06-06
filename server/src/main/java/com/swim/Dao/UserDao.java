package com.swim.Dao;

import com.swim.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public User getUserByUsername(String username) {
        List<User> list = new ArrayList<>();
        try {
            list = jdbcTemplate.query("SELECT * FROM users WHERE username = " + "'" + username + "'", new BeanPropertyRowMapper<User>(User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list.get(0);
    }
}
