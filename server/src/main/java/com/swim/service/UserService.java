package com.swim.service;

import com.swim.Dao.UserDao;
import com.swim.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User authenticateUser(User user, String password) {
        if (user.getPassword().equals(password)) {
            System.out.println("Password correct");
            return user;
        } else {
            System.out.println("Invalid password");
            return null;
        }
    }

    public User getUserByUserName(String username) {
        User user = userDao.getUserByUsername(username);
        return user;
    }


}
