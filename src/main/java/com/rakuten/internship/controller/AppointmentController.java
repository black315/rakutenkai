package com.rakuten.internship.controller;

import com.rakuten.internship.entity.Appointment;
import com.rakuten.internship.service.AppointmentService;
import com.rakuten.internship.service.TagService;
import com.rakuten.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    private TagService tagService;
    private UserService userService;

    @GetMapping("/appointment")
    public String appointment(Model model){

        List<Appointment> appointment;

        appointment = appointmentService.findAppointments();
        model.addAttribute("appointment", appointment);

        return "appointment";
    }
}
