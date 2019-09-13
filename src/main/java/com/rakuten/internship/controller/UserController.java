package com.rakuten.internship.controller;

import com.rakuten.internship.entity.LocationForm;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.service.LocationService;
import com.rakuten.internship.service.TagService;
import com.rakuten.internship.service.UserService;
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
import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @Autowired
    private LogIn login;

	
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

        User usr = new User();

        Random r = new Random();
        float dummyLat = 35.6733308f;
        float dummyLong = 139.750137f;

        usr.setLatitude(locationForm.getLatitude().equals("0")? dummyLat : Float.parseFloat( locationForm.getLatitude()));
        usr.setLongitude(locationForm.getLongitude().equals("0")? dummyLong : Float.parseFloat(locationForm.getLongitude()));

        model.addAttribute("user", usr);
        model.addAttribute("city", locationForm.getCity());
        model.addAttribute("tags", tagService.findTags());
        return "sign_up";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, BindingResult bindingResult, ModelMap model) {
        if(bindingResult.hasErrors()){
            return "error";
        }

        user.setBirthdate(user.getBirthdate().replace("-","/")); //Fix to insert the correct format
        user.setRole("USER");
        userService.save(user);
        return "complete";
    }

    @RequestMapping(value = "/user", method = POST)
    public String viewDetailsSignIn(@ModelAttribute User user,
                                    ModelMap model) {

        //Verify if the user is correct
        List<User> HitUsers = userService.findUsersFromUsername(user.getUsername());

        for(int i = 0; i < HitUsers.size(); i++){
            User find_user = HitUsers.get(i);
            if(find_user.getPassword().equals(user.getPassword()))
            {
                login.setUserId(find_user.getId());
                if (login.getV_userId() == null){
                    if (login.getLink_before() == 1) { //Appointment list
                        return "redirect:/appointmentList";
                    }
                    else {
                        return "redirect:/user/";
                    }
                }
                return "redirect:/user/" + login.getV_userId();
            }
        }
        return "sign_in";
    }
    @RequestMapping(value = "/out", method = GET)
    public String logout(){
        login.setUserId(null);
        login.setV_userId(null);

        return "redirect:/";
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

