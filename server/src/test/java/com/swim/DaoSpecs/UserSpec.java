package com.swim.DaoSpecs;

import com.swim.Dao.UserDao;
import com.swim.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSpec {

    @Autowired
    UserDao userDao;

    @Test
    public void getUserByUsername() {
        User user = userDao.getUserByUsername("test");
        Assert.assertEquals("admin", user.getRole());
    }

}
