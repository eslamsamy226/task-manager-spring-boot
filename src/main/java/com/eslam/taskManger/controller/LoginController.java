package com.eslam.taskManger.controller;

import com.eslam.taskManger.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private HttpSession session;

    @Autowired
    public LoginController(HttpSession session) {
        this.session = session;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}

