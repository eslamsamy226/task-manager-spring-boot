package com.eslam.taskManger.controller;

import com.eslam.taskManger.entity.User;
import com.eslam.taskManger.service.UserService;
import com.eslam.taskManger.user.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private Logger logger = Logger.getLogger(getClass().getName());
    private UserService userService;
    @Autowired
    public RegisterController(UserService userService)
    {
        this.userService=userService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/form")
    public String showRegisterForm(Model model){
        model.addAttribute("webUser",new WebUser());
        return "register-from";
    }

    @PostMapping("/process")
    public String processRegisterForm(
            @Valid @ModelAttribute("webUser") WebUser theWebUser,
            BindingResult theBindingResult,
            HttpSession session, Model theModel
    ){
        String userName = theWebUser.getUserName();
        if (theBindingResult.hasErrors()){
            return "register-from";
        }
        User existing = userService.findUserByName(userName);

        if (existing != null){
            theModel.addAttribute("webUser", new WebUser());
            theModel.addAttribute("registrationError", "User name already exists.");
            logger.warning("User name already exists.");
            return "register-from";
        }
        userService.save(theWebUser);
        session.setAttribute("user", theWebUser);
        theModel.addAttribute("registrationOK", theWebUser.getUserName() +
                " registered successfully");
        return  "redirect:/tasks";
    }

}
