package com.rakuten.internship.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<Message> messages = messageRepositoy.findByUserIds(2, 1);
        //List<Message> messages = messageRepositoy.findByUserIds(contactForm.getIdFrom(), contactForm.getIdTo());
        model.addAttribute("id", 2);
        //model.addAttribute("id", contactForm.getIdFrom());
    	model.addAttribute("messages", messages);
    	return "contact";
    }

    @PostMapping("/send")
    public String send(@ModelAttribute Message message, Model model) {
        LocalDateTime now = LocalDateTime.now();
        message.setTimestamp(now);
        messageRepositoy.save(message);
        return "redirect:/message/contact";
    }

}