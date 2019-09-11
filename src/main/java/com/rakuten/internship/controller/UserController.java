package com.rakuten.internship.controller;

import com.rakuten.internship.entity.LocationForm;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.service.LocationService;
import com.rakuten.internship.service.TagService;
import com.rakuten.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserController {
	
    @Autowired
    private LocationService locationService;
    
    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){
    	String ipAddress = request.getHeader("X-Forwarded-For");
    	if (ipAddress == null) ipAddress = request.getRemoteAddr();
    	LocationForm locationForm = locationService.convertIpAddressToLocationForm(ipAddress);
    	model.addAttribute("city", locationForm.getCity());
    	model.addAttribute("tags", tagService.findTags());
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
        return "complete";
    }

    @RequestMapping(value = "/user/{id}", method = GET)
    public String viewDetails(Model model, @PathVariable("id") Integer id){
        //get the ID value
        //Lookup that user in the DB to get the object
        //set that object to the model
        //return the view name
        model.addAttribute("user", userService.findUserById(id));
        System.out.println(userService.findUserById(id));
        //TODO: Input the right View name
        return "sign_up";
    }
}

