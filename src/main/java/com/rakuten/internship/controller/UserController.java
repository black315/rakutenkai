package com.rakuten.internship.controller;

import com.rakuten.internship.entity.LocationForm;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.service.LocationService;
import com.rakuten.internship.service.TagService;
import com.rakuten.internship.service.UserService;
import com.rakuten.internship.util.AgeUtil;
import com.rakuten.internship.session.LogIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {

    LogIn login = new LogIn();
	
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
    public String search(Model model,
                         @RequestParam("city") Optional<String> city,
                         @RequestParam("tag") Optional<Integer> tagId) {

        List<User> users = null;

        if (tagId.isPresent() && city.isPresent()) {
            users = userService.findUsersByCityAndTag(city.get(), tagService.findByTagId(tagId.get()));
        } else if (city.isPresent()) {
           users = userService.findUsersFromCity(city.get());
        }

        model.addAttribute("users", users);
        return "output";
    }

    @GetMapping("/register")
    public String getRegister(Model model, HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null) ipAddress = request.getRemoteAddr();
        LocationForm locationForm = locationService.convertIpAddressToLocationForm(ipAddress);
        model.addAttribute("user", new User());
        model.addAttribute("city", locationForm.getCity());
        model.addAttribute("tags", tagService.findTags());
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

    @RequestMapping(value = "/user", method = POST)
    public String viewDetailsSignIn(@ModelAttribute User user,
                                    ModelMap model) {

        //Verify if the user is correct
        List<User> AllUsers = userService.findUsers();
        System.out.println(user.getUsername());
//        String filepath = AllUsers.Find(x => x.name == 0);

        //todo: check with database
        login.setUserId(5);

        return "redirect:/user/" + login.getV_userId();
    }

    @RequestMapping(value = "/user/{id}", method = GET)
    public String viewDetails(Model model, @PathVariable("id") Integer id){
        //get the ID value
        //Lookup that user in the DB to get the object
        //set that object to the model
        //return the view name

        login.setV_userId(id); //Store the ID fo the user you want to see

        if (login.getUserId() == null) { //If not signed in....
            model.addAttribute("user", new User());
            return "sign_in";
        }
        else { //If signed in, show the requested user...
            model.addAttribute("user", userService.findUserById(id));
            return "detail";
        }
    }
}

