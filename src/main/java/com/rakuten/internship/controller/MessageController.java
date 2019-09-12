package com.rakuten.internship.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.rakuten.internship.session.LogIn;
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
    private LogIn login;

	@Autowired
	MessageRepository messageRepositoy;

    @GetMapping("")
    public String message(Model model){
        Integer idFrom = login.getUserId();
        Integer idTo = login.getV_userId();
        List<Message> messages = messageRepositoy.findByUserIds(idFrom, idTo);
        model.addAttribute("idFrom", idFrom);
        model.addAttribute("idTo", idTo);
    	model.addAttribute("messages", messages);
    	return "contact";
    }

    @PostMapping("/send")
    public String send(@ModelAttribute Message message, Model model) {
        LocalDateTime now = LocalDateTime.now();
        message.setTimestamp(now);
        messageRepositoy.save(message);
        return "redirect:/message";
    }

}