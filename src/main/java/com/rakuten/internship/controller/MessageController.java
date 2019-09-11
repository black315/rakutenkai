package com.rakuten.internship.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {
	
//	@Autowired
//	MessageService messageService;
	
//	@Autowired
//	MessageRepository messageRepositoy;
	
    @GetMapping("/contact")
    public String contact(Model model){
    	// TODO Implement these below
//    	List<Message> messages = messageRepositoy.findByRoomIdAndUserIdsAndDeletedFalse();
//    	List<MessageForm> messageForms = MessageService.convertEntitiesToForms(messages);
    	List<String> messageForms = Arrays.asList("message1", "message2", "message3");
    	model.addAttribute("id", 1);
    	model.addAttribute("messages", messageForms);
    	return "contact";
    }

    @GetMapping("/send")
    public String send(Model model) {
        return "send";
    }

}