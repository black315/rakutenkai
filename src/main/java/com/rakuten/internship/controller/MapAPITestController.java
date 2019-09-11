package com.rakuten.internship.controller;

import com.rakuten.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapAPITestController {

    @Autowired
    private UserService userService;

    @GetMapping("/testpage")
    public String home(Model model){
        model.addAttribute("users", userService.findUsers());
        return "MapAPI_testpage";
    }

    @PostMapping("/testpage")
    public String search(Model model) {
        return "MapAPI_testpage";
    }

}
