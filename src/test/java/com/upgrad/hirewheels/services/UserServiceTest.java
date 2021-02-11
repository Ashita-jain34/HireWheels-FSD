package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.BadCredentialsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    RoleDao roleDao;

    @Test
    public void testCreateUser() {
        User user = new User("User1", "HireWheels", "user@123", "user1@gmail.com",
                "9090909090", 12000, roleDao.findById(2).get());
        User savedUser = userService.createUser(user);
        Assertions.assertNotNull(user);
        Assertions.assertTrue(savedUser.getUserId() != 0);
        Assertions.assertEquals("User1", savedUser.getFirstName());
    }

    @Test
    public void testGetUser() throws BadCredentialsException {
        User user = new User("User2", "HireWheels", "user@456", "user2@gmail.com",
                "9123456780", 11000, roleDao.findById(2).get());
        user = userService.createUser(user);
        User savedUser = userService.getUser(user);
        Assertions.assertNotNull(user);
        Assertions.assertTrue(savedUser.getUserId() != 0);
        Assertions.assertEquals("User2", savedUser.getFirstName());
    }
}
