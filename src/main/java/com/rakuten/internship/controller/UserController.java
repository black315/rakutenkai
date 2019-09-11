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

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
    @Autowired
    private LocationService locationService;

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){
    	String ipAddress = request.getRemoteAddr();
    	LocationForm locationForm = locationService.convertIpAddressToLocationForm(ipAddress);
    	model.addAttribute("city", locationForm.getCity());
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