package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    public List<User> findByFirstNameIgnoreCase(String firstName);
    public List<User> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);
    public User findByMobileNoIgnoreCase(String mobileNo);
    public User findByEmailIgnoreCase(String email);
    public User findByEmailAndPassword(String email, String password);
}
