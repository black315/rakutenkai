package com.rakuten.internship.controller;

import com.rakuten.internship.entity.Appointment;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.service.AppointmentService;
import com.rakuten.internship.service.TagService;
import com.rakuten.internship.service.UserService;
import com.rakuten.internship.session.LogIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogIn login;

    @GetMapping("/appointment")
    public String appointment(Model model){

        List<Appointment> appointment;

        appointment = appointmentService.findAppointments();
        model.addAttribute("appointment", appointment);

        return "appointment";
    }

    @GetMapping("/appointmentList")
    public String getAppointmentList(Model model){
        System.out.println("hello");

        Integer requesterId = login.getUserId();
        System.out.println(requesterId);
        if (requesterId == null){
            model.addAttribute("user", new User());
            login.setLink_before(1);
            return "sign_in";
        }

        List<Appointment> appointments = null;

        User requester = userService.findUserById(requesterId);

        appointments = appointmentService.findAppointmentsByRequester(requester);
        model.addAttribute("appointments", appointments);

        return "appointment_list";

    }

}
