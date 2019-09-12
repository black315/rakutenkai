package com.rakuten.internship.service;

import com.rakuten.internship.entity.Appointment;
import com.rakuten.internship.entity.User;
import com.rakuten.internship.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> findAppointments(){
        return appointmentRepository.findAll();
    }

    public List<Appointment> findAppointmentsByRequester(User requester){
        return appointmentRepository.findByRequester(requester);
    }
}
