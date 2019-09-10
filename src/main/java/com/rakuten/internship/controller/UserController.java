package com.rakuten.internship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
        model.addAttribute("users", userService.findUsers());
        return "profiles";
    }
}

