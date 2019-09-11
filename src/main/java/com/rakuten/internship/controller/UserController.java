package com.rakuten.internship.controller;

import com.rakuten.internship.entity.Tag;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.service.TagService;
import com.rakuten.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String home(Model model){
//        createTestData();
        model.addAttribute("tags", tagService.findTags());
        return "home";
    }

    private void createTestData() {
        Tag n = new Tag();
        n.setName("Hospital");
        tagService.save(n);
    }

    @GetMapping("/search")
    public String search(Model model) {

        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        System.out.println(users);
        //TODO: Input the right View name
        return "output";
    }

}

