package com.rakuten.internship.controller;

import com.rakuten.internship.entity.LocationForm;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.service.LocationService;
import com.rakuten.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}