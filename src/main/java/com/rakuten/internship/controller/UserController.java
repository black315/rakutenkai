package com.rakuten.internship.controller;

import com.rakuten.internship.entity.User;
import com.rakuten.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/search")
    public String search(Model model) {

        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        //TODO: Input the right View name
        return "output";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()){
            return "error";
        }

        userService.save(user);
        System.out.println(user);
        return "sign_up";
    }
}

