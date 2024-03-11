package com.eslam.taskManger.dao;

import com.eslam.taskManger.entity.User;

import java.util.List;

public interface UserDao {
    public User findUserByName(String username);
    public List<User> findAll();
    public void save(User user);

}
