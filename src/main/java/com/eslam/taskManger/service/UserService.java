package com.eslam.taskManger.service;

import com.eslam.taskManger.entity.User;
import com.eslam.taskManger.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public User findUserByName(String username);
    public void save(WebUser user);
    public List<User> findAll();
}
