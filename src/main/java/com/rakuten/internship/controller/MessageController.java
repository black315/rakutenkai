package com.rakuten.internship.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rakuten.internship.entity.ContactForm;
import com.rakuten.internship.entity.Message;
import com.rakuten.internship.repository.MessageRepository;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageRepository messageRepositoy;
	
    @GetMapping("/contact")
    public String contact(@ModelAttribute ContactForm contactForm, Model model){
    	List<Integer> userIds = Arrays.asList(contactForm.getIdFrom(), contactForm.getIdTo());
    	List<Message> messages = messageRepositoy.findByUserIdIn(userIds);
    	model.addAttribute("id", contactForm.getIdFrom());
    	model.addAttribute("messages", messages);
    	return "contact";
    }

    @GetMapping("/send")
    public String send(Model model) {
        return "send";
    }

}