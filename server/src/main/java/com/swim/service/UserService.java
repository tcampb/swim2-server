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
            return user;
        } else {
            return null;
        }
    }

    public User getUserByUserName(String username) {
        User user = userDao.getUserByUsername(username);
        return user;
    }


}
