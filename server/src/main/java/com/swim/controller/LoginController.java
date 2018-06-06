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
        try {
            User user = userService.authenticateUser(userMap.get("username"), userMap.get("password"));
            resMap.put("role", user.getRole());
            return resMap;
        } catch (Exception e) {
            resMap.put("role", "invalid");
            return resMap;
        }

    }
}
