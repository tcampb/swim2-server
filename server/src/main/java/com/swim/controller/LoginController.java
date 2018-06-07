package com.swim.controller;

import com.swim.model.User;
import com.swim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @CrossOrigin("http://localhost:3001")
    public Map<String, String> login(@RequestBody Map<String, String> userMap) {
        Map<String, String> resMap = new HashMap<>();
        User user;
        user = userService.getUserByUserName(userMap.get("username"));
        if (user != null) {
            user = userService.authenticateUser(user, userMap.get("password"));
            if (user != null) {
                resMap.put("role", user.getRole());
            } else {
                resMap.put("role", "invalid");

            }
        } else {
            resMap.put("role", "user does not exist");
        }
        return resMap;
    }

}
